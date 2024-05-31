package gestion.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.eventos.entidades.Tipoboleto;
import java.util.Optional;


@Repository
public interface TipoboletoRepository extends JpaRepository<Tipoboleto, Integer>{
    Optional<Tipoboleto> findByNombre(String nombre);
}
