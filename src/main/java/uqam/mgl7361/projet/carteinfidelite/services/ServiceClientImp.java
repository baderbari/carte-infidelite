package uqam.mgl7361.projet.carteinfidelite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uqam.mgl7361.projet.carteinfidelite.persistance.IClientDAO;


@Service
public class ServiceClientImp implements ServiceClient {
	
	@Autowired
	private IClientDAO clientDao;

	/**
	 * 
	 * @param carte
	 */
	public void consulterPoint(int carte) {
		// TODO - implement ServiceClientImp.consulterPoint
		throw new UnsupportedOperationException();
	}

}