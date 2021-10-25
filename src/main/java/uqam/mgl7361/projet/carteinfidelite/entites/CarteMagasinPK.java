package uqam.mgl7361.projet.carteinfidelite.entites;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CarteMagasinPK implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5797211116754612438L;

	private Long idMagasin;
	
	private Long idCarte;

	public Long getIdMagasin() {
		return idMagasin;
	}

	public void setIdMagasin(Long idMagasin) {
		this.idMagasin = idMagasin;
	}

	public Long getIdCarte() {
		return idCarte;
	}

	public void setIdCarte(Long idCarte) {
		this.idCarte = idCarte;
	}

	
}
