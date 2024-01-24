package tn.iit.bankapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.iit.bankapi.entity.Client;

import java.util.ArrayList;
import java.util.List;

@Repository
    public interface ClientDao extends JpaRepository<Client, Integer> {


    /*@Query("select e.id, e.nom, e.prenom, e.adresse, e.comptes  FROM Client e WHERE e.nom like %:name% ORDER BY e.nom ASC")
    List<Client> findAllClientbyName(@Param("name") String name);*/

    @Query(nativeQuery = true, value="SELECT c.* FROM t_client c WHERE c.nom_client LIKE CONCAT('%', :nc, '%')")
    List<Client> findAllClientbyName(@Param("nc") String name);



    }

