package uqam.mgl7361.projet.carteinfidelite.services;

import java.util.Optional;

import uqam.mgl7361.projet.carteinfidelite.entites.CarteMagasinPK;
import uqam.mgl7361.projet.carteinfidelite.entites.Transaction;

public interface ServiceTransaction {

	/**
	 * 
	 * @param carte
	 */
	void getTransactionUniqueParMagasin(int carte);

	Optional<Transaction> rechercherTransaction(CarteMagasinPK carteMagasinPK);

    Transaction acheter(Transaction transaction);
}