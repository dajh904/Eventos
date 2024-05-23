package gestion.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.eventos.entidades.Videoevento;

@Repository
public interface VideoeventoRepository extends JpaRepository<Videoevento, Integer>{

}
