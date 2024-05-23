package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Asistente {

    @Id
    private int Id_asistente;
    private String nombre;
    private String apellido;
    private int num_doc;
    
}
