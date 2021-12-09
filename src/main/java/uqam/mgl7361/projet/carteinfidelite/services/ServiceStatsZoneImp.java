package uqam.mgl7361.projet.carteinfidelite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uqam.mgl7361.projet.carteinfidelite.entites.Cadeau;
import uqam.mgl7361.projet.carteinfidelite.entites.Zone;
import uqam.mgl7361.projet.carteinfidelite.persistance.IStatsZoneDAO;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceStatsZoneImp implements ServiceStatsZone {

    @Autowired
    private IStatsZoneDAO statsZoneDAO;



    @Override
    public List<Cadeau> getCadeauxPopulaires(Zone zone) {
        return null;
    }

    @Override
    public List getHeuresAchalandage(long zone) {
        return null;
    }

    @Override
    public Optional<Zone> rechercherZone(long id) {
        return statsZoneDAO.findById(id);
    }

    @Override
    public List rechercheCadeauxPopulaires(long zoneid) {
        return statsZoneDAO.rechercherCadeauxPopulairex(zoneid);
    }
}
