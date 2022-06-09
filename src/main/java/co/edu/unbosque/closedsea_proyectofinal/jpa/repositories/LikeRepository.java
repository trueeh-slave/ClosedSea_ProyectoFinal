package co.edu.unbosque.closedsea_proyectofinal.jpa.repositories;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Like;

import java.util.Optional;

public interface LikeRepository {

    Optional<Like> save(Like like);
}
