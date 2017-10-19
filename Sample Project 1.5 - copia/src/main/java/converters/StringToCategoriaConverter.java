package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import repositories.CategoriaRepository;
import domain.Categoria;

@Component
@Transactional
public class StringToCategoriaConverter implements Converter<String, Categoria> {
	
	@Autowired CategoriaRepository categoriaRepository;
	
	@Override 
	public Categoria convert(String text){
		
		Categoria result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id = Integer.valueOf(text);
				result = categoriaRepository.findOne(id);
			}
			
		} catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return result;
	}
	

}
