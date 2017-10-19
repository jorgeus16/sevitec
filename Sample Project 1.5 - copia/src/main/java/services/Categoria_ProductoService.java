package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Categoria_Producto;
import repositories.Categoria_ProductoRepository;

@Service
@Transactional
public class Categoria_ProductoService {

	@Autowired
	private Categoria_ProductoRepository categoria_ProductoRepository;

	public Categoria_ProductoService() {
		super();
	}

	public Categoria_Producto create() {

		Categoria_Producto c = new Categoria_Producto();


		return c;
	}


	public Categoria_Producto save(Categoria_Producto c) {
		Assert.notNull(c);		
		return categoria_ProductoRepository.saveAndFlush(c);
		
	}
	

}
