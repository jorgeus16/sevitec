package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Categoria;

@Component
@Transactional
public class CategoriaToStringConverter implements Converter<Categoria, String>{
	
	@Override
	public String convert(Categoria categoria){
		String result;
		
		if(categoria == null)
			result = null;
		else
			result = String.valueOf(categoria.getId());
		
		return result;
	}

}
