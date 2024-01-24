package tn.iit.bankapi.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.iit.bankapi.entity.Client;
import tn.iit.bankapi.entity.Compte;

import java.util.List;

public interface CompteService {
    public Compte addCompte(Compte compte);

    Compte updateCompte(@PathVariable int compte_id, @RequestBody Compte compte);

    public String deleteCompte(int compteId);
    public Compte getCompteById(int compteId);
    public List<Compte> getComptes();



}
