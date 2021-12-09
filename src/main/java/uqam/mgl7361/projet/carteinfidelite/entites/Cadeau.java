package uqam.mgl7361.projet.carteinfidelite.entites;

import java.util.List;

import javax.persistence.*;

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
	@ToString
	@EqualsAndHashCode
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

		@Column(name = "NOMBRE_ACHAT")
		private Integer nbraCHAT;

		@ManyToOne(fetch = FetchType.LAZY)
		@JsonIgnore
		private Zone zone;

		@ManyToOne(fetch = FetchType.LAZY)
		@JsonIgnore
		private Magasin magasin;

		public static long getSerialVersionUID() {
			return serialVersionUID;
		}

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

		public Integer getNbraCHAT() {
			return nbraCHAT;
		}

		public void setNbrAchat(Integer nbraCHAT) {
			this.nbraCHAT = nbraCHAT;
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
	}