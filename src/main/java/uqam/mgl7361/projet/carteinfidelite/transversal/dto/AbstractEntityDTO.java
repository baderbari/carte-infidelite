package uqam.mgl7361.projet.carteinfidelite.transversal.dto;


import java.io.Serializable;

public abstract class AbstractEntityDTO implements Serializable, IBeanDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7500592136732815301L;

	private Long id;

	private String uid;

	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
