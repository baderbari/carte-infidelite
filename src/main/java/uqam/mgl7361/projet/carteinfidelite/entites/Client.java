package uqam.mgl7361.projet.carteinfidelite.entites;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import lombok.*;
import uqam.mgl7361.projet.carteinfidelite.transversal.AbstractEntity;


@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@ToString
@Table(name = "CLIENT")
public class Client extends AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = -804313006656451515L;

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "DATE_NAISSANCE")
    private Date dateNaissance;

    @OneToMany(mappedBy = "client")
    private List<Carte> carte;

    @Column(name = "STATUT")
    private ClientStatut statut;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Carte> getCarte() {
        return carte;
    }

    public void setCarte(List<Carte> carte) {
        this.carte = carte;
    }

    public ClientStatut getStatut() {
        return statut;
    }

    public void setStatut(ClientStatut statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!( o instanceof Client )) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId()) &&
                Objects.equals(getNom(), client.getNom()) &&
                Objects.equals(getPrenom(), client.getPrenom()) &&
                Objects.equals(getDateNaissance(), client.getDateNaissance()) &&
                Objects.equals(getCarte(), client.getCarte()) &&
                getStatut() == client.getStatut();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom(), getPrenom(), getDateNaissance(), getCarte(), getStatut());
    }
}
