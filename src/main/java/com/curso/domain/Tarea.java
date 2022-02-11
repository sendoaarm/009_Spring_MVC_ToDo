package com.curso.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Tarea implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTarea;
	
	@NotNull
	@Size(min=2,max=23)
	private String titulo;
	@Size(min=5,max=250)
	private String descripcion;
	private Estado estado;
	
	
	public Tarea() {
		super();
		estado = Estado.TODO;
	}


	public Tarea(Integer idTarea, String titulo, String descripcion){
		super();
		System.out.println("...... nueva tarea ...");
		this.idTarea = idTarea;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = Estado.TODO;
	}


	public Integer getIdTarea() {
		return idTarea;
	}


	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idTarea);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		return Objects.equals(idTarea, other.idTarea);
	}


	@Override
	public String toString() {
		return "Tarea [idTarea=" + idTarea + ", titulo=" + titulo + ", descripcion=" + descripcion + ", estado="
				+ estado + "]";
	}

	
}
