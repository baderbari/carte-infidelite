package uqam.mgl7361.projet.carteinfidelite.services;

import uqam.mgl7361.projet.carteinfidelite.entites.Carte;

public interface ServiceCarte{

Carte rechercherCarte(long id);

Carte MettreAJourInfosCarte(Carte carte);

}