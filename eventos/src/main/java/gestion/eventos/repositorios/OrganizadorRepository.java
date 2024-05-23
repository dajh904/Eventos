package gestion.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.eventos.entidades.Organizador;

@Repository
public interface OrganizadorRepository extends JpaRepository<Organizador, Integer>{

}
