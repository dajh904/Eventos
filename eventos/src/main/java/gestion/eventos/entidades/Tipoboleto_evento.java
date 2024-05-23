package gestion.eventos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tipoboleto_evento {

    @Id
    private int Id_TipoBoleto_Evento;
    private int Id_Tipoboleto;
    private int precioboleto;
    private int cantidad_disp;
    private int Id_evento;
}
