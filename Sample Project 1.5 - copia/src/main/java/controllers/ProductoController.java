package controllers;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ProductoService;
import services.UsuarioService;
import domain.Producto;
import domain.Usuario;


@Controller
@RequestMapping("/producto")
public class ProductoController extends AbstractController {
	
	// Services -------------------------------------------------------------------
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired	
	private UsuarioService usuarioService;
	
	// Constructors ---------------------------------------------------------------
	
	public ProductoController(){
		super();
	}
	
	
	// Listing methods -----------------------------------------------------------
	
	@RequestMapping(value= "/listAll", method = RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView result; 
		Collection<Producto> productos;
		
		Usuario usuario = usuarioService.findByPrincipal();
		productos = this.productoService.findAll();
		result = new ModelAndView("producto/listAll");

		result.addObject("productos", productos);
		result.addObject("usuario", usuario);
		result.addObject("requestURI", "producto/listAll.do");
			
		return result;
	}
	
	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public ModelAndView listChildren(@RequestParam int categoriaId){
		ModelAndView result; 
		Collection<Producto> productos;
		Usuario usuario = usuarioService.findByPrincipal();
		
		productos = this.productoService.findByCategory(categoriaId);
		result = new ModelAndView("producto/list");
		result.addObject("productos", productos);
		result.addObject("usuario", usuario);
		result.addObject("requestURI", "productos/list.do");
			
		return result;
	}


	@RequestMapping(value="/search", method=RequestMethod.GET)	
	public ModelAndView search(@RequestParam(required = false, defaultValue = "") String keyword) {
		ModelAndView result = null;

		try {


			Collection<Producto> productos = productoService.search(keyword);
			Usuario usuario = usuarioService.findByPrincipal();
			
			result = new ModelAndView("producto/list");

			result.addObject("productos", productos);
			result.addObject("usuario", usuario);
			result.addObject("requestURI", "producto/list.do");
			
		} catch (Throwable e) {
			result = new ModelAndView("welcome/index");
		}

		return result;
	}



}
