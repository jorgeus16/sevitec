
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Entity
@Access(AccessType.PROPERTY)
public class Categoria_Producto extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Categoria_Producto() {
		super();

	}

	// Attributes -------------------------------------------------------------


	// Relationships ----------------------------------------------------------


	private Producto producto;
	private Categoria categoria;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}


}
