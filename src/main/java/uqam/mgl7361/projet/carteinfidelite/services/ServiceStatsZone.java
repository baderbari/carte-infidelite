package uqam.mgl7361.projet.carteinfidelite.services;

import uqam.mgl7361.projet.carteinfidelite.entites.Cadeau;
import uqam.mgl7361.projet.carteinfidelite.entites.Zone;

import java.util.List;

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
    List getHeuresAchalandage(Zone zone);


}
