package uqam.mgl7361.projet.carteinfidelite.entites;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import uqam.mgl7361.projet.carteinfidelite.transversal.AbstractEntity;




@Entity
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
	private Integer points;


	@Column(name = "DATE_EXPIRATION")
	private Date dateExpiration;

	@Column(name = "IS_BLOCKED")
	private Boolean isBlocked;

	@OneToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_CLIENT")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "FK_ZONE")
	private Zone zone;

	@OneToMany(mappedBy = "carte", cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
	private List<Transaction> listTransactions;

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

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public Boolean getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
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

	public Carte() {
		super();
	}
}
