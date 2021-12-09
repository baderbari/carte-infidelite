package uqam.mgl7361.projet.carteinfidelite.services;

import java.util.List;
import java.util.Optional;

import uqam.mgl7361.projet.carteinfidelite.entites.Carte;
import uqam.mgl7361.projet.carteinfidelite.entites.Transaction;

public interface ServiceCarte {

    Optional<Carte> rechercherCarte(long id);

    Carte MettreAJourInfosCarte(Carte carte);

    float calculerPointsGagne(float points, float montantTransaction);


    List<Transaction> listerCredit(long carteId);

    List<Transaction> listerDebit(long carteId);

}