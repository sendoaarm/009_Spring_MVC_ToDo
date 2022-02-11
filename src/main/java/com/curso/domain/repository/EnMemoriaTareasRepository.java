package com.curso.domain.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.curso.domain.Estado;
import com.curso.domain.Tarea;
import com.curso.tablero.exceptions.TareasException;

@Repository
public class EnMemoriaTareasRepository implements TareaRepository{

	private Map<Integer, Tarea> tareas = new HashMap<Integer, Tarea>();
	
	private static int contadorId = 2;
	
	
	public EnMemoriaTareasRepository() {
		Tarea t =new Tarea(1, "Tarea 1","Lo que sea");
		t.setEstado(Estado.TODO);
        tareas.put(1, t);
        tareas.put(2, new Tarea(2, "Tarea 2","Lo que sea 2"));        
    }
	
	
	
	
	@Override
	public Tarea create(Tarea tarea) {
	
		contadorId ++;
		tarea.setIdTarea(contadorId);
		tareas.put(contadorId, tarea);
		return tarea;
	}

//	Retorna la tarea por el ID
//	si no existe retorna null
	@Override
	public Tarea getTareaById(Integer idTarea) {
		return tareas.get(idTarea);
	}

	@Override
	public Collection<Tarea> getTareasByEstado(Estado estado) {
		List<Tarea> lista= new ArrayList<Tarea>();
		for(Tarea t : tareas.values()) {
			if(t.getEstado() == estado) {
				lista.add(t);
			}
		}
		return lista;
	}

	@Override
	public void update(Tarea tarea) throws TareasException {
		// PRIMERO, validar que existe
		if( ! tareas.containsKey(tarea.getIdTarea())) {
//			throw new TareasException("La tarea a modificar no existe");
		}
		tareas.put(tarea.getIdTarea(), tarea);
	}

	@Override
	public void delete(Integer idTarea) throws TareasException {
		// primero validar que existe
		Tarea t = getTareaById(idTarea);
		if( t == null) {
//			throw new TareasException("La tarea a borrar no existe");
			
		}
		tareas.remove(idTarea);
		
	}

}
