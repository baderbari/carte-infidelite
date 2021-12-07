package uqam.mgl7361.projet.carteinfidelite.persistance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uqam.mgl7361.projet.carteinfidelite.entites.Client;

@Repository
public interface IClientDAO extends CrudRepository<Client,Long> {

}