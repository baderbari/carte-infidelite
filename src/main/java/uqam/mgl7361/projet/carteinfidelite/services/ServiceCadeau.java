package uqam.mgl7361.projet.carteinfidelite.services;

import java.util.List;
import java.util.Optional;

import uqam.mgl7361.projet.carteinfidelite.entites.Cadeau;

public interface ServiceCadeau {

	List<Cadeau> consulterCadeaux();

	Optional<Cadeau> rechercherCadeau(Long id);

}