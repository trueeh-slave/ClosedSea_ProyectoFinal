package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Collection;

import java.util.Optional;

public interface CollectionRepository {

    Optional<Collection> save(Collection collection);

}
