package gestion.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.eventos.entidades.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
