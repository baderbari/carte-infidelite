package uqam.mgl7361.projet.carteinfidelite.entites;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
import uqam.mgl7361.projet.carteinfidelite.transversal.AbstractEntity;




@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@Table(name = "CARTE")
public class Carte extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5092511407884916562L;

	@Column(name = "DATE_CREATION")
	private Date dateCreation;

	@Column(name = "SOLDE")
	private Integer solde;
	
	@Column(name = "POINTS")
	private Float points;


	@Column(name = "DATE_EXPIRATION")
	private Date dateExpiration;

	@Column(name = "IS_BLOCKED")
	private Boolean isBlocked;

	@ManyToOne(fetch = FetchType.LAZY )
	@JsonIgnore
	private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JsonIgnore
	private Zone zone;

	@OneToMany(mappedBy = "carte",cascade=CascadeType.ALL)
	private List<Transaction> listTransactions;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Integer getSolde() {
		return solde;
	}

	public void setSolde(Integer solde) {
		this.solde = solde;
	}

	public Float getPoints() {
		return points;
	}

	public void setPoints(Float points) {
		this.points = points;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public Boolean getBlocked() {
		return isBlocked;
	}

	public void setBlocked(Boolean blocked) {
		isBlocked = blocked;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public List<Transaction> getListTransactions() {
		return listTransactions;
	}

	public void setListTransactions(List<Transaction> listTransactions) {
		this.listTransactions = listTransactions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!( o instanceof Carte )) return false;
		Carte carte = (Carte) o;
		return Objects.equals(getDateCreation(), carte.getDateCreation()) &&
				Objects.equals(getSolde(), carte.getSolde()) &&
				Objects.equals(getPoints(), carte.getPoints()) &&
				Objects.equals(getDateExpiration(), carte.getDateExpiration()) &&
				Objects.equals(isBlocked, carte.isBlocked) &&
				Objects.equals(getClient(), carte.getClient()) &&
				Objects.equals(getZone(), carte.getZone()) &&
				Objects.equals(getListTransactions(), carte.getListTransactions());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDateCreation(), getSolde(), getPoints(), getDateExpiration(), isBlocked, getClient(), getZone(), getListTransactions());
	}
}
