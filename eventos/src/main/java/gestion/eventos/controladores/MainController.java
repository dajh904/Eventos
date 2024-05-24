package gestion.eventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	@GetMapping("/")
	public String redirectHome() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/admin/crear-evento")
	public String crearEvento() {
		return "adminCrearEvento";
	}
	

}
