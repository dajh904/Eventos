package gestion.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/prueba")
	public String login() {
		return "login";
	}

	@GetMapping("/admin/crear-evento")
	public String crearEvento() {
		return "adminCrearEvento";
	}
	

}
