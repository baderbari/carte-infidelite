package uqam.mgl7361.projet.carteinfidelite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uqam.mgl7361.projet.carteinfidelite.entites.Cadeau;
import uqam.mgl7361.projet.carteinfidelite.entites.Zone;
import uqam.mgl7361.projet.carteinfidelite.persistance.IStatsZoneDAO;

import java.util.List;

@Service
public class ServiceStatsZoneImp implements ServiceStatsZone {

    @Autowired
    private IStatsZoneDAO statsZoneDAO;

    @Override
    public List<Cadeau> getCadeauxPopulaires(Zone zone) {
        return null;
    }

    @Override
    public List getHeuresAchalandage(Zone zone) {
        return null;
    }
}
