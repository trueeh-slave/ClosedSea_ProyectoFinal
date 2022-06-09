package co.edu.unbosque.closedsea_proyectofinal.services;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Art;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Collection;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.UserApp;
import co.edu.unbosque.closedsea_proyectofinal.jpa.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;

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
}
