package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Categoria;
import repositories.CategoriaRepository;

@Service
@Transactional
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public CategoriaService() {
		super();
	}

	public Categoria create() {

		Categoria c = new Categoria();


		return c;
	}


	public Categoria save(Categoria c) {
		Assert.notNull(c);		
		return categoriaRepository.saveAndFlush(c);
		
	}
	
	
	public Collection<Categoria> findCategoriesWithChildren(){
		Collection<Categoria> result;
		
		result = this.categoriaRepository.findCategoriesWithChildren();
		
		Assert.notNull(result);
		
		return result;
	}
	
	public Collection<Categoria> findChildrenByParentId(int parentId){
		Collection<Categoria> result;
		Categoria parent = this.categoriaRepository.findOne(parentId);
		
		result = parent.getChildren();
		Assert.notNull(result);
		
		return result;
	}

	public Boolean tieneSubcategoria(int parentId) {
		Boolean subcategorias = true;
		Categoria categoria = categoriaRepository.findOne(parentId);
		if (categoria.getChildren().isEmpty() || categoria.getChildren() == null){
			subcategorias = false;
		}
		return subcategorias;
	}
	

}
