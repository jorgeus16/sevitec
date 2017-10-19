package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Producto;
import repositories.ProductoRepository;

@Service
@Transactional
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

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
	

}
