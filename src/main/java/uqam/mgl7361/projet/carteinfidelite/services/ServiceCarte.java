package uqam.mgl7361.projet.carteinfidelite.services;

import java.util.Optional;

import uqam.mgl7361.projet.carteinfidelite.entites.Carte;

public interface ServiceCarte{

Optional<Carte> rechercherCarte(long id);

Carte MettreAJourInfosCarte(Carte carte);

float calculerPointsGagne(float points, float montantTransaction);

}