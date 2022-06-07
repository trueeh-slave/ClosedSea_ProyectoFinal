package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.WalletHistory;

import java.util.Optional;

public interface WalletHistoryRepository {

    Optional<WalletHistory> save(WalletHistory walletHistory);

}
