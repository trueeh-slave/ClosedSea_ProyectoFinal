package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Collection;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.UserApp;
import jakarta.persistence.EntityManager;
import java.util.Optional;

public class CollectionRepositoryImpl implements CollectionRepository {

    private EntityManager entityManager;

    public CollectionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Collection> findById(int id) {
        Collection collection = entityManager.find(Collection.class, id);
        return collection != null ? Optional.of(collection) : Optional.empty();
    }

    @Override
    public Optional<Collection> findByName(String name) {
        Collection collection = entityManager.find(Collection.class, name);
        return collection != null ? Optional.of(collection) : Optional.empty();
    }

    @Override
    public Optional<Collection> save(Collection collection) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(collection);
            entityManager.getTransaction().commit();

            return Optional.of(collection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
