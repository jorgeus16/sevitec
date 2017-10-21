
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;


@Entity
@Access(AccessType.PROPERTY)
public class Categoria extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Categoria() {
		super();

	}


	// Attributes -------------------------------------------------------------

	private String	nombre;
	private String	descripcion;
	private String	imagen;
	
	

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
	
	@URL
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	


	// Relationships ----------------------------------------------------------

	private Collection<Categoria> children;
	private Categoria parent;
	private Collection<Producto> productos;

	@Valid
	@ManyToMany
	public Collection<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}


	@Valid
	@OneToMany(mappedBy="parent")
	public Collection<Categoria> getChildren() {
		return children;
	}
	public void setChildren(Collection<Categoria> children) {
		this.children = children;
	}
	

	@Valid
	@ManyToOne(optional=true)
	public Categoria getParent() {
		return parent;
	}
	public void setParent(Categoria parent) {
		this.parent = parent;
	}
}
