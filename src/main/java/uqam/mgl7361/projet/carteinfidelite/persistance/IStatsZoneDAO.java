package uqam.mgl7361.projet.carteinfidelite.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uqam.mgl7361.projet.carteinfidelite.entites.Client;
import uqam.mgl7361.projet.carteinfidelite.entites.Zone;

@Repository
public interface IStatsZoneDAO extends CrudRepository<Zone,Long> {
}
