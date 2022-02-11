package com.curso.tablero.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.curso.domain.Estado;
import com.curso.domain.Tarea;
import com.curso.domain.repository.EnMemoriaTareasRepository;
import com.curso.domain.repository.TareaRepository;
import com.curso.tablero.exceptions.TareasException;

@Service
public class TableroServiceImpl implements TableroService {
	
	@Autowired
	private TareaRepository tareaRepository; // = new EnMemoriaTareasRepository();
	

	@Override
	public void crearTarea(Tarea t) throws TareasException {
		tareaRepository.create(t);

	}

	@Override
	public Tarea getTarea(Integer idTarea) {
		tareaRepository.getTareaById(idTarea);
		return null;
	}

	@Override
	public Collection<Tarea> getTareasToDo() {
		
		return tareaRepository.getTareasByEstado(Estado.TODO);
	}

	@Override
	public Collection<Tarea> getTareasInProgress() {
		
		return tareaRepository.getTareasByEstado(Estado.INPROGRESS);
	}

	@Override
	public Collection<Tarea> getTareasDone() {
		return tareaRepository.getTareasByEstado(Estado.DONE);
	}

	@Override
	public void moverAToDo(Integer idTarea) throws TareasException {
		
		cambiarEstado(idTarea, Estado.TODO);
	}

	@Override
	public void moverAInProgress(Integer idTarea) throws TareasException {
		
		cambiarEstado(idTarea, Estado.INPROGRESS);
	}

	@Override
	public void moverADone(Integer idTarea) throws TareasException {
		
		cambiarEstado(idTarea, Estado.DONE);
	}
	
	public void cambiarEstado(Integer id, Estado estado ) throws TareasException {

		Tarea t = tareaRepository.getTareaById(id);

		if(t == null) {

		 //throw new TareasException("La tarea a modificar no existe");

		 throw new TareasException("tareas.cambioEstado.error.noExisteTarea", id.toString());

		}

		if( t.getEstado() != estado ) {

		t.setEstado(estado);

		 tareaRepository.update(t);

		}

	}

	@Override
	public void borrarTarea(Integer idTarea) throws TareasException {

		tareaRepository.delete(idTarea);
	}
	
	

}
