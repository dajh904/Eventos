package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Asistente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_asistente;
    private String nombre;
    private String apellido;
    private int num_doc;

    //Getters y setters
    
    public int getId_asistente() {
        return Id_asistente;
    }
    public void setId_asistente(int id_asistente) {
        Id_asistente = id_asistente;
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
    public Asistente() {
    }
}
