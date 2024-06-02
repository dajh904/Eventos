package gestion.eventos.controladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gestion.eventos.entidades.Estadoevento;
import gestion.eventos.entidades.Evento;
import gestion.eventos.entidades.Organizador;
import gestion.eventos.entidades.Tipoboleto;
import gestion.eventos.entidades.Tipoboleto_evento;
import gestion.eventos.entidades.Ubicacionevento;
import gestion.eventos.repositorios.EstadoeventoRepository;
import gestion.eventos.repositorios.EventoRepository;
import gestion.eventos.repositorios.OrganizadorRepository;
import gestion.eventos.repositorios.TipoboletoRepository;
import gestion.eventos.repositorios.Tipoboleto_eventoRepository;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EventoController {
    @Autowired
    private EventoRepository eventoRepo;
    @Autowired
    private Tipoboleto_eventoRepository boletoEventoRepo;
    @Autowired
    private TipoboletoRepository boletoRepo;
    @Autowired
    private OrganizadorRepository organizadorRepo;
    @Autowired
    private EstadoeventoRepository estadoeventoRepo;

    // LISTAR EVENTOS
    @GetMapping("/admin/panel")
    public String listarEventosAdmin(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model) {

        try {
            // Eventos disponibles

            Page<Evento> pagina = eventoRepo.findAllByEstado(1,
                    PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
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

            // Eventos terminados o cancelados

            Page<Evento> pagina2 = eventoRepo.findAllByEstado(2,
                    PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
            model.addAttribute("pagina2", pagina2);

            int totalPaginas2 = pagina2.getTotalPages();
            int paginaActual2 = pagina2.getNumber();
            int inicio2 = Math.max(1, paginaActual2);
            int fin2 = Math.min((paginaActual2 + 5), totalPaginas2);

            List<Integer> paginas2 = new ArrayList<>();
            if (totalPaginas2 >= 1) {
                for (int i = inicio2; i <= fin2; i++) {
                    paginas2.add(i);
                }
            }
            model.addAttribute("numPaginas2", paginas2);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }
        return "adminPanel";
    }

    @GetMapping("/")
    public String redirectHome() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        try {
            List<Evento> eventos = eventoRepo.findAllByEstado(1);
            model.addAttribute("eventos", eventos);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }
        return "home";
    }

    @GetMapping("/explorar")
    public String explorarEventos(Model model, @RequestParam(required = false) String search,
            @RequestParam(required = false) String date) {
        if ((search == null || search.isBlank()) && (date == null || date.isBlank())) {
            try {
                List<Evento> eventos = eventoRepo.findAllByEstado(1);
                model.addAttribute("eventos", eventos);
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/error";
            }
        }

        else if (search != null && !search.isBlank()) {
            try {
                List<Evento> eventos = eventoRepo.findByNombre(search);
                model.addAttribute("eventos", eventos);
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/error";
            }
        }

        else if (!date.isBlank()) {
            try {
                LocalDate fecha = LocalDate.parse(date);
                List<Evento> eventos = eventoRepo.findByFecha_ini(fecha);
                model.addAttribute("eventos", eventos);
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/error";
            }
        }
        return "explorar";
    }

    // CREAR EVENTO

    @GetMapping("/admin/crear-evento")
    public String crearEventoPage(Model model) {
        try {
            Evento evento = new Evento();
            List<Estadoevento> estado = estadoeventoRepo.findAll();
            model.addAttribute("evento", evento);
            model.addAttribute("estado", estado);
            return "adminCrearEvento";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }
    }

    @PostMapping("/admin/crear-evento/guardar")
    public String crearEvento(@ModelAttribute Evento evento, @AuthenticationPrincipal UserDetails userDetails,
            HttpServletRequest request) {
        try {
            String[] boletos = request.getParameterValues("boleto");
            String[] precio = request.getParameterValues("precio");
            String[] cantidad = request.getParameterValues("cantidad");

            // Obtener organizador logueado que quiere crear evento
            Optional<Organizador> org = organizadorRepo.findByCorreo(userDetails.getUsername());

            /* Evento */
            evento.setId_Ubicacion(new Ubicacionevento(evento.getId_Ubicacion().getNombre()));
            evento.setId_organizador(org.get());
            eventoRepo.save(evento);

            /* Boleteria evento */

            for (int i = 0; i < boletos.length; i++) {
                Tipoboleto_evento tipoboleto_evento;

                // Primero se verifica si existe un boleto con el nombre ingresado, si no
                // existe, se crea el registro en tipoboleto
                Optional<Tipoboleto> ticket = boletoRepo.findByNombre(boletos[i]);
                if (ticket.isPresent()) {
                    tipoboleto_evento = new Tipoboleto_evento(new Tipoboleto(ticket.get().getId_Tipoboleto(),
                            ticket.get().getNombre()), Integer.parseInt(precio[i]), Integer.parseInt(cantidad[i]),
                            evento);
                } else {
                    tipoboleto_evento = new Tipoboleto_evento(new Tipoboleto(boletos[i]),
                            Integer.parseInt(precio[i]), Integer.parseInt(cantidad[i]), evento);
                }
                boletoEventoRepo.save(tipoboleto_evento);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/panel?crear_error";
        }
        return "redirect:/admin/panel";
    }

    // Editar evento

    @GetMapping("/admin/evento/editar/{id}")
    public String editarEventoPage(@PathVariable int id, Model model) {
        try {
            Optional<Evento> evento = eventoRepo.findById(id);
            List<Tipoboleto_evento> boleteria = boletoEventoRepo.findByEvento(id);
            List<Estadoevento> estado = estadoeventoRepo.findAll();
            model.addAttribute("evento", evento.get());
            model.addAttribute("boleteria", boleteria);
            model.addAttribute("estado", estado);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/panel?editar_error";
        }
        return "adminEditarEvento";
    }

    @PostMapping("admin/evento/editar/guardar")
    public String editarEvento(@ModelAttribute Evento evento, @AuthenticationPrincipal UserDetails userDetails,
            HttpServletRequest request) {
        try {
            String[] evento_boleto = request.getParameterValues("evento_boleto");
            String[] boletos = request.getParameterValues("boleto");
            String[] precio = request.getParameterValues("precio");
            String[] cantidad = request.getParameterValues("cantidad");

            // Evento
            Optional<Organizador> org = organizadorRepo.findByCorreo(userDetails.getUsername());
            evento.setId_organizador(org.get());
            eventoRepo.save(evento);

            for (int i = 0; i < boletos.length; i++) {
                Tipoboleto_evento tipoboleto_evento;

                // Primero se verifica si existe un boleto con el nombre ingresado, si no
                // existe, se crea el registro en tipoboleto
                Optional<Tipoboleto> ticket = boletoRepo.findByNombre(boletos[i]);
                if (ticket.isPresent()) {
                    tipoboleto_evento = new Tipoboleto_evento(Integer.parseInt(evento_boleto[i]),
                            new Tipoboleto(ticket.get().getId_Tipoboleto(), ticket.get().getNombre()),
                            Integer.parseInt(precio[i]), Integer.parseInt(cantidad[i]), evento);
                } else {
                    tipoboleto_evento = new Tipoboleto_evento(Integer.parseInt(evento_boleto[i]),
                            new Tipoboleto(boletos[i]), Integer.parseInt(precio[i]), Integer.parseInt(cantidad[i]),
                            evento);
                }
                boletoEventoRepo.save(tipoboleto_evento);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/panel?editar_error";
        }
        return "redirect:/admin/panel";
    }
}
