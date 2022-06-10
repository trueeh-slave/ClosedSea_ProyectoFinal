package co.edu.unbosque.closedsea_proyectofinal.services;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Art;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.LikeArt;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.UserApp;
import co.edu.unbosque.closedsea_proyectofinal.jpa.repositories.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.Optional;

@Stateless
public class LikeService{

    LikeRepository likeRepository;
    ArtRepository artRepository;
    UserAppRepository userAppRepository;

    public Optional<LikeArt> save(int id, String email) throws Exception {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("closedsea");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        likeRepository =  new LikeRepositoryImpl(entityManager);
        artRepository =  new ArtRepositoryImpl(entityManager);
        userAppRepository =  new UserAppRepositoryImpl(entityManager);

        Optional<Art> art = artRepository.findById(id);
        Optional<UserApp> userApp = userAppRepository.findByEmail(email);

        if (userApp.isPresent() && art.isPresent()) {

            LikeArt like = new LikeArt(art.get(), userApp.get(), new Date());
            Optional<LikeArt> persistedLike = likeRepository.save(like);

            entityManager.close();
            entityManagerFactory.close();

            return persistedLike;

        } else {
            throw new Exception("Art or User not found");
        }
    }
}
