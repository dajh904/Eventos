package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_evento;
    private String nombre;
    private String descripcion;
    private String hora_ini;
    private String hora_fin;
    @ManyToOne
    @JoinColumn(name = "Organizador", referencedColumnName = "Id_organizador")
    private Organizador Id_organizador;
    @ManyToOne
    @JoinColumn(name = "Estadoevento", referencedColumnName = "Id_Estadoevento")
    private Estadoevento Id_Estadoevento;
    private int aforo;
    @ManyToOne
    @JoinColumn(name = "Ubicacionevento", referencedColumnName = "Id_Ubicacionevento")
    private Ubicacionevento Id_Ubicacion;

    //Getters y Setters
    public int getId_evento() {
        return Id_evento;
    }
    public void setId_evento(int id_evento) {
        Id_evento = id_evento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getHora_ini() {
        return hora_ini;
    }
    public void setHora_ini(String hora_ini) {
        this.hora_ini = hora_ini;
    }
    public String getHora_fin() {
        return hora_fin;
    }
    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }
    public int getAforo() {
        return aforo;
    }
    public void setAforo(int aforo) {
        this.aforo = aforo;
    }
    public Organizador getId_organizador() {
        return Id_organizador;
    }
    public void setId_organizador(Organizador id_organizador) {
        Id_organizador = id_organizador;
    }
    public Estadoevento getId_Estadoevento() {
        return Id_Estadoevento;
    }
    public void setId_Estadoevento(Estadoevento id_Estadoevento) {
        Id_Estadoevento = id_Estadoevento;
    }
    public Ubicacionevento getId_Ubicacion() {
        return Id_Ubicacion;
    }
    public void setId_Ubicacion(Ubicacionevento id_Ubicacion) {
        Id_Ubicacion = id_Ubicacion;
    }
    
    //Constructor
    public Evento() {
    }   
}
