package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import repositories.ProductoRepository;
import domain.Producto;

@Component
@Transactional
public class StringToProductoConverter implements Converter<String, Producto> {
	
	@Autowired ProductoRepository productoRepository;
	
	@Override 
	public Producto convert(String text){
		
		Producto result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id = Integer.valueOf(text);
				result = productoRepository.findOne(id);
			}
			
		} catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return result;
	}
	

}
