package com.skr.v1.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cliente;
	private String descripcion;
	private String usuario_actualiza;
	private Date fecha_actualizacion;
	
	@OneToMany(targetEntity = Examen.class, mappedBy = "cliente", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Set<Examen> examen;
	
	@OneToMany(targetEntity = Entrevista.class, mappedBy = "cliente", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Set<Entrevista> entrevista;
		
	public Cliente () {}

	public Cliente(int id_cliente, String descripcion, String usuario_actualiza, Date fecha_actualizacion,
			Set<Examen> examen, Set<Entrevista> entrevista) {
		super();
		this.id_cliente = id_cliente;
		this.descripcion = descripcion;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
		this.examen = examen;
		this.entrevista = entrevista;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuario_actualiza() {
		return usuario_actualiza;
	}

	public void setUsuario_actualiza(String usuario_actualiza) {
		this.usuario_actualiza = usuario_actualiza;
	}

	public Date getFecha_actualizacion() {
		return fecha_actualizacion;
	}

	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public Set<Examen> getExamen() {
		return examen;
	}

	public void setExamen(Set<Examen> examen) {
		this.examen = examen;
	}

	public Set<Entrevista> getEntrevista() {
		return entrevista;
	}

	public void setEntrevista(Set<Entrevista> entrevista) {
		this.entrevista = entrevista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_cliente;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id_cliente != other.id_cliente)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", descripcion=" + descripcion + ", usuario_actualiza="
				+ usuario_actualiza + ", fecha_actualizacion=" + fecha_actualizacion + ", examen=" + examen
				+ ", entrevista=" + entrevista + "]";
	}
	
}
