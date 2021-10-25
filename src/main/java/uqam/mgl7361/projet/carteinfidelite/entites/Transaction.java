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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3953808670993136916L;

	@EmbeddedId
	private CarteMagasinPK id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "ID_MAGASIN")
	@MapsId("idMagasin")
	@JsonIgnore
	private Magasin magasin;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_CARTE")
	@MapsId("idCarte")
	@JsonIgnore
	private Carte carte;

	@Column(name = "DATE_TRANSACTION")
	private Date dateTransaction;
	
	@Column(name = "MONTANT_TRANSACTION")
	private float montantTransaction;

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public float getMontantTransaction() {
		return montantTransaction;
	}

	public void setmontantTransaction(float montantTransaction) {
		this.montantTransaction = montantTransaction;
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
