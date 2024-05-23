package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Organizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_organizador;
    private String nombre;
    private String apellido;
    private int num_doc;

    //Getters y Setters
    public int getId_organizado() {
        return Id_organizador;
    }
    public void setId_organizado(int id_organizador) {
        Id_organizador = id_organizador;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getNum_doc() {
        return num_doc;
    }
    public void setNum_doc(int num_doc) {
        this.num_doc = num_doc;
    }

    //Constructor
    public Organizador() {
    }
}
