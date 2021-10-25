package uqam.mgl7361.projet.carteinfidelite.dto;


import java.util.Date;

import uqam.mgl7361.projet.carteinfidelite.transversal.dto.AbstractEntityDTO;



public class CarteDTO extends AbstractEntityDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3595925732821285664L;

	private Date dateCreation;

	private Integer solde;

	private Date dateExpiration;

	private Boolean isBlocked;

	public CarteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public CarteDTO(Date dateCreation, Integer solde, Date dateExpiration, Boolean isBlocked) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.dateExpiration = dateExpiration;
		this.isBlocked = isBlocked;
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

}
