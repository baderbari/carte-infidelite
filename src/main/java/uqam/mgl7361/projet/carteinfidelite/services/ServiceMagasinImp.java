package uqam.mgl7361.projet.carteinfidelite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uqam.mgl7361.projet.carteinfidelite.persistance.IMagasinDAO;
import uqam.mgl7361.projet.carteinfidelite.persistance.ITransactionDAO;

@Service
public class ServiceMagasinImp implements ServiceMagasin {
	
	
	
	@Autowired
	private IMagasinDAO magasinDao;
}