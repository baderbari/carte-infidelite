package uqam.mgl7361.projet.carteinfidelite.services;

import uqam.mgl7361.projet.carteinfidelite.entites.Cadeau;
import uqam.mgl7361.projet.carteinfidelite.entites.Zone;

import java.util.List;
import java.util.Optional;

public interface ServiceStatsZone {

    /**
     *  retourne laa liste dess cadeaux les plus achetés
     * @param zone
     * @return list caadeaux
     */
    List<Cadeau> getCadeauxPopulaires(Zone zone);

    /**
     *
     * @param zone
     * @return
     */
    List getHeuresAchalandage(long zone);


    Optional<Zone> rechercherZone(long id);

    List rechercheCadeauxPopulaires(long zoneid);

}
