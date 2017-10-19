package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Categoria_Producto;

@Component
@Transactional
public class Categoria_ProductoToStringConverter implements Converter<Categoria_Producto, String>{
	
	@Override
	public String convert(Categoria_Producto categoria_producto){
		String result;
		
		if(categoria_producto == null)
			result = null;
		else
			result = String.valueOf(categoria_producto.getId());
		
		return result;
	}

}
