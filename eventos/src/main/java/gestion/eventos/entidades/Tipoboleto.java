package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tipoboleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Tipoboleto;
    private String nombre;

    //Getters y Setters
    public int getId_Tipoboleto() {
        return Id_Tipoboleto;
    }
    public void setId_Tipoboleto(int id_Tipoboleto) {
        Id_Tipoboleto = id_Tipoboleto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Constructor
    public Tipoboleto() {
    }
}
