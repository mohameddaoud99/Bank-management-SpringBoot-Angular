package tn.iit.bankapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.bankapi.dao.ClientDao;
import tn.iit.bankapi.entity.Client;
import tn.iit.bankapi.response.ResponseHandler;
import tn.iit.bankapi.service.impl.ClientServiceImpl;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;
    @Autowired
    ClientDao clientDo;

    @PostMapping("addClient")
    public ResponseEntity<Object> addClient(@RequestBody @Valid Client client) {
        return ResponseHandler.responseBuilder("client added succefully",
                HttpStatus.OK, clientService.addClient(client));
    }

    /*{

        "nom": "amina",
        "prenom": "mmmm",
        "adresse": "gabes",
        "comptes": [
            {
                "rib": 3,
                "solde": 33.22
            }
        ]

}*/


    @PutMapping("updateClient/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable Integer id,@RequestBody @Valid Client client) {
        return ResponseHandler.responseBuilder("client updated succefully",
                HttpStatus.OK, clientService.updateClient(id,client));
    }

    /*{ // update body postman
    "id": 2,
        "nom": "amina",
        "prenom": "mmmm",
        "adresse": "gabes",
        "comptes": [
            {
                "rib": 1,
                "solde": 33.22
            }
        ]
}*/

    @GetMapping("/getClientById/{id}")
    public ResponseEntity<Object> get(@PathVariable Integer id)
    {
        return ResponseHandler.responseBuilder("client for id number "+id ,
                HttpStatus.OK,clientService.getClientById(id));
    }

    /*@GetMapping("/getAll")
    public ResponseEntity<Page<Client>> getAll(Pageable pageable) {
        return ResponseEntity.ok(clientDo.findAll(pageable));
    }*/

    @GetMapping("/getClients")
    public ResponseEntity<Object> getClients()
    {
        return ResponseHandler.responseBuilder("All clients " ,
                HttpStatus.OK,clientService.getClients());
    }

    @DeleteMapping("delete/{clientid}")
    public ResponseEntity DeleteEmployee(@PathVariable int clientid) {
        return ResponseHandler.responseBuilder("client deleted " ,
                HttpStatus.OK,clientService.deleteClient( clientid));
       	}

    @GetMapping("/allByName/{name}")
    public List<Client> getAllClientbyname(@PathVariable String name)
    {
        return clientService.getAllClientByName(name);
    }
}
