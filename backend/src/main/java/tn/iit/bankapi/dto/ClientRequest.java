package tn.iit.bankapi.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.iit.bankapi.entity.Compte;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor

public class ClientRequest {
    @NotNull(message = " id should not be null")
    private String id ;
    @NotNull(message = "client name should not be null")
    private String nom ;
    @NotNull(message = "user prenom should not be null")
    private String prenom;

    @NotNull(message = "adresse est obligatoire")
    private String adresse ;

    private List<Compte> comptes;


}