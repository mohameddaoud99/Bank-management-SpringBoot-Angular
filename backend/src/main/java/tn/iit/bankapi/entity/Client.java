package tn.iit.bankapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "t_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", length = 50, nullable = false)
    private int id;
    @Column(name = "nom_client", length = 50, nullable = false)
    @NotBlank(message = "Le nom du client ne doit pas etre vide")
    @Length(min = 3, max = 20, message = "Le nom du client doit etre entre 3 et 20 characters")
    private String nom;
    @Column(name = "prenom_client", length = 50, nullable = false)
    @NotBlank(message = "Le prenom du client ne doit pas etre vide")
    private String prenom;
    @Column(name = "adresse_client", length = 150, nullable = false)
    @NotBlank(message = "Le adresse du client ne doit pas etre vide")
    private String adresse;


    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Compte> comptes = new HashSet<>();

    public String getLabel()
    {
        return nom + " " + prenom;
    }

    public String getValue()
    {
        return nom + " " + prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;

        for(Compte c : comptes){
            c.setClient(this);
        }
    }
}
