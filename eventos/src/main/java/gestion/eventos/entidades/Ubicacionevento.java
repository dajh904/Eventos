package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ubicacionevento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Ubicacionevento;
    private String nombre;

    //Getters y Setters
    public int getId_Ubicacionevento() {
        return Id_Ubicacionevento;
    }
    public void setId_Ubicacionevento(int id_Ubicacionevento) {
        Id_Ubicacionevento = id_Ubicacionevento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Constructor
    public Ubicacionevento() {
    }
}
