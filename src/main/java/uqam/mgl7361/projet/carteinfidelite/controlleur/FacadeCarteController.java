package uqam.mgl7361.projet.carteinfidelite.controlleur;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uqam.mgl7361.projet.carteinfidelite.entites.Carte;
import uqam.mgl7361.projet.carteinfidelite.services.*;
import uqam.mgl7361.projet.carteinfidelite.services.ServiceCarte;
import uqam.mgl7361.projet.carteinfidelite.services.ServiceClient;

@RestController
@RequestMapping("api/v1/carte")
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
     */
    
    @PutMapping("/{id}")
    public ResponseEntity<Carte> updateEmployee(@PathVariable(value = "id") Long carteId,
      @Valid @RequestBody Carte carteDetails) throws ResourceNotFoundException {
    	
    	Carte updatedCarte = new Carte();
    	try {
    		 Carte carte = serviceCarte.rechercherCarte(carteId);
    		 carte.setPoints(carteDetails.getPoints());
             updatedCarte = serviceCarte.MettreAJourInfosCarte(carte);
            
		} catch (Exception e) {
			new ResourceNotFoundException("Carte not found for this id :: " + carteId);
		}
    
		return ResponseEntity.ok(updatedCarte);
        
    }
    
}