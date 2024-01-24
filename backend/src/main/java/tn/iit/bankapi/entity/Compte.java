package tn.iit.bankapi.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "t_compte")
public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    @Column(name = "rib_compte", length = 50, nullable = false)
    private int rib;
    @Column(name = "solde_compte", length = 50, nullable = false)

    private float solde;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Client client;

    public Compte(float solde, Client client) {
        super();
        this.solde = solde;
        //this.client = client;
    }


    public int getRib() {
        return rib;
    }

    public void setRib(int rib) {
        this.rib = rib;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
