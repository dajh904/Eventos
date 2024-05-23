package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tipoboleto {

    @Id
    private int Id_Tipoboleto;
    private String nombre;
}
