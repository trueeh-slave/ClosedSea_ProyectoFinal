package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Collection;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.UserApp;

import java.util.Optional;

public interface CollectionRepository {

    Optional<Collection> save(Collection collection);

    Optional<Collection> findById(int id);

    Optional<Collection> findByName(String name);

}
