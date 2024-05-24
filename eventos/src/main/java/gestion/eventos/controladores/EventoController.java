package gestion.eventos.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gestion.eventos.entidades.Evento;
import gestion.eventos.repositorios.EventoRepository;

@Controller
public class EventoController {
    @Autowired
    private EventoRepository eventoRepo;

    /*
    @GetMapping("/admin/panel")
	public String listarEventos(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model) {
        Page<Evento> pagina = eventoRepo.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
        model.addAttribute("pagina", pagina);

        var totalPaginas = pagina.getTotalPages();
        var paginaActual = pagina.getNumber();
        var inicio = Math.max(1, paginaActual);
        var fin = 0;
        if (totalPaginas >= 5) {
            fin = Math.max((paginaActual + 5), totalPaginas);
        } else{
            fin = totalPaginas;
        }

        if (totalPaginas > 0) {
            List<Integer> paginas = new ArrayList<>();
            for (int i = inicio; i < fin; i++) {
                paginas.add(i);
            }
            model.addAttribute("numPaginas", paginas);
        }
        return "adminPanel";
    }
     */

    @GetMapping("/admin/crear-evento")
    public String crearEvento() {
        return "adminCrearEvento";
    }
}
