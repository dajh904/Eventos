package gestion.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.eventos.entidades.Estadoevento;

@Repository
public interface EstadoeventoRepository extends JpaRepository<Estadoevento, Integer>{

}
