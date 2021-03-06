package co.edu.unbosque.closedsea_proyectofinal.services;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Art;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Collection;
import co.edu.unbosque.closedsea_proyectofinal.jpa.repositories.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;

@Stateless
public class ArtService {
    CollectionRepository collectionRepository;
    ArtRepository artRepository;

    public Optional<Art> save(int id, String name, Float price, String imagePath, Boolean forSale) throws Exception {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("closedsea");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        artRepository = new ArtRepositoryImpl(entityManager);
        collectionRepository = new CollectionRepositoryImpl(entityManager);

        Optional<Collection> collection = collectionRepository.findById(id);


        if (collection.isPresent()) {

            Art art = new Art(name, price, imagePath, forSale, collection.get());
            Optional<Art> persistedArt = artRepository.save(art);

            entityManager.close();
            entityManagerFactory.close();

            return persistedArt;

        } else {
            throw new Exception("Collection not found");
        }
    }
    public Optional<Art> get(int id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("closedsea");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        artRepository = new ArtRepositoryImpl(entityManager);
        Optional<Art> art = artRepository.findById(id);

        entityManager.close();
        entityManagerFactory.close();

        return art;
    }

    public Optional<Art> get(String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("closedsea");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        artRepository = new ArtRepositoryImpl(entityManager);
        Optional<Art> art = artRepository.findByName(name);

        entityManager.close();
        entityManagerFactory.close();

        return art;
    }

}
