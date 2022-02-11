
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!DOCTYPE html>
<html> 
    <head> 
        <link rel="stylesheet"
              href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Alta Nueva Tarea</title> 
    </head>  
   <body>

 

    <form:form method="post" modelAttribute="nuevaTarea">

 

    Titulo:<form:input  path="titulo"/>
    <form:errors path="titulo" cssClass="text-danger" /> 
    Descripcion:<form:input  path="descripcion"/>
    <form:errors path="descripcion " cssClass="text-danger" /> 
    
<input type="submit" id="btnCrear" class="btn btn-primary" value ="Nueva Tarea"/> 
    </form:form>        
</body>    
        
</html>