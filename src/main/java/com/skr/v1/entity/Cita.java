package com.skr.v1.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "cita")
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cita;
	private String entrevistador;
	private String fecha;
	private Time hora;
	private String observaciones;
	private String usuario_actualiza;
	private Date fecha_actualizacion;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	@JsonIgnore
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="id_empresa")
	@JsonIgnore
	private Empresa empresa;
	
	
	@ManyToOne
    @JoinColumn(name="id_estatus_cita")
	private EstatusCita estatuscita;
	
	@ManyToOne
	@JoinColumn(name = "id_postulante_b")
	@JsonIgnore
	private PostulanteB postulanteb;
	
	@OneToMany(targetEntity = Entrevista.class, mappedBy = "cita", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Entrevista> seccion;
	
	@OneToMany(targetEntity = Examen.class, mappedBy = "cita", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Entrevista> Examen;
	
	public Cita () {}

	public Cita(int id_cita, String entrevistador, String fecha, Time hora, String observaciones,
<<<<<<< HEAD
			String usuario_actualiza, Date fecha_actualizacion, Cliente cliente, Empresa empresa,
			EstatusCita estatuscita, PostulanteB postulanteb) {
=======
			String usuario_actualiza, Date fecha_actualizacion, EstatusCita estatuscita, PostulanteB postulanteb,
			Set<Entrevista> seccion, Set<Entrevista> examen) {
>>>>>>> 0e080edf92212f84b258246789981f8f7f4fa543
		super();
		this.id_cita = id_cita;
		this.entrevistador = entrevistador;
		this.fecha = fecha;
		this.hora = hora;
		this.observaciones = observaciones;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
		this.cliente = cliente;
		this.empresa = empresa;
		this.estatuscita = estatuscita;
		this.postulanteb = postulanteb;
		this.seccion = seccion;
		Examen = examen;
	}

	public int getId_cita() {
		return id_cita;
	}

	public void setId_cita(int id_cita) {
		this.id_cita = id_cita;
	}

	public String getEntrevistador() {
		return entrevistador;
	}

	public void setEntrevistador(String entrevistador) {
		this.entrevistador = entrevistador;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public EstatusCita getEstatuscita() {
		return estatuscita;
	}

	public void setEstatuscita(EstatusCita estatuscita) {
		this.estatuscita = estatuscita;
	}

	public PostulanteB getPostulanteb() {
		return postulanteb;
	}

	public void setPostulanteb(PostulanteB postulanteb) {
		this.postulanteb = postulanteb;
	}

	public Set<Entrevista> getSeccion() {
		return seccion;
	}

	public void setSeccion(Set<Entrevista> seccion) {
		this.seccion = seccion;
	}

	public Set<Entrevista> getExamen() {
		return Examen;
	}

	public void setExamen(Set<Entrevista> examen) {
		Examen = examen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_cita;
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
		Cita other = (Cita) obj;
		if (id_cita != other.id_cita)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cita [id_cita=" + id_cita + ", entrevistador=" + entrevistador + ", fecha=" + fecha + ", hora=" + hora
				+ ", observaciones=" + observaciones + ", usuario_actualiza=" + usuario_actualiza
<<<<<<< HEAD
				+ ", fecha_actualizacion=" + fecha_actualizacion + ", cliente=" + cliente + ", empresa=" + empresa
				+ ", estatuscita=" + estatuscita + ", postulanteb=" + postulanteb + "]";
=======
				+ ", fecha_actualizacion=" + fecha_actualizacion + ", estatuscita=" + estatuscita + ", postulanteb="
				+ postulanteb + ", seccion=" + seccion + ", Examen=" + Examen + "]";
>>>>>>> 0e080edf92212f84b258246789981f8f7f4fa543
	}

	
}
