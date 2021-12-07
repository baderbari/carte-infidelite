package uqam.mgl7361.projet.carteinfidelite.services;

import uqam.mgl7361.projet.carteinfidelite.entites.Client;

import java.util.Optional;

public interface ServiceClient {


    public Optional<Client> attribuerStatutVUP(Long clientId);

    public Boolean verifierStatutVUP(Long clientId);

}