package co.edu.unbosque.closedsea_proyectofinal.services;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Art;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Ownership;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.UserApp;
import co.edu.unbosque.closedsea_proyectofinal.jpa.repositories.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.Optional;


@Stateless
public class OwnershipService {

    OwnershipRepository ownerRepository;
    ArtRepository artRepository;
    UserAppRepository userAppRepository;

    public Optional<Ownership> save(int id, String email) throws Exception {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("closedsea");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository =  new OwnershipRepositoryImpl(entityManager);
        artRepository =  new ArtRepositoryImpl(entityManager);
        userAppRepository =  new UserAppRepositoryImpl(entityManager);

        Optional<Art> art= artRepository.findById(id);
        Optional<UserApp> userApp = userAppRepository.findByEmail(email);

        if (userApp.isPresent() && art.isPresent()) {

            Ownership ownership = new Ownership(art.get(), userApp.get(), new Date());
            Optional<Ownership> persistedOwner= ownerRepository.save(ownership);

            entityManager.close();
            entityManagerFactory.close();

            return persistedOwner;

        } else {
            throw new Exception("Art or User not found");
        }
    }
}
