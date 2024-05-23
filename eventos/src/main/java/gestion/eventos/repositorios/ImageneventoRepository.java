package gestion.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.eventos.entidades.Imagenevento;

@Repository
public interface ImageneventoRepository extends JpaRepository<Imagenevento, Integer> {

}
