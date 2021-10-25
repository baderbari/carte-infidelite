package uqam.mgl7361.projet.carteinfidelite.transversal.service;

import uqam.mgl7361.projet.carteinfidelite.transversal.dto.IBeanDTO;

public interface ITemplateCustomService {

	/**
	 * cette méthode regroupe et orchestre l'ensemble des traitements en commun.
	 * à utiliser pour tout service métier de vérification de l'unicité d'une entité métier.
	 * @param beanDTO : le DTO provenant de la couche de présentation
	 */
	public IBeanDTO  process(IBeanDTO dto);
}
