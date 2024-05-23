package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Imagenevento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_imagenevento;
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "Evento", referencedColumnName = "Id_evento")
    private Evento Id_evento;

    //Getters y Setters
    public int getId_imagenevento() {
        return Id_imagenevento;
    }
    public void setId_imagenevento(int id_imagenevento) {
        Id_imagenevento = id_imagenevento;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Evento getId_evento() {
        return Id_evento;
    }
    public void setId_evento(Evento id_evento) {
        Id_evento = id_evento;
    }
    

    //Constructor
    public Imagenevento() {
    }
}
