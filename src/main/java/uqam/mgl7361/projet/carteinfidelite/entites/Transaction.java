package uqam.mgl7361.projet.carteinfidelite.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3953808670993136916L;

	@EmbeddedId
	private CarteMagasinPK id;

	@ManyToOne(fetch = FetchType.LAZY ,cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "ID_MAGASIN")
	@MapsId("idMagasin")
	@JsonIgnore
	private Magasin magasin;

	@ManyToOne(fetch = FetchType.LAZY ,cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_CARTE")
	@MapsId("idCarte")
	@JsonIgnore
	private Carte carte;

	@Column(name = "DATE_TRANSACTION")
	private Date dateTransaction;
	
	@Column(name = "MONTANT_TRANSACTION")
	private float montantTransaction;

	@Column(name = "TYPE_TRANSACTION")
	private String typeTransaction;

	public static long getSerialVersionUID() {
		return serialVersionUID;
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

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public float getMontantTransaction() {
		return montantTransaction;
	}

	public void setMontantTransaction(float montantTransaction) {
		this.montantTransaction = montantTransaction;
	}

	public String getTypeTransaction() {
		return typeTransaction;
	}

	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}
}
