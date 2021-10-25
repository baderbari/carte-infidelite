package uqam.mgl7361.projet.carteinfidelite.entites;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import uqam.mgl7361.projet.carteinfidelite.transversal.AbstractEntity;




@Entity
@Table(name = "CLIENT")
public class Client extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -804313006656451515L;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "DATE_NAISSANCE")
	private Date dateNaissance;

	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_CARTE")
	private Carte carte;

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

}
