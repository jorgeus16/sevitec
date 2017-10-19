package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Producto;

@Component
@Transactional
public class ProductoToStringConverter implements Converter<Producto, String>{
	
	@Override
	public String convert(Producto producto){
		String result;
		
		if(producto == null)
			result = null;
		else
			result = String.valueOf(producto.getId());
		
		return result;
	}

}
