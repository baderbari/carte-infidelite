package uqam.mgl7361.projet.carteinfidelite.persistance;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uqam.mgl7361.projet.carteinfidelite.entites.Carte;
import uqam.mgl7361.projet.carteinfidelite.entites.Transaction;

@Repository
public interface ICarteDAO extends CrudRepository<Carte,Long>{

	Optional<Carte> findById(Long id);


    @Query(value = "SELECT * FROM CARTE,TRANSACTION\n" +
            "WHERE TYPE_TRANSACTION LIKE \"CREDIT\"", nativeQuery = true)
    List<Transaction> listerCredit(long carteId);

    @Query(value = "SELECT * FROM CARTE,TRANSACTION\n" +
            "WHERE TYPE_TRANSACTION LIKE \"DEBIT\"", nativeQuery = true)
    List<Transaction> listerDebit(long carteId);
}