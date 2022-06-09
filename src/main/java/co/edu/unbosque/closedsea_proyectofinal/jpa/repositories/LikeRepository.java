package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.LikeArt;

import java.util.Optional;

public interface LikeRepository {

    Optional<LikeArt> save(LikeArt like);
}
