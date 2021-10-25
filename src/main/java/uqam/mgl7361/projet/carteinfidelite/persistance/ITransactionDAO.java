package uqam.mgl7361.projet.carteinfidelite.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uqam.mgl7361.projet.carteinfidelite.entites.Transaction;

@Repository
public interface ITransactionDAO extends JpaRepository<Transaction,Long>{

}