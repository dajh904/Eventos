package gestion.eventos.entidades;

import java.time.LocalDateTime;

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
    private LocalDateTime fecha_ini;
    private LocalDateTime fecha_fin;
    @ManyToOne
    @JoinColumn(name = "Id_organizador")
    private Organizador Id_organizador;
    @ManyToOne
    @JoinColumn(name = "Id_Estadoevento")
    private Estadoevento Id_Estadoevento;
    private Integer aforo;
    @ManyToOne
    @JoinColumn(name = "Id_Ubicacion")
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
    public LocalDateTime getFecha_ini() {
        return fecha_ini;
    }
    public void setFecha_ini(LocalDateTime fecha_ini) {
        this.fecha_ini = fecha_ini;
    }
    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }
    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    public Integer getAforo() {
        return aforo;
    }
    public void setAforo(Integer aforo) {
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
