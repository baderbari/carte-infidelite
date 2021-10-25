package uqam.mgl7361.projet.carteinfidelite.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uqam.mgl7361.projet.carteinfidelite.entites.Carte;
import uqam.mgl7361.projet.carteinfidelite.persistance.ICarteDAO;


@Service
public class ServiceCarteImp  implements ServiceCarte {

	@Autowired
	private ICarteDAO  carteDao;

	@Override
	public Carte rechercherCarte(long id) {
		return carteDao.findById(id).get();
	}



	@Override
	public Carte MettreAJourInfosCarte(Carte carte) {
		
		Carte carteUpdeted = carteDao.save(carte);
		return carteUpdeted;
	}




}
