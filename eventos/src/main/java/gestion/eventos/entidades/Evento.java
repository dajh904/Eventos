package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Evento {

    @Id
    private int Id_evento;
    private String nombre;
    private String descripcion;
    private String hora_ini;
    private String hora_fin;
    private int Id_organizador;
    private int Id_Estadoevento;
    private int aforo;
    private int Id_Ubicacion;
}
