package gestion.eventos.repositorios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gestion.eventos.entidades.Evento;

import java.time.LocalDate;


@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    @Query("SELECT e FROM Evento e WHERE e.Id_Estadoevento.Id_Estadoevento = :estado")
    Page<Evento> findAllByEstado(@Param("estado") int estado, Pageable pageable);

    @Query("SELECT e FROM Evento e WHERE e.Id_Estadoevento.Id_Estadoevento = :estado")
    List<Evento> findAllByEstado(@Param("estado") int estado);

    @Query("SELECT e FROM Evento e WHERE e.nombre LIKE %?1% AND e.Id_Estadoevento.Id_Estadoevento = 1")
    List<Evento> findByNombre(String nombre);

    @Query(value="SELECT * FROM Evento e WHERE CAST(e.FECHA_INI AS DATE)= ?1 AND e.Id_Estadoevento = 1", nativeQuery = true)
    List<Evento> findByFecha_ini(@Param("fecha") LocalDate fecha_ini);
}
