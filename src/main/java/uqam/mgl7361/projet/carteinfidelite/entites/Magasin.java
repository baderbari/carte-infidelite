package uqam.mgl7361.projet.carteinfidelite.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import uqam.mgl7361.projet.carteinfidelite.transversal.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
	@JsonIgnore
	private Zone zone;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

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
}
