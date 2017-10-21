package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Actor;
import domain.Usuario;
import services.ActorService;
import services.UsuarioService;

@Controller
@RequestMapping("/welcome")
public class WelcomeController extends AbstractController {


	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ActorService actorService;
	// Constructors -----------------------------------------------------------
	
	public WelcomeController() {
		super();
	}
		
	// Index ------------------------------------------------------------------		

	@RequestMapping(value = "/index")
	public ModelAndView index(@RequestParam(required=false, defaultValue="") String name) {
		ModelAndView result;
		SimpleDateFormat formatter;
		String moment;
		Usuario usuario;
		Actor actor;
		
		actor = actorService.findByPrincipalUsuario();
		usuario = (Usuario) actor;
		formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		moment = formatter.format(new Date());
		

		result = new ModelAndView("welcome/index");
		result.addObject("name", name);
		result.addObject("moment", moment);
		result.addObject("usuario", usuario);

		return result;
	}
	
	

	

}