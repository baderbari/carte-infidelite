package uqam.mgl7361.projet.carteinfidelite.transversal.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uqam.mgl7361.projet.carteinfidelite.entites.Cadeau;
import uqam.mgl7361.projet.carteinfidelite.entites.Carte;
import uqam.mgl7361.projet.carteinfidelite.entites.CarteMagasinPK;
import uqam.mgl7361.projet.carteinfidelite.entites.Client;
import uqam.mgl7361.projet.carteinfidelite.entites.Magasin;
import uqam.mgl7361.projet.carteinfidelite.entites.Transaction;
import uqam.mgl7361.projet.carteinfidelite.persistance.ICadeauDAO;
import uqam.mgl7361.projet.carteinfidelite.persistance.ICarteDAO;
import uqam.mgl7361.projet.carteinfidelite.persistance.IClientDAO;
import uqam.mgl7361.projet.carteinfidelite.persistance.IMagasinDAO;
import uqam.mgl7361.projet.carteinfidelite.persistance.ITransactionDAO;

@Configuration
class LoadDatabase {
	
	/**
	 * Une class qui permet d'ajouter des elements automatiquement dans la BD pour les tests ou autres besoins
	 */

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @SuppressWarnings("deprecation")
@Bean
  CommandLineRunner initDatabase(IClientDAO repositoryClient , ICarteDAO repositoryCarte , IMagasinDAO repositoryMagasin , ITransactionDAO repositoryTransaction , ICadeauDAO repositoryCadeau ) {

    return args -> {
    	Client client = new Client();
    	Carte carte = new Carte();
    	Magasin magasin = new Magasin();
    	Magasin magasin2 = new Magasin();
    	Transaction transaction1 = new Transaction();
    	Transaction transaction2 = new Transaction();
    	Transaction transaction3 = new Transaction();
    	CarteMagasinPK carteMagasinPK = new CarteMagasinPK();
    	
    	
    	client.setDateNaissance(new Date(2000, 11, 21));
    	client.setNom("testNOM");
    	client.setPrenom("Testprenom");
    	client.setUid("clientUid");
    	log.info("Preloading " + repositoryClient.save(client));
    	
    	carte.setClient(client);
    	carte.setDateCreation(new Date(2000, 11, 21));
    	carte.setDateExpiration(new Date(2022, 11, 21));
    	carte.setIsBlocked(false);
    	carte.setPoints((float) 30);
    	carte.setSolde(1000);
    	carte.setUid("carteUid");
    	log.info("Preloading " + repositoryCarte.save(carte));
    	
    	magasin.setId((long) 1);
    	magasin.setUid("magasinUid");
    	log.info("Preloading " + repositoryMagasin.save(magasin));
    	magasin2.setId((long) 2);
    	magasin2.setUid("magasinUid2");
    	log.info("Preloading " + repositoryMagasin.save(magasin2));
    	
    	carteMagasinPK.setIdMagasin(magasin.getId());
    	carteMagasinPK.setIdMagasin(carte.getId());
    	
    	transaction1.setCarte(carte);
    	transaction2.setCarte(carte);
    	transaction3.setCarte(carte);
    	transaction1.setId(carteMagasinPK);
    	transaction2.setId(carteMagasinPK);
    	transaction3.setId(carteMagasinPK);
    	transaction1.setMagasin(magasin);
    	transaction2.setMagasin(magasin);
    	transaction3.setMagasin(magasin);
    	transaction1.setmontantTransaction(10); 	
    	
    	log.info("Preloading " + repositoryTransaction.save(transaction1));
    	log.info("Preloading " + repositoryTransaction.save(transaction2));
    	log.info("Preloading " + repositoryTransaction.save(transaction3));
    	
    	List<Transaction> listTransaction = new ArrayList<>();
    	listTransaction.add(transaction1);
    	listTransaction.add(transaction2);
    	listTransaction.add(transaction3);
    	
    	
    	Cadeau cadeauMagasin = new Cadeau();
    	Cadeau cadeauVille = new Cadeau();
    	
    	cadeauMagasin.setDescription("cadeau offert par magasin");
    	cadeauMagasin.setId((long) 1);
    	cadeauMagasin.setMagasin(magasin);
    	cadeauMagasin.setNbrPoint(10);
    	cadeauMagasin.setUid("uid1");
    	
    	cadeauVille.setDescription("cadeau offert par ville");
    	cadeauVille.setId((long) 2);
    	cadeauVille.setMagasin(magasin);
    	cadeauVille.setNbrPoint(30);
    	cadeauVille.setUid("uid2");
    	
    	log.info("Preloading " + repositoryCadeau.save(cadeauMagasin));
    	log.info("Preloading " + repositoryCadeau.save(cadeauVille));
 
    	
  };
}
}