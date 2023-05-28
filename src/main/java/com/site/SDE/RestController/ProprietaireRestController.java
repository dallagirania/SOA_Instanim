package com.site.SDE.RestController;

import com.site.SDE.Entite.Proprietaire;
import com.site.SDE.Repository.ProprietaireRepository;
import com.site.SDE.Service.ProprietaireService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/proprietaire")
public class ProprietaireRestController {

    @Autowired
    private ProprietaireRepository proprietaireRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public ProprietaireRestController(ProprietaireRepository candidatRepository) {this.proprietaireRepository= proprietaireRepository;}

    @PostMapping(path = "loginproprietaire")
    public ResponseEntity<Map<String, Object>> loginAdmin(@RequestBody Proprietaire proprietaire) {

        HashMap<String, Object> response = new HashMap<>();

        Proprietaire userFromDB = proprietaireRepository.findIdByEmail(proprietaire.getEmail());

        if (userFromDB == null) {
            response.put("message", "Proprietaire not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }  else {
            String token = Jwts.builder()
                    .claim("data", userFromDB)
                    .signWith(SignatureAlgorithm.HS256, "SECRET")
                    .compact();
            response.put("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
    @PostMapping(path = "registerproprietaire")
    public ResponseEntity<?> addProprietaire(@RequestBody Proprietaire proprietaire) {
        if(proprietaireRepository.existsByEmail(proprietaire.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        proprietaire.setMdp(this.bCryptPasswordEncoder.encode(proprietaire.getMdp()));
        Proprietaire savedUser = proprietaireRepository.save(proprietaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @Autowired
    ProprietaireService proprietaireService;

    @RequestMapping(method = RequestMethod.POST)
    public Proprietaire ajouterProprietaire(@RequestBody Proprietaire proprietaire){
        return proprietaireService.ajouterProprietaire(proprietaire);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Proprietaire modifierAdmin(@PathVariable("id")Long id,@RequestBody Proprietaire proprietaire){
        Proprietaire newproprietaire=proprietaireService.modifierProprietaire(proprietaire);
        return newproprietaire;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Proprietaire>GetProprietaireById(@PathVariable("id")Long id){
        Optional<Proprietaire>proprietaire=proprietaireService.FindById(id);
        return proprietaire;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerProprietaire(@PathVariable("id")Long id){
        proprietaireService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Proprietaire> listProprietaire(){
        return proprietaireService.listProprietaire();
    }

    @RequestMapping(method = RequestMethod.GET,value = "GetProprietaireByAnimalId/{id}")
    public Proprietaire findProprietaireByAnimalId(@PathVariable("id")Long id){
        Proprietaire newProp=proprietaireRepository.findProprietaireByAnimalId(id);
        return newProp;
    }

}
