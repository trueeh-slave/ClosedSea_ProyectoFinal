package co.edu.unbosque.closedsea_proyectofinal.services;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.UserApp;
import co.edu.unbosque.closedsea_proyectofinal.jpa.repositories.UserAppRepository;
import co.edu.unbosque.closedsea_proyectofinal.jpa.repositories.UserAppRepositoryImpl;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;

@Stateless
public class UserAppService {

    UserAppRepository userAppRepository;

    public Optional<UserApp> save(String email, String password, String name, String role) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("closedsea");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppRepositoryImpl(entityManager);

        UserApp userApp = new UserApp(email, password, name, role);
        Optional<UserApp> persistedUser = userAppRepository.save(userApp);

        entityManager.close();
        entityManagerFactory.close();

        return persistedUser;
    }

    public Optional<UserApp> get(String email) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("closedsea");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppRepositoryImpl(entityManager);
        Optional<UserApp> user = userAppRepository.findByEmail(email);

        entityManager.close();
        entityManagerFactory.close();

        return user;
    }

}
