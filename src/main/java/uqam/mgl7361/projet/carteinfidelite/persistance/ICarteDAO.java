package uqam.mgl7361.projet.carteinfidelite.persistance;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uqam.mgl7361.projet.carteinfidelite.entites.Carte;

@Repository
public interface ICarteDAO extends CrudRepository<Carte,Long>{

	Optional<Carte> findById(Long id);


}