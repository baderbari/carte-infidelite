package uqam.mgl7361.projet.carteinfidelite.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3953808670993136916L;

	@EmbeddedId
	private CarteMagasinPK id;

	@ManyToOne(cascade = {  CascadeType.MERGE })
	@JoinColumn(name = "ID_MAGASIN")
	@MapsId("idMagasin")
	private Magasin magasin;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "ID_CARTE")
	@MapsId("idCarte")
	private Carte carte;

	@Column(name = "DATE_TRANSACTION")
	private Date dateTransaction;

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public CarteMagasinPK getId() {
		return id;
	}

	public void setId(CarteMagasinPK id) {
		this.id = id;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
}
