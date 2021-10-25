package uqam.mgl7361.projet.carteinfidelite.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import uqam.mgl7361.projet.carteinfidelite.transversal.AbstractEntity;





@Entity
@Table(name = "MAGASIN")
public class Magasin extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1076973299046816245L;

	@Column(name = "LABELLE")
	private String labelle;

	@Column(name = "ADRESSE")
	private String adresse;

	@OneToMany(mappedBy = "magasin", cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Cadeau> listCadeaux;

	@OneToMany(mappedBy = "magasin", cascade = { CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	private List<Transaction> listTransactions;

	@ManyToOne
	@JoinColumn(name = "FK_ZONE")
	@JsonIgnore
	private Zone zone;

	public String getLabelle() {
		return labelle;
	}

	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Cadeau> getListCadeaux() {
		return listCadeaux;
	}

	public void setListCadeaux(List<Cadeau> listCadeaux) {
		this.listCadeaux = listCadeaux;
	}

	public List<Transaction> getListTransactions() {
		return listTransactions;
	}

	public void setListTransactions(List<Transaction> listTransactions) {
		this.listTransactions = listTransactions;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Magasin() {
		super();
	}

}
