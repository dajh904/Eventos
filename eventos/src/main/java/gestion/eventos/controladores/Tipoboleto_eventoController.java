package gestion.eventos.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gestion.eventos.entidades.Tipoboleto_evento;
import gestion.eventos.repositorios.Tipoboleto_eventoRepository;

@Controller
public class Tipoboleto_eventoController {
    @Autowired
    private Tipoboleto_eventoRepository eventoRepo;

    @GetMapping("/admin/panel")
    public String listarEventos(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model) {
        Page<Tipoboleto_evento> pagina = eventoRepo.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
        model.addAttribute("pagina", pagina);

        int totalPaginas = pagina.getTotalPages();
        int paginaActual = pagina.getNumber();
        int inicio = Math.max(1, paginaActual);
        int fin = Math.min((paginaActual + 5), totalPaginas);

        List<Integer> paginas = new ArrayList<>();
        if (totalPaginas >= 1) {
            for (int i = inicio; i <= fin; i++) {
                paginas.add(i);
            }
        }
        model.addAttribute("numPaginas", paginas);
        return "adminPanel";
    }

    @GetMapping("/admin/crear-evento")
    public String crearEvento() {
        return "adminCrearEvento";
    }
}
