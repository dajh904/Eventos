package gestion.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.eventos.entidades.Tipoboleto_evento;

@Repository
public interface Tipoboleto_eventoRepository extends JpaRepository<Tipoboleto_evento, Integer> {

}
