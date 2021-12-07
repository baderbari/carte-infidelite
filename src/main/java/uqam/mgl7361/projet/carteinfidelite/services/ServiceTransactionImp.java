package uqam.mgl7361.projet.carteinfidelite.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uqam.mgl7361.projet.carteinfidelite.entites.CarteMagasinPK;
import uqam.mgl7361.projet.carteinfidelite.entites.Transaction;
import uqam.mgl7361.projet.carteinfidelite.persistance.ITransactionDAO;



@Service
public class ServiceTransactionImp implements ServiceTransaction {
	

	@Autowired
	private ITransactionDAO transactionDao;
	
	/**
	 * 
	 * @param carte
	 */
	public void getTransactionUniqueParMagasin(int carte) {
		// TODO - implement ServiceTransactionImp.getTransactionUniqueParMagasin
		throw new UnsupportedOperationException();
	}



	@Override
	public Optional<Transaction> rechercherTransaction(CarteMagasinPK carteMagasinPK) {
		
		return transactionDao.findById(carteMagasinPK);
	}

	@Override
	public Transaction acheter(Transaction transaction) {
		return transactionDao.save(transaction);
	}

}