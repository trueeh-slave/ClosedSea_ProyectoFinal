package co.edu.unbosque.closedsea_proyectofinal.services;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Art;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Like;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.UserApp;
import co.edu.unbosque.closedsea_proyectofinal.jpa.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.Optional;

public class LikeService{

    LikeRepository likeRepository;
    ArtRepository artRepository;
    UserAppRepository userAppRepository;

    public Optional<Like> save(int id, String email) throws Exception {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("closedsea");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        likeRepository =  new LikeRepositoryImpl(entityManager);
        artRepository =  new ArtRepositoryImpl(entityManager);
        userAppRepository =  new UserAppRepositoryImpl(entityManager);

        Optional<Art> art= artRepository.findById(id);
        Optional<UserApp> userApp = userAppRepository.findByEmail(email);

        if (userApp.isPresent() && art.isPresent()) {

            Like like = new Like(art.get(), userApp.get(), new Date());
            Optional<Like> persistedLike = likeRepository.save(like);

            entityManager.close();
            entityManagerFactory.close();

            return persistedLike;

        } else {
            throw new Exception("Art or User not found");
        }
    }
}
