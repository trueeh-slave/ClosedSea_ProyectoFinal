package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Art;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class ArtRepositoryImpl implements ArtRepository{

    private EntityManager entityManager;

    public ArtRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Art> findById(int id) {
        Art art = entityManager.find(Art.class, id);
        return art != null ? Optional.of(art) : Optional.empty();
    }

    @Override
    public Optional<Art> save(Art art) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(art);
            entityManager.getTransaction().commit();

            return Optional.of(art);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
