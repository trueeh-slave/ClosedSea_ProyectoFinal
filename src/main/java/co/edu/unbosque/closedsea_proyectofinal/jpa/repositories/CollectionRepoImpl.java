package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Collection;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class CollectionRepoImpl implements CollectionRepository{

    EntityManager entityManager;

    public CollectionRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Collection> save(Collection collection) {

        try{

            entityManager.getTransaction().commit();
            entityManager.persist(collection);
            entityManager.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
