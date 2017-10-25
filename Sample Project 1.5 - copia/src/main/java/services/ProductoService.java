package services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Carcasa;
import domain.Color;
import domain.Lente;
import domain.Producto;
import domain.SearchTemplate;
import repositories.ProductoRepository;

@Service
@Transactional
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private SearchTemplateService searchTemplateService;

	public ProductoService() {
		super();
	}

	public Producto create() {

		Producto c = new Producto();


		return c;
	}


	public Producto save(Producto c) {
		Assert.notNull(c);		
		return productoRepository.saveAndFlush(c);
		
	}
	
	public Collection<Producto> findAll(){
		return productoRepository.findAll();
	}
	
	public Producto findOne(int productoId){
		
		Producto producto;
		
		producto = productoRepository.findOne(productoId);
		Assert.notNull(producto);
		
		return producto;
		
	}
	
	public Collection<Producto> findByCategory(int categoriaId){
		
		 Collection<Producto> productos = productoRepository.findProductByCategory(categoriaId);
		 
		 return productos;
	}

	public Collection<Producto> search(String keyword) {
		Collection<Producto> result;
		
		result = this.productoRepository.searchProductsByKeyword(keyword);
		Assert.notNull(result);
		
		return result;
	}


	public Collection<Producto> findAllBySearchTemplate(final SearchTemplate searchTemplate) {

		Collection<Producto> result;


		result = searchTemplate.getProductos();


		return result;
	}

	public Collection<Producto> searchProduct(SearchTemplate searchTemplate) {

		Collection<Producto> result;
		Collection<Producto> keyword;
		Collection<Producto> color;
		Collection<Producto> carcasa;
		Collection<Producto> lente;

		result = new ArrayList<Producto>();
		keyword = new ArrayList<Producto>();
		color = new ArrayList<Producto>();
		carcasa = new ArrayList<Producto>();
		lente = new ArrayList<Producto>();

		keyword = this.productoRepository.searchProductsByKeyword(searchTemplate.getKeyword());
		if(searchTemplate.getColor() != Color.todos){
			color = this.productoRepository.searchProductsByColor(searchTemplate.getColor());
		}else{
			color = this.productoRepository.findAll();
		}
		if(searchTemplate.getCarcasa() != Carcasa.todas){
		carcasa = this.productoRepository.searchProductsByCarcasa(searchTemplate.getCarcasa());
		}else{
			carcasa = this.productoRepository.findAll();
		}
		if(searchTemplate.getLente() != Lente.todos){
		lente = this.productoRepository.searchProductsByLente(searchTemplate.getLente());
		}else{
			lente = this.productoRepository.findAll();			
		}
		
		color.retainAll(keyword);
		carcasa.retainAll(color);
		lente.retainAll(carcasa);

		result = lente;

		return result;
	}

//	
//||||||| .r5
//=======
//	public Collection<Producto> search(String keyword) {
//		Collection<Producto> result;
//		
//		result = this.productoRepository.searchProductsByKeyword(keyword);
//		Assert.notNull(result);
//		
//		return result;
//	}
//	
//	
//>>>>>>> .r6
}
