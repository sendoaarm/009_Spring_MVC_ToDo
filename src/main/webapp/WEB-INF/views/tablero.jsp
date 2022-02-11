<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>TABLERO</title>
</head>
<body>
	<section>
            <div class="jumbotron">
                <div class="container">
                    <h1>TABLERO</h1>
                    <p>Lista tareas</p>
                </div>
            </div>
     </section>
     <section class="container">
            <div class="row">
             <h3>TODO</h3>
           <!--  en el ${"nombre del atributo de la lista de coleccion"} -->
                <c:forEach items="${columnaToDo}" var="tarea">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${tarea.titulo}</h3>
                                <p>${tarea.descripcion}
                                <a class="btn btn-primary" 
                                href="tablero/${tarea.idTarea}/INPROGRESS">&gt;&gt;</a>
                                </p>   
                                                             
                            </div>
                        </div>
                    </div>
                    
                    
                </c:forEach>
            </div>
             <div class="row">
             <h3>INPROGRESS</h3>
           <!--  en el ${"nombre del atributo de la lista de coleccion"} -->
                <c:forEach items="${columnaInProgress}" var="tarea">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${tarea.titulo}</h3>
                                <p>${tarea.descripcion}
                                <a class="btn btn-primary" 
                                href="tablero/${tarea.idTarea}/DONE">&gt;&gt;</a>
                                </p>   
                                                             
                            </div>
                        </div>
                    </div>
                    
                    
                </c:forEach>
            </div>
             <div class="row">
             <h3>DONE</h3>
           <!--  en el ${"nombre del atributo de la lista de coleccion"} -->
                <c:forEach items="${columnaDone}" var="tarea">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${tarea.titulo}</h3>
                                <p>${tarea.descripcion}
                                <a class="btn btn-primary" 
                                href="tablero/${tarea.idTarea}/TODO">&gt;&gt;</a>
                                </p>   
                                                             
                            </div>
                        </div>
                    </div>
                    
                    
                </c:forEach>
            </div>
            <div class="row">
                  <a class="btn btn-primary" 
                     href="<c:url value= "/tablero/nuevatarea"/>" 
                     role="button">CREAR TAREA</a>
            </div>
           
        </section>
</body>
</html>