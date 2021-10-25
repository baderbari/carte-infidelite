package uqam.mgl7361.projet.carteinfidelite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uqam.mgl7361.projet.carteinfidelite.entites.Cadeau;
import uqam.mgl7361.projet.carteinfidelite.persistance.ICadeauDAO;

@Service
public class ServiceCadeauImp implements ServiceCadeau {

	@Autowired
	private ICadeauDAO cadeauDAO;
	
	public void recherche() {
		// TODO - implement ServiceCadeauImp.recherche
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Cadeau> consulterCadeaux() {
		
		return cadeauDAO.findAll();
	}

	@Override
	public Optional<Cadeau> rechercherCadeau(Long id) {
		return cadeauDAO.findById(id);
		
	}

}