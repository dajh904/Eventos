package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Videoevento {

    @Id
    private int Id_videoevento;
    private String nombre;
}
