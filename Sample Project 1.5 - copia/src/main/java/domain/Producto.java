
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Entity
@Access(AccessType.PROPERTY)
public class Producto extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Producto() {
		super();

	}

	// Attributes -------------------------------------------------------------

	private String	referencia;
	private String	nombre;
	private String	descripcion;
	private String	imagen;
	private Double	euros;
	
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public Double getEuros() {
		return euros;
	}
	public void setEuros(Double euros) {
		this.euros = euros;
	}
	
	
	// Relationships ----------------------------------------------------------
	
	private Collection<Categoria_Producto>	categoria_productos;

	@NotNull
	@Valid
	@OneToMany(mappedBy = "producto")
	public Collection<Categoria_Producto> getCategoria_productos() {
		return categoria_productos;
	}
	
	public void setCategoria_productos(Collection<Categoria_Producto> categoria_productos) {
		this.categoria_productos = categoria_productos;
	}



}
