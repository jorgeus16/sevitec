
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.Valid;


@Entity
@Access(AccessType.PROPERTY)
public class SearchTemplate extends DomainEntity {

	//Attributes ====================================================================================

	private Carcasa			carcasa;
	private Color			color;
	private Lente			lente;
	private String			keyword;


	//Constructor ====================================================================================

	public SearchTemplate() {
		super();
	}

	//Getters & setters================================================================================



	public String getKeyword() {
		return this.keyword;
	}

	

	public void setKeyword(final String keyword) {
		this.keyword = keyword;
	}


	public Carcasa getCarcasa() {
		return carcasa;
	}
	public void setCarcasa(Carcasa carcasa) {
		this.carcasa = carcasa;
	}

	
	public Color getColor() {
		return color;	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	public Lente getLente() {
		return lente;
	}	
	public void setLente(Lente lente) {
		this.lente = lente;
	}
	
	// Relationships ====================================================================================

	private Collection<Producto>	productos;


	@Valid
	@ManyToMany
	public Collection<Producto> getProductos() {
		return this.productos;
	}
	
	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}
}
