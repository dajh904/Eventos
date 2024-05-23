package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Organizador {

    private int Id_organizado;
    private String nombre;
    private String apellido;
    private int num_doc;
}
