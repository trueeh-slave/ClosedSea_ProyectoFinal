package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Ownership;

import java.util.Optional;

public interface OwnershipRepository {

    Optional<Ownership> save(Ownership ownership);
}
