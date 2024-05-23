package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Estadoevento {

    @Id
    private int Id_Estadoevento;
    private String nombre;
}
