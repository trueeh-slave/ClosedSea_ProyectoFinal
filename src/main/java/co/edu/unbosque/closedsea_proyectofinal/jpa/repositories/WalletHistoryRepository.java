package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Wallet_History;

import java.util.Optional;

public interface WalletHistoryRepository {

    Optional<Wallet_History> save(Wallet_History wallet_history);
}
