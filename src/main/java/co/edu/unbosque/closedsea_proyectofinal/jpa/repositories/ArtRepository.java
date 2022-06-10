package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Art;

import java.util.Optional;

public interface ArtRepository {

    Optional<Art> save(Art art);

    Optional<Art> findById(int id);

    Optional<Art> findByName(String name);
}
