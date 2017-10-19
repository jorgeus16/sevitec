package controllers;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.CategoriaService;
import domain.Categoria;



@Controller
@RequestMapping("/categoria")
public class CategoriaController extends AbstractController {
	
	// Services -------------------------------------------------------------------
	
	@Autowired
	private CategoriaService categoriaService;
	
	// Constructors ---------------------------------------------------------------
	
	public CategoriaController(){
		super();
	}
	
	
	// Listing methods -----------------------------------------------------------
	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView result; 
		Collection<Categoria> categorias;
		
		categorias = this.categoriaService.findCategoriesWithChildren();
		result = new ModelAndView("categoria/list");
		result.addObject("categorias", categorias);
		result.addObject("requestURI", "categoria/list.do");
			
		return result;
	}
	
	@RequestMapping(value= "/listChildren", method = RequestMethod.GET)
	public ModelAndView listChildren(@RequestParam int parentId){
		ModelAndView result; 
		Collection<Categoria> categorias;
		
		categorias = this.categoriaService.findChildrenByParentId(parentId);
		result = new ModelAndView("categoria/list");
		result.addObject("categorias", categorias);
		result.addObject("requestURI", "categoria/list.do");
			
		return result;
	}

	
	


}
