package com.curso.tablero.services;

import java.util.Collection;

import com.curso.domain.Tarea;
import com.curso.tablero.exceptions.TareasException;

public interface TableroService {

	
	void crearTarea(Tarea t) throws TareasException;
	
	Tarea getTarea(Integer idTarea);
	
	Collection<Tarea> getTareasToDo();
	Collection<Tarea> getTareasInProgress();
	Collection<Tarea> getTareasDone();
	
	void moverAToDo(Integer idTarea) throws TareasException;
	void moverAInProgress(Integer idTarea) throws TareasException;
	void moverADone(Integer idTarea) throws TareasException;
	void borrarTarea(Integer idTarea) throws TareasException;
}
