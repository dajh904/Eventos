package gestion.eventos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gestion.eventos.entidades.Organizador;
import gestion.eventos.repositorios.OrganizadorRepository;

@Controller
public class OrganizadorController {
    @Autowired
    private OrganizadorRepository organizadorRepo;

    @GetMapping("/registro")
    public String regOrganizador(Model model){
        Organizador org = new Organizador();
        model.addAttribute("organizador", org);
        return "registro_organizador";
    }

    @PostMapping("/registro/guardar")
    public String guardarOrganizador(@ModelAttribute Organizador organizador){
        try{
            organizadorRepo.save(organizador);
        } catch (Exception e){
            e.printStackTrace();
            return "redirect:/registro?error";
        }
        return "redirect:/login?registro";
    }

}
