package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ubicacionevento {

    @Id
    private int Id_Ubicacionevento;
    private String nombre;
}
