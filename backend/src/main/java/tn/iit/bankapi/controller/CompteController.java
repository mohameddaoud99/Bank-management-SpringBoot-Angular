package tn.iit.bankapi.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.bankapi.dao.ClientDao;
import tn.iit.bankapi.dao.CompteDao;
import tn.iit.bankapi.entity.Client;
import tn.iit.bankapi.entity.Compte;
import tn.iit.bankapi.response.ResponseHandler;
import tn.iit.bankapi.service.impl.ClientServiceImpl;
import tn.iit.bankapi.service.impl.CompteServiceImpl;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/comptes")
public class CompteController {

    @Autowired
    CompteServiceImpl compteService;

    @Autowired
    ClientDao clientDao;

    @Autowired
    CompteDao compteDao;

    @PostMapping("addCompte")
    public ResponseEntity<Object> addCompte(@RequestBody @Valid Compte compte) {
        return ResponseHandler.responseBuilder("compte added succefully",
                HttpStatus.OK, compteService.addCompte(compte));
    }

    /*
    {
    "rib":22222,
    "solde":12.22,
    "client":
        {
            "id": 2,
            "name": "amina",
            "prenom":"amina",
            "adresse": "gabes"
        }
}
     */

    /*@PutMapping("updateCompte/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable Integer id,@RequestBody @Valid Compte compte) {
        //return ResponseEntity.noContent().build();
        return ResponseHandler.responseBuilder("compte added succefully",
                HttpStatus.OK, compteService.updateCompte(id,compte));
    }*/

    @PutMapping("updateCompte/{id}")
    public ResponseEntity<Compte> update(@RequestBody  Compte compte, @PathVariable Integer id) {
        Optional<Client> optionalClient = clientDao.findById(compte.getClient().getId());
        if (!optionalClient.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Compte> optionalCompte = compteDao.findById(id);
        if (!optionalCompte.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        compte.setClient(optionalClient.get());
        compte.setRib(optionalCompte.get().getRib());
        compte.setSolde(optionalCompte.get().getSolde());
        compteDao.save(compte);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getCompteById/{id}")
    public ResponseEntity<Object> get(@PathVariable Integer id)
    {
        return ResponseHandler.responseBuilder("compte for id number "+id ,
                HttpStatus.OK,compteService.getCompteById(id));
    }

    @GetMapping("/getComptes")
    public ResponseEntity<Object> getComptes()
    {
        return ResponseHandler.responseBuilder("All clients " ,
                HttpStatus.OK,compteService.getComptes());
    }


    @DeleteMapping("delete/{compteid}")
    public ResponseEntity DeleteEmployee(@PathVariable int compteid) {
        return ResponseHandler.responseBuilder("compte deleted " ,
                HttpStatus.OK,compteService.deleteCompte( compteid));
    }



}
