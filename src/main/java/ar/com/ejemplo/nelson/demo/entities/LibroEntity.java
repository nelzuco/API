package ar.com.ejemplo.nelson.demo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "LIBRO")
public class LibroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String cbu;

	@ManyToOne
//	@JoinColumn(name = "usuario_id")	
//	@JsonIgnore
	private UsuarioEntity usuario;

	/**
	 * @return the id
	 */
	
	public LibroEntity(){	
	}
	
	public LibroEntity(String nombre,String cbu){
		this.nombre=nombre;
		this.cbu=cbu;		
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
	 * @return the usuario
	 */

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the cbu
	 */
	public String getCbu() {
		return cbu;
	}

	/**
	 * @param cbu
	 *            the cbu to set
	 */
	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

}
