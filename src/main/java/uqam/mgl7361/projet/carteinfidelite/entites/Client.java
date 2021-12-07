package uqam.mgl7361.projet.carteinfidelite.entites;

import java.util.Date;

import javax.persistence.*;

import uqam.mgl7361.projet.carteinfidelite.transversal.AbstractEntity;




@Entity
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

	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_CARTE")
	private Carte carte;

	@Column(name = "STATUT")
	private ClientStatut statut;

	public Client() {
		super();
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

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public ClientStatut getStatut() {
		return statut;
	}

	public void setStatut(ClientStatut statut) {
		this.statut = statut;
	}
}
