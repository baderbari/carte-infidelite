package uqam.mgl7361.projet.carteinfidelite.transversal.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uqam.mgl7361.projet.carteinfidelite.entites.*;
import uqam.mgl7361.projet.carteinfidelite.persistance.*;

@Configuration
class LoadDatabase {
	
	/**
	 * Une class qui permet d'ajouter des elements automatiquement dans la BD pour les tests ou autres besoins
	 */

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @SuppressWarnings("deprecation")
@Bean
  CommandLineRunner initDatabase(IClientDAO repositoryClient , ICarteDAO repositoryCarte , IMagasinDAO repositoryMagasin , ITransactionDAO repositoryTransaction , ICadeauDAO repositoryCadeau , IStatsZoneDAO repoStatZone) {

    return args -> {
    	Client clientNonVUP = new Client();
		Client clientVUP = new Client();
    	Carte carte = new Carte();
    	Carte carte2 = new Carte();
    	Zone zone = new Zone();
    	zone.setId((long) 1);
    	zone.setLabelle("anjou");
    	Magasin magasin = new Magasin();
    	Magasin magasin2 = new Magasin();
    	Transaction transaction1 = new Transaction();
    	Transaction transaction2 = new Transaction();
    	Transaction transaction3 = new Transaction();
    	CarteMagasinPK carteMagasinPK = new CarteMagasinPK();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String dateNow = formatter.format(date);
    	
    	clientNonVUP.setDateNaissance(new Date(2000, 11, 21));
    	clientNonVUP.setNom("testNOMNonVUP");
    	clientNonVUP.setPrenom("TestprenomNonVUP");
    	clientNonVUP.setStatut(ClientStatut.NON_VUP);

		clientVUP.setDateNaissance(new Date(2000, 11, 21));
		clientVUP.setNom("testNOMVUP");
		clientVUP.setPrenom("TestprenomVUP");
		clientVUP.setStatut(ClientStatut.VUP);



    	carte.setDateCreation(new Date(2000, 11, 21));
    	carte.setDateExpiration(new Date(2022, 11, 21));
    	carte.setBlocked(false);
    	carte.setPoints((float) 30);
    	carte.setSolde(1000);


		carte2.setDateCreation(new Date(2000, 11, 21));
		carte2.setDateExpiration(new Date(2022, 11, 21));
		carte2.setBlocked(false);
		carte2.setPoints((float) 110);
		carte2.setSolde(1000);


        List listeCarte = new ArrayList();
        List listeCarte2 = new ArrayList();
        List listeMagasin = new ArrayList();
        listeCarte.add(carte);
        listeCarte2.add(carte2);
        listeMagasin.add(magasin);
        listeMagasin.add(magasin2);

		clientVUP.setCarte(listeCarte);
		clientNonVUP.setCarte(listeCarte2);
		List<Transaction> listTransaction = new ArrayList<>();
		listTransaction.add(transaction1);
		listTransaction.add(transaction2);
		listTransaction.add(transaction3);

		zone.setListCartes(listeCarte);
		zone.setListMagasins((listeMagasin));


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
    	transaction1.setMontantTransaction(10);
    	transaction2.setMontantTransaction(1000);
    	transaction3.setMontantTransaction(100);
    	transaction1.setDateTransaction(date);
    	transaction2.setDateTransaction(date);
    	transaction3.setDateTransaction(date);

		transaction1.setTypeTransaction(TypeTransaction.CREDIT.toString());
		transaction2.setTypeTransaction(TypeTransaction.CREDIT.toString());
		transaction3.setTypeTransaction(TypeTransaction.DEBIT.toString());

    	Cadeau cadeauMagasin = new Cadeau();
    	Cadeau cadeauVille = new Cadeau();
    	
    	cadeauMagasin.setDescription("cadeau offert par magasin");
    	cadeauMagasin.setId((long) 1);
    	cadeauMagasin.setMagasin(magasin);
    	cadeauMagasin.setNbrPoint(10);
    	cadeauMagasin.setNbrAchat(10);
    	
    	cadeauVille.setDescription("cadeau offert par ville");
    	cadeauVille.setId((long) 2);
    	cadeauVille.setMagasin(magasin);
    	cadeauVille.setNbrPoint(30);
    	cadeauVille.setNbrAchat(15);

    	List<Cadeau> cadeauList = new ArrayList<>();
    	cadeauList.add(cadeauVille);
    	cadeauList.add(cadeauMagasin);
    	zone.setListCadeaux(cadeauList);
    	zone.setListMagasins(listeMagasin);

		log.info("Preloading " + repositoryClient.save(clientNonVUP));
		log.info("Preloading " + repositoryClient.save(clientVUP));
		log.info("Preloading " + repositoryTransaction.save(transaction1));
		log.info("Preloading " + repositoryTransaction.save(transaction2));
		log.info("Preloading " + repositoryTransaction.save(transaction3));
		log.info("Preloading " + repoStatZone.save(zone));
		log.info("Preloading " + repositoryCarte.save(carte));
		log.info("Preloading " + repositoryCarte.save(carte2));
		log.info("Preloading " + repositoryMagasin.save(magasin));
		log.info("Preloading " + repositoryMagasin.save(magasin2));
  };
}
}