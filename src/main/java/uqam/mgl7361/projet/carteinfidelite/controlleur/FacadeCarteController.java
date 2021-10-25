package uqam.mgl7361.projet.carteinfidelite.controlleur;


import java.util.Optional;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uqam.mgl7361.projet.carteinfidelite.entites.Carte;
import uqam.mgl7361.projet.carteinfidelite.entites.Transaction;
import uqam.mgl7361.projet.carteinfidelite.entites.Cadeau;
import uqam.mgl7361.projet.carteinfidelite.services.*;
import uqam.mgl7361.projet.carteinfidelite.services.ServiceCarte;
import uqam.mgl7361.projet.carteinfidelite.services.ServiceClient;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class FacadeCarteController  {

    @Autowired
    private ServiceCadeau serviceCadeau;

    @Autowired
    private ServiceCarte serviceCarte;
    
    @Autowired
    private ServiceClient serviceclient;
	
    @Autowired
    private ServiceMagasin serviceMagasin;
    
    @Autowired
    private ServiceTransaction serviceTransaction;
    

    
    /**
     * Endpoint pour réaliser le use case "Cumul de points" 
     * On appele le Endpoint avec un body qui contient le montant total de sa transaction en magasin
     * et on calcule le nombre des points a ajouter a la carte
     */
    
    @PutMapping("/carte/ajoutPoints/{carteId}")
    public ResponseEntity<Carte> updateCarte(@PathVariable(value = "carteId") Long carteId,
      @Validated @RequestBody Transaction transactionDetails) throws ResourceNotFoundException {
    
    	Optional<Carte>  carte = serviceCarte.rechercherCarte(carteId);
    	Optional<Transaction>  transactionEncours = serviceTransaction.rechercherTransaction(transactionDetails.getId());
    	
    		 if (carte.isPresent() && transactionEncours.isPresent()) {
    			 float pointACumuler = serviceCarte.calculerPointsGagne(carte.get().getPoints(), transactionDetails.getMontantTransaction());
    			 carte.get().setPoints(pointACumuler);
        		 Carte updatedCarte = serviceCarte.MettreAJourInfosCarte(carte.get());
        		 return new ResponseEntity<Carte>(updatedCarte, HttpStatus.ACCEPTED);
    		 }else {
    			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);	
			}
    		       
    }
    
    /**
     * Endpoint pour la Consultation du solde en Point
     * @param carteId
     * @return
     */
    
    @RequestMapping(method = RequestMethod.GET, value = "/carte/consulterSolde/{carteId}")
	public ResponseEntity<Object> getSolde(@PathVariable String carteId) {

		Optional<Carte> carte = serviceCarte.rechercherCarte(Long.valueOf(carteId));

		if (carte.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(carte.get());
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}

	}
    
    /**
     * Endpoint qui retourne le Catalogue des cadeaux
     * @return List<Cadeau
     */
    
    @RequestMapping(method = RequestMethod.GET, value = "/cadeaux" , produces = "application/json")
	public @ResponseBody ResponseEntity<List<Cadeau>>  getAllCadeau() {
    	List<Cadeau> listCadeaux = serviceCadeau.consulterCadeaux();
    	if (listCadeaux.isEmpty() ) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(listCadeaux);
        }
	}
    
    
    /**
     * Endpoint qui recoit un cadeau dans le body et déduit la valeur du cadeau en points du solde en point de la carte 
     * @param cadeau
     * @param carteId
     * @return ResponseEntity < String >
     */
    
    @RequestMapping(value = "/cadeau/achat/{carteId}", method = RequestMethod.POST)
    public ResponseEntity < String > achatCadeau(@RequestBody Cadeau cadeau , @PathVariable(value = "carteId") Long carteId) {
    	
    	Optional<Cadeau> cadeauAchete = serviceCadeau.rechercherCadeau(cadeau.getId());
    	
        if (cadeauAchete.isPresent()) {
        	Optional<Carte> carteClient = serviceCarte.rechercherCarte(carteId);
        	if( cadeau.getNbrPoint() > carteClient.get().getPoints() ) {
        		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        	}
        	carteClient.get().setPoints(carteClient.get().getPoints() - cadeau.getNbrPoint());
        	serviceCarte.MettreAJourInfosCarte(carteClient.get());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    
    
    
}