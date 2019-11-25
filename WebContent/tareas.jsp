<%@page import="modelo.Tarea" import="modelo.ListaTareas" import ="modelo.Categoria" import="modelo.ListaCategorias" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file = "includes/head.jsp" %>
<meta charset="ISO-8859-1">
<title>Administrador de tareas</title>
</head>
<body>
<div class="container-fluid">
<%
Tarea tr= new Tarea(); 
Categoria c = new Categoria();
ListaCategorias listac = new ListaCategorias();
if (request.getAttribute("id") != null) {
	String id = "0";
	id = request.getAttribute("id").toString();
tr.buscarID(Integer.parseInt(id));
c.buscarID(Integer.parseInt(id));
}
%>
<%@include file = "includes/header.jsp" %>
<%@include file = "includes/nav.jsp" %>
<section>
<div class="container">
<div class="row ">
	<%//out.print(id);
	
//out.print(request.getAttribute("id"));%>
            <div class="col-md-2 ">
            <a class="nav-link" href="listaTareas.jsp"><i class="fas fa-list fa-2x"></i></a></div>
            <div class="col-md-8">
            <form  action="AltaTarea" method="post" >
                   <div class="form-group">
                   <input type="hidden" name="opcion" value="1">
                    <input type="hidden" name="id" id="id" value="<%if (request.getAttribute("id") != null) out.print(tr.getId()); %>">
                   
                   </div>
                    
 
                    <div class="form-group">
                        <label for="exampleInputEmail1" class="titulo ">Titulo</label>
                        <input type="text" name="titulo" class="form-control" id="exampleInputEmail1" value="<%if (request.getAttribute("id") != null)
				out.print(tr.getTitulo());%>" required placeholder="Titulo">
                        <small id="tituloLibro" class="form-text text-muted textBlanco">Introduce el titulo de la tarea</small>
                    </div>
                    <div class="form-group">
    <label for="descripcion">Descripcion</label>
    <textarea class="form-control" id="descripcion" rows="3" name="descripcion" ><%if (request.getAttribute("id") != null)
				out.print(tr.getDescripcion());%></textarea>
  </div>
                    <div class="form-group">
                        <label for="categoria">Categoria</label>
    <select class="form-control" id="categoria" name="categoria" value="">
                        <%
                        
									if (listac.obtenerCat() != null) {
										out.print(listac.CatLista());
										
									} else
										out.print("<option>No hay naves añadidas</option><a href=Categorias.jsp>Dar de alta una nueva mision</a>");
								%>
                        
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="importancia">Importancia</label>
    <select class="form-control" id="importancia" name="importancia">
                        <option value="0">Seleccione</option>
                        <option value="1">Mucha</option>
                        <option value="2">Poca</option>
                        <option value="3">Cero</option>
                        
                        </select>
                    </div>
                   
                    <div class="form-group">
    <label for="depencencia">Dependencia</label>
    <select class="form-control" id="dependencia" name="depende" value="<%if (request.getAttribute("id") != null)
				out.print(tr.getDepende());%>">
      <%

	ListaTareas lista = new ListaTareas();
	lista.obtenerTareas();
	String guardar = lista.DependenLista();
%>

<%=guardar %>
    </select>
  </div>
   <div class="form-group">
                        <label for="exampleInputEmail1" class="fecha">Fecha de inicio</label>
                        <input type="text"  name="fecha_inicio" class="form-control"  placeholder="fecha_inicio" value="<%if (request.getAttribute("id") != null)
				out.print(tr.fechaFormatddmmyyyy());%>">
                    </div>
  <div class="form-group">
                        <label for="exampleInputEmail1" class="fecha">Fecha de fin</label>
                        <input type="text"  name="fecha_fin" class="form-control"  placeholder="fecha_fin" value="<%if (request.getAttribute("id") != null)
				out.print(tr.ffechaFormatddmmyyyy());%>">
                    </div>
                    
                     <div class="form-group">
    <label for="estado">Estado</label>
    <select class="form-control" id="estado" name="estado" value="<%if (request.getAttribute("id") != null)
				out.print(tr.getEstado());%>">
      <option value="0">Seleccione</option>
     <option value="1">Terminada</option>
     <option value="2">En proceso</option>
     <option value="3">No comenzada</option>
    </select>
  </div>
  
   
  <button type="submit" class="btn btn-primary">Submit</button>
                    
                    
                            
    </form>
    
    </div>
            <div class="col-md-2 ">
            <a class="nav-link" href="listaTareas.jsp"><i class="fas fa-list fa-2x"></i></a></div>
        </div>


    </div>
</section>
<%@include file = "includes/footer.jsp" %>
</div>

</body>
</html>