package gestion.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.eventos.entidades.Asistente;

@Repository
public interface AsistenteRepository extends JpaRepository<Asistente, Integer> {

}
