package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.LikeArt;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class LikeRepositoryImpl implements LikeRepository{

    private EntityManager entityManager;

    public LikeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<LikeArt> save(LikeArt like) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(like);
            entityManager.getTransaction().commit();

            return Optional.of(like);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
