package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Usuario;
import forms.UsuarioRegistrationForm;
import services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends AbstractController {

	@Autowired
	private UsuarioService usuarioService;

	public UsuarioController() {
		super();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView create() {

		ModelAndView result;
		UsuarioRegistrationForm urf = new UsuarioRegistrationForm();
		result = createEditModelAndView(urf);
		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@ModelAttribute("urf") @Valid UsuarioRegistrationForm urf, BindingResult binding) {

		ModelAndView result;
		Usuario usuario;

		if (binding.hasErrors()) {
			if (binding.getGlobalError() != null){
				result = createEditModelAndView(urf, binding.getGlobalError().getCode());
			}else{
				result = createEditModelAndView(urf);
			}
		} else {
			try {
				usuario = usuarioService.reconstruct(urf);
				usuarioService.save(usuario);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {
				result = createEditModelAndView(urf, "register.commit.error");
			}
		}

		return result;
	}

	protected ModelAndView createEditModelAndView(UsuarioRegistrationForm urf) {

		ModelAndView result;

		result = createEditModelAndView(urf, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(UsuarioRegistrationForm urf, String message) {

		ModelAndView result = new ModelAndView("usuario/register");
		result.addObject("urf", urf);
		result.addObject("message", message);

		return result;
	}
}