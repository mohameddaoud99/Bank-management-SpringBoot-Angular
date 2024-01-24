package tn.iit.bankapi.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.iit.bankapi.dao.ClientDao;
import tn.iit.bankapi.dao.CompteDao;
import tn.iit.bankapi.entity.Client;
import tn.iit.bankapi.entity.Compte;
import tn.iit.bankapi.exceptions.ClientNotFoundException;
import tn.iit.bankapi.service.ClientService;
import tn.iit.bankapi.service.CompteService;

import java.util.List;
import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService {

    private CompteDao compteDao;
    private ClientDao clientDao;

    public CompteServiceImpl(CompteDao compteDao)
    {
        this.compteDao=compteDao;
        this.clientDao=clientDao;
    }


    @Override
    public Compte addCompte(Compte compte) {
        return compteDao.save(compte);
    }

    @Override
    public Compte updateCompte(@PathVariable int id, @RequestBody Compte compte) {


        Optional<Client> optionalClient = clientDao.findById(compte.getClient().getId());

        Optional<Compte> optionalCompte = compteDao.findById(id);

        compte.setSolde(optionalCompte.get().getSolde());
        compte.setClient(optionalClient.get());
        compte.setRib(optionalCompte.get().getRib());

        compteDao.save(compte);
        return compte;
    }

    /*@PutMapping("update/{id}")
    public ResponseEntity<Book> update(@RequestBody  Book book, @PathVariable Integer id) {
        Optional<Library> optionalLibrary = libraryRepository.findById(book.getLibrary().getId());
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Book> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        book.setLibrary(optionalLibrary.get());
        book.setId(optionalBook.get().getId());
        bookRepository.save(book);

        return ResponseEntity.noContent().build();
    }*/

    @Override
    public String deleteCompte(int compteId) {
        compteDao.deleteById(compteId);
        return "Success";
    }


    @Override
    public Compte getCompteById(int compteId) {
        if(compteDao.findById(compteId).isEmpty())
        {
            throw new ClientNotFoundException("id does not exist");
        }
        return compteDao.findById(compteId).get();
    }

    @Override
    public List<Compte> getComptes() {
        if(compteDao.findAll().isEmpty())
        {
            throw new ClientNotFoundException("id does not exist");
        }
        return compteDao.findAll();
    }
}
