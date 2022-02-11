package com.curso.tablero.controller;

import java.util.Collection;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.domain.Tablero;
import com.curso.domain.Tarea;
import com.curso.tablero.exceptions.*;
import com.curso.tablero.exceptions.TareasException;
import com.curso.tablero.services.TableroService;

@Controller
public class TableroController {

	@Autowired
	private TableroService tableroService;
	
	// get  /tablero
	@GetMapping("/tablero")
	public String mostrarTablero(Model model) {
	
		model.addAttribute("columnaToDo", tableroService.getTareasToDo());
		model.addAttribute("columnaInProgress", tableroService.getTareasInProgress());
		model.addAttribute("columnaDone", tableroService.getTareasDone());
		
		return "tablero";
		
	}
	
//	@RequestMapping("tareas/{estado}")
//		public String tareasPorEstado(
//				@PathVariable("estado") String tareaEstado,
//				Model model) {
//		
//			Collection<Tarea> listaToDo = tableroService.getTareasToDo();
//			Collection<Tarea> listaInProgress = tableroService.getTareasInProgress();
//			Collection<Tarea> listaDone = tableroService.getTareasDone();
//			model.addAttribute("tareas",listaToDo,listaInProgress,listaDone);
//		
//		return "tareas";
//	}
		
	
	
	// PARA CAMBIAR UNA TAREA DE ESTADO
	// get   /tablero/nueva-tarea
	@GetMapping("/tablero/{id}/{nuevoestado}")
	public String cambiarEstado(
			@PathVariable("id") int id,
			@PathVariable("nuevoestado") String nuevoEstado) throws TareasException{
		
		switch(nuevoEstado) {
		case "TODO":
			tableroService.moverAToDo(id);
			break;
		case "INPROGRESS":
			tableroService.moverAInProgress(id);
			break;
		case "DONE":
			tableroService.moverADone(id);
			break;
		default:
			throw new TareasException("No ha indicado un estado valido");
		}
		
		return "redirect:/tablero";
	}
	
	
	
	// PARA CREAR UNA TAREA 
	@GetMapping("/tablero/nuevatarea")
    public String getCrearNuevaTareaFormulario(Model model) {
    	
    	Tarea nuevaTarea = new Tarea();
    	model.addAttribute("nuevaTarea",nuevaTarea);
    	return "crear-tarea";
    	
    }	
	
	
	// post  /tablero/nueva-tarea
	
	@PostMapping("/tablero/nuevatarea")
	public String crearNuevaTarea(
			@ModelAttribute("nuevaTarea") @Valid Tarea nueva,
			BindingResult bindingResult) throws TareasException {
		
//		System.out.println(".... post");
		if(bindingResult.hasErrors()) {
			return "crear-tarea";
		}
			tableroService.crearTarea(nueva);
		
		return "redirect:/tablero";
	}
	
	
	
	 @ExceptionHandler(TareasException.class)

	    public ModelAndView handleException( TareasException exception) {

	        

	         ModelAndView mav = new ModelAndView();

	         

	         mav.addObject("claveMensage",exception.getKeyMensaje());

	         mav.addObject("argsMensage", exception.getArgs());

	         exception.printStackTrace();

	         mav.setViewName("tareas-exceptions");

	         return mav;

	    }
	
	
}
