package uqam.mgl7361.projet.carteinfidelite.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uqam.mgl7361.projet.carteinfidelite.entites.Carte;
import uqam.mgl7361.projet.carteinfidelite.entites.Transaction;
import uqam.mgl7361.projet.carteinfidelite.persistance.ICarteDAO;


@Service
public class ServiceCarteImp  implements ServiceCarte {

	@Autowired
	private ICarteDAO  carteDao;

	@Override
	public Optional<Carte> rechercherCarte(long id) {
		return carteDao.findById(id);
	}



	@Override
	public Carte MettreAJourInfosCarte(Carte carte) {
		
		Carte carteUpdeted = carteDao.save(carte);
		return carteUpdeted;
	}



	@Override
	public float calculerPointsGagne(float points, float montantTransaction) { 
		return points +(montantTransaction*10 / 100);
	}

	@Override
	public List<Transaction> listerCredit(long carteId) {
		return carteDao.listerCredit(carteId);
	}

	@Override
	public List<Transaction> listerDebit(long carteId) {
		return carteDao.listerDebit(carteId);
	}
}
