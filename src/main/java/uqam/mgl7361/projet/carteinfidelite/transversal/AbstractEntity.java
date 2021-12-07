package uqam.mgl7361.projet.carteinfidelite.transversal;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable{
	
	/**
	 * 
	 */
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
