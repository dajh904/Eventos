package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Imagenevento {

    private int Id_imagenevento;
    private String direccion;
    private int Id_evento;
}
