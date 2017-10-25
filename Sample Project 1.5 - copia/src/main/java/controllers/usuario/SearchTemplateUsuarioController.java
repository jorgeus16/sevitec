
package controllers.usuario;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Carcasa;
import domain.Color;
import domain.Lente;
import domain.Producto;
import domain.SearchTemplate;
import domain.Usuario;
import services.ProductoService;
import services.SearchTemplateService;
import services.UsuarioService;

@Controller
@RequestMapping("/searchTemplate/usuario")
public class SearchTemplateUsuarioController extends AbstractController {

	// Services -------------------------------------------------------------------

	@Autowired
	private ProductoService	productoService;

	@Autowired
	private SearchTemplateService	searchTemplateService;

	@Autowired
	private UsuarioService usuarioService;


	// Constructors ---------------------------------------------------------------

	public SearchTemplateUsuarioController() {
		super();
	}

	// Listing methods -----------------------------------------------------------

//	@RequestMapping(value = "/display", method = RequestMethod.GET)
//	public ModelAndView display() {
//
//		ModelAndView result;
//		SearchTemplate searchTemplate;
//		Collection<Producto> productos;
//
//		searchTemplate = this.searchTemplateService.findByPrincipal();
//		productos = this.productoService.searchProduct(searchTemplate);
//
//		result = new ModelAndView("searchTemplate/usuario/display");
//		result.addObject("searchTemplate", searchTemplate);
//		result.addObject("productos",productos);
//		result.addObject("requestURI", "searchTemplate/usuario/display.do");
//
//		return result;
//	}
//
//	@RequestMapping(value = "/search", method = RequestMethod.GET)
//	public ModelAndView search() {
//
//
//		ModelAndView result;
//		SearchTemplate searchTemplate;
//		searchTemplate = this.searchTemplateService.findByPrincipal();
//		try {
//
//			searchTemplate.setProductos(this.productoService.searchProduct(searchTemplate));
//			result = new ModelAndView("searchTemplate/usuario/display");
//			result.addObject("searchTemplate", searchTemplate);
//			result.addObject("productos", searchTemplate.getProductos());
//			result.addObject("requestURI", "searchTemplate/producto/search.do");
//		} catch (final Throwable oops) {
//			result = this.createEditModelAndView(searchTemplate, "searchTemplate.commit.error");
//		}
//
//		return result;
//	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView result;

		SearchTemplate searchTemplate;
		Usuario usuario = usuarioService.findByPrincipal();
		
		searchTemplate = searchTemplateService.findByPrincipal();
		Assert.notNull(searchTemplate);
		
		result = this.createEditModelAndView(searchTemplate);
		result.addObject(usuario);

		return result;
	}

	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@ModelAttribute @Valid final SearchTemplate searchTemplate, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(searchTemplate);
		else
			try {
				Collection<Producto> productos = productoService.searchProduct(searchTemplate);
				searchTemplate.setProductos(productos);
				SearchTemplate st = searchTemplateService.save(searchTemplate);
				result = this.createEditModelAndView(st);
				
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(searchTemplate, "searchTemplate.commit.error");
			}
		return result;
	}

	// Ancillary Methods============================================================

	protected ModelAndView createEditModelAndView(final SearchTemplate searchTemplate) {
		ModelAndView result;
		
		result = this.createEditModelAndView(searchTemplate, null);

		return result;

	}

	protected ModelAndView createEditModelAndView(final SearchTemplate searchTemplate, final String message) {
		ModelAndView result;

		final List<Color> colores = Arrays.asList(Color.values());
		final List<Carcasa> carcasas = Arrays.asList(Carcasa.values());
		final List<Lente> lentes = Arrays.asList(Lente.values());
		
		Collection<Producto> productos = searchTemplate.getProductos();
		Usuario usuario = usuarioService.findByPrincipal();
		
		result = new ModelAndView("searchTemplate/usuario/edit");
		result.addObject("searchTemplate", searchTemplate);
		result.addObject("colores", colores);
		result.addObject("carcasas", carcasas);
		result.addObject("productos", productos);
		result.addObject("usuario",usuario);
		result.addObject("lentes", lentes);
		result.addObject("message", message);
		

		return result;
	}


}
