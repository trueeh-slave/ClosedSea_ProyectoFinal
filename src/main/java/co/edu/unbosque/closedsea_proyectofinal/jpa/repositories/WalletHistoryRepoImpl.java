package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Wallet_History;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class WalletHistoryRepoImpl implements WalletHistoryRepository{

    EntityManager entityManager;

    public WalletHistoryRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Wallet_History> save(Wallet_History wallet_history) {

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(wallet_history);
            entityManager.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
