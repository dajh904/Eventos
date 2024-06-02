package gestion.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.eventos.entidades.Ubicacionevento;

@Repository
public interface UbicacioneventoRepository extends JpaRepository<Ubicacionevento, Integer>{
    
}
