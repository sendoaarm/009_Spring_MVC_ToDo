package com.curso.domain.repository;

import java.util.Collection;

import com.curso.domain.Estado;
import com.curso.domain.Tarea;
import com.curso.tablero.exceptions.TareasException;

public interface TareaRepository {
	
	//CRUD CreateReadUpdateDelete
	// create
	Tarea create(Tarea tarea);
	// read
	Tarea getTareaById(Integer idTarea);
	Collection<Tarea> getTareasByEstado(Estado estado);
	// update
	void update(Tarea tarea) throws TareasException;
	// delete
	void delete(Integer idTarea) throws TareasException;
}
