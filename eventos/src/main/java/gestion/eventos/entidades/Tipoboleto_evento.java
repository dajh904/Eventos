package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tipoboleto_evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_TipoBoleto_Evento;
    @ManyToOne
    @JoinColumn(name = "Id_Tipoboleto")
    private Tipoboleto Id_Tipoboleto;
    private Integer precioboleto;
    private Integer cantidad_disp;
    @ManyToOne
    @JoinColumn(name = "Id_evento")
    private Evento Id_evento;

    //Getters y Setters
    public int getId_TipoBoleto_Evento() {
        return Id_TipoBoleto_Evento;
    }
    public void setId_TipoBoleto_Evento(int id_TipoBoleto_Evento) {
        Id_TipoBoleto_Evento = id_TipoBoleto_Evento;
    }
    public Integer getPrecioboleto() {
        return precioboleto;
    }
    public void setPrecioboleto(Integer precioboleto) {
        this.precioboleto = precioboleto;
    }
    public Integer getCantidad_disp() {
        return cantidad_disp;
    }
    public void setCantidad_disp(Integer cantidad_disp) {
        this.cantidad_disp = cantidad_disp;
    }
    public Tipoboleto getId_Tipoboleto() {
        return Id_Tipoboleto;
    }
    public void setId_Tipoboleto(Tipoboleto id_Tipoboleto) {
        Id_Tipoboleto = id_Tipoboleto;
    }
    public Evento getId_evento() {
        return Id_evento;
    }
    public void setId_evento(Evento id_evento) {
        Id_evento = id_evento;
    }
    //Constructor
    public Tipoboleto_evento() {
    }
}
