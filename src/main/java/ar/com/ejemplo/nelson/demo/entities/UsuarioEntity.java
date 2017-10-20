package ar.com.ejemplo.nelson.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO_ENTIDAD")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private Integer documento;
	
	@OneToMany(fetch = FetchType.EAGER, targetEntity=LibroEntity.class ,mappedBy="usuario")
	private Set<LibroEntity> libroEntities= new HashSet<LibroEntity>(); {
	};

	/**
	 * @return the id
	 */
	
	public UsuarioEntity(String nombre,String apellido,Integer documento){		
		this.nombre=nombre;
		this.apellido=apellido;
		this.documento=documento;	
	}
	
	public UsuarioEntity(){		
	}
	
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the documento
	 */
	public Integer getDocumento() {
		return documento;
	}

	/**
	 * @param documento
	 *            the documento to set
	 */
	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	/**
	 * @return the libroEntities
	 */
	
	public Set<LibroEntity> getLibroEntities() {
		return libroEntities;
	}

	/**
	 * @param libroEntities the libroEntities to set
	 */
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)	
	public void setLibroEntities(Set<LibroEntity> libroEntities) {
		this.libroEntities = libroEntities;
	}

}
