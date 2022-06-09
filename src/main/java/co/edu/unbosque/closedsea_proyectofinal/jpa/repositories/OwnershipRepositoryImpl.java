package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Art;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Ownership;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class OwnershipRepositoryImpl implements OwnershipRepository{

    private EntityManager entityManager;

    public OwnershipRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Ownership> save(Ownership ownership) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(ownership);
            entityManager.getTransaction().commit();

            return Optional.of(ownership);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
