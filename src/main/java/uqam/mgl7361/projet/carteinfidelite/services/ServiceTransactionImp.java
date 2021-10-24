package uqam.mgl7361.projet.carteinfidelite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uqam.mgl7361.projet.carteinfidelite.persistance.RegistreTransaction;

@Service
public class ServiceTransactionImp implements ServiceTransaction {
	
    @Autowired
    private RegistreTransaction registreTransaction;

	/**
	 * 
	 * @param carte
	 */
	public void getTransactionUniqueParMagasin(int carte) {
		// TODO - implement ServiceTransactionImp.getTransactionUniqueParMagasin
		throw new UnsupportedOperationException();
	}

}