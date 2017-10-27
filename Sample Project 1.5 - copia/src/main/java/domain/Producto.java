
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.Valid;


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
	private String	imagenEspec;
	private String	imagenTabla;
	private Double euros;
	private Carcasa	carcasa;
	private Color	color;
	private Lente	lente;
	

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

	
	public Carcasa getCarcasa() {
		return carcasa;
	}
	public void setCarcasa(Carcasa carcasa) {
		this.carcasa = carcasa;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Lente getLente() {
		return lente;
	}
	public void setLente(Lente lente) {
		this.lente = lente;
	}
	public String getImagenEspec() {
		return imagenEspec;
	}
	public void setImagenEspec(String imagenEspec) {
		this.imagenEspec = imagenEspec;
	}

	public String getImagenTabla() {
		return imagenTabla;
	}
	public void setImagenTabla(String imagenTabla) {
		this.imagenTabla = imagenTabla;
	}

	
	// Relationships ----------------------------------------------------------
	
	private Collection<Categoria> categorias;

	@Valid
	@ManyToMany(mappedBy = "productos")
	public Collection<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(Collection<Categoria> categorias) {
		this.categorias = categorias;
	}



}
