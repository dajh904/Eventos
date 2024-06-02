package gestion.eventos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gestion.eventos.entidades.Tipoboleto_evento;



@Repository
public interface Tipoboleto_eventoRepository extends JpaRepository<Tipoboleto_evento, Integer> {
    @Query("SELECT t FROM Tipoboleto_evento t WHERE t.Id_evento.Id_evento = ?1")
    List<Tipoboleto_evento> findByEvento(int Id_evento);
}
