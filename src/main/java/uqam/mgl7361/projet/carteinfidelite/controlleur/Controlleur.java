package uqam.mgl7361.projet.carteinfidelite.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import uqam.mgl7361.projet.carteinfidelite.services.*;
import uqam.mgl7361.projet.carteinfidelite.services.ServiceCarte;
import uqam.mgl7361.projet.carteinfidelite.services.ServiceClient;

@Controller
@RequestMapping("/carteinfidelite")

public class Controlleur {

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
    
    
    
}