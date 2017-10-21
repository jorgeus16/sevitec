package controllers;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ProductoService;
import domain.Producto;



@Controller
@RequestMapping("/producto")
public class ProductoController extends AbstractController {
	
	// Services -------------------------------------------------------------------
	
	@Autowired
	private ProductoService productoService;
	
	// Constructors ---------------------------------------------------------------
	
	public ProductoController(){
		super();
	}
	
	
	// Listing methods -----------------------------------------------------------
	
	@RequestMapping(value= "/listAll", method = RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView result; 
		Collection<Producto> productos;
		
		productos = this.productoService.findAll();
		result = new ModelAndView("producto/listAll");
		result.addObject("productos", productos);
		result.addObject("requestURI", "producto/listAll.do");
			
		return result;
	}
//	
//	@RequestMapping(value= "/list", method = RequestMethod.GET)
//	public ModelAndView listChildren(@RequestParam int categoriaId){
//		ModelAndView result; 
//		Collection<Producto> productos;
//		
//		productos = this.productoService.findByCategory(categoriaId);
//		result = new ModelAndView("producto/list");
//		result.addObject("productos", productos);
//		result.addObject("requestURI", "producto/list.do");
//			
//		return result;
//	}

	
	


}
