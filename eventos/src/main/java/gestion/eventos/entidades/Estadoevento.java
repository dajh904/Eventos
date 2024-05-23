package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estadoevento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Estadoevento;
    private String nombre;

    //Getters y setters

    public int getId_Estadoevento() {
        return Id_Estadoevento;
    }
    public void setId_Estadoevento(int id_Estadoevento) {
        Id_Estadoevento = id_Estadoevento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Constructor

    public Estadoevento() {
    }
}
