package co.edu.unbosque.closedsea_proyectofinal.services;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.UserApp;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.WalletHistory;
import co.edu.unbosque.closedsea_proyectofinal.jpa.repositories.UserAppRepository;
import co.edu.unbosque.closedsea_proyectofinal.jpa.repositories.UserAppRepositoryImpl;
import co.edu.unbosque.closedsea_proyectofinal.jpa.repositories.WalletHistoryRepository;
import co.edu.unbosque.closedsea_proyectofinal.jpa.repositories.WalletHistoryRepositoryImpl;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.Optional;

@Stateless
public class WalletHistoryService {

    UserAppRepository userAppRepository;
    WalletHistoryRepository walletHistoryRepository;

    public Optional<WalletHistory> save(String email, String type, Double fcoins) throws Exception {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("closedsea");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        walletHistoryRepository = new WalletHistoryRepositoryImpl(entityManager);
        userAppRepository = new UserAppRepositoryImpl(entityManager);

        Optional<UserApp> userApp = userAppRepository.findByEmail(email);

        if (userApp.isPresent()) {

            WalletHistory walletHistory = new WalletHistory(type, fcoins, new Date(), userApp.get());
            Optional<WalletHistory> persistedWalletHistory = walletHistoryRepository.save(walletHistory);

            entityManager.close();
            entityManagerFactory.close();

            return persistedWalletHistory;

        } else {
            throw new Exception("User not found");
        }
    }
}
