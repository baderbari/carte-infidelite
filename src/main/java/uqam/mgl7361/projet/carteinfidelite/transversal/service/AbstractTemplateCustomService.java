package uqam.mgl7361.projet.carteinfidelite.transversal.service;

import uqam.mgl7361.projet.carteinfidelite.transversal.dto.IBeanDTO;

public abstract class AbstractTemplateCustomService implements ITemplateCustomService{

	
	@Override
	public IBeanDTO process(IBeanDTO dto) {
		// Step 1 : deleguer le traitement métier au service spécifique	
		
		return doProcess(dto);
	}

	/**
	 * méthode abstract , l'implementation se fait dans le service métier spécifique
	 * @param Generic
	 * @return Generic
	 */
	public abstract IBeanDTO doProcess(IBeanDTO dto);
}
