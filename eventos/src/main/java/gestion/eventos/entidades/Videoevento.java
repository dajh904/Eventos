package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Videoevento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_videoevento;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "Evento", referencedColumnName = "Id_evento")
    private Evento Id_evento;

    //Getters y Setters
    public int getId_videoevento() {
        return Id_videoevento;
    }
    public void setId_videoevento(int id_videoevento) {
        Id_videoevento = id_videoevento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Evento getId_evento() {
        return Id_evento;
    }
    public void setId_evento(Evento id_evento) {
        Id_evento = id_evento;
    }

    //Constructor
    public Videoevento() {
    }
}
