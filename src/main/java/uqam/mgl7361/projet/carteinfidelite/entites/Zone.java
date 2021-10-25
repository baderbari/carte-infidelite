package uqam.mgl7361.projet.carteinfidelite.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import uqam.mgl7361.projet.carteinfidelite.transversal.AbstractEntity;



@Entity
@Table(name = "ZONE")
public class Zone extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -873699946550337173L;

	@Column(name = "LABELLE")
	private String labelle;

	@Column(name = "VILLE")
	private String ville;

	@OneToMany(mappedBy = "zone", cascade = {CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Carte> listCartes;

	@OneToMany(mappedBy = "zone", cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Cadeau> listCadeaux;

	@OneToMany(mappedBy = "zone", cascade = {CascadeType.ALL }, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Magasin> listMagasins;

	public String getLabelle() {
		return labelle;
	}

	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Carte> getListCartes() {
		return listCartes;
	}

	public void setListCartes(List<Carte> listCartes) {
		this.listCartes = listCartes;
	}

	public List<Cadeau> getListCadeaux() {
		return listCadeaux;
	}

	public void setListCadeaux(List<Cadeau> listCadeaux) {
		this.listCadeaux = listCadeaux;
	}

	public List<Magasin> getListMagasins() {
		return listMagasins;
	}

	public void setListMagasins(List<Magasin> listMagasins) {
		this.listMagasins = listMagasins;
	}

	public Zone() {
		super();
	}
}
