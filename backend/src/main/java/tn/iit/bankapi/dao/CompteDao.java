package tn.iit.bankapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.bankapi.entity.Compte;

@Repository
public interface CompteDao extends JpaRepository<Compte, Integer> {


}

