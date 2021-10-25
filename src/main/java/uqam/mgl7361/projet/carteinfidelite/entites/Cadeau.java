package uqam.mgl7361.projet.carteinfidelite.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import uqam.mgl7361.projet.carteinfidelite.transversal.AbstractEntity;


	@Entity
	@Table(name = "cadeau")
	public class Cadeau extends AbstractEntity {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3746317193224413931L;

		@Column(name = "LABELLE")
		private String labelle;

		@Column(name = "DESCRIPTON")
		private String description;

		@Column(name = "NOMBRE_POINT")
		private Integer nbrPoint;

		@ManyToOne
		@JoinColumn(name = "FK_ZONE")
		@JsonIgnore
		private Zone zone;

		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name = "FK_MAGASIN")
		@JsonIgnore
		private Magasin magasin;

		public String getLabelle() {
			return labelle;
		}

		public void setLabelle(String labelle) {
			this.labelle = labelle;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getNbrPoint() {
			return nbrPoint;
		}

		public void setNbrPoint(Integer nbrPoint) {
			this.nbrPoint = nbrPoint;
		}

		public Zone getZone() {
			return zone;
		}

		public void setZone(Zone zone) {
			this.zone = zone;
		}


		public Magasin getMagasin() {
		    return magasin;
		  }

		  public void setMagasin(Magasin magasin) {
			  this.magasin = magasin;
		  }
		
		
		public Cadeau() {
			super();
		}

}