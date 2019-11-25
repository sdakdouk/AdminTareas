<%@page import="modelo.Categoria"  %>
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
Categoria tr= new Categoria(); 
if (request.getAttribute("id") != null) {
	String id = "0";
	id = request.getAttribute("id").toString();
tr.buscarID(Integer.parseInt(id));
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
            <form  action="AltaCategoria" method="post" >
                   <div class="form-group">
                   <input type="hidden" name="opcion" value="1">
                    <input type="hidden" name="id" id="id" value="<%if (request.getAttribute("id") != null) out.print(tr.getId()); %>">
                   
                   </div>
                    
 
                    <div class="form-group">
                        <label for="exampleInputEmail1" class="nombre">Nombre</label>
                        <input type="text" name="nombre" class="form-control" id="exampleInputEmail1" value="<%if (request.getAttribute("id") != null)
				out.print(tr.getNombre());%>" required placeholder="Nombre">
                    </div>
                    
  
   
  <button type="submit" class="btn btn-primary">Submit</button>
                    
                    
                            
    </form>
    
    </div>
            <div class="col-md-2 ">
            <a class="nav-link" href="listaCategoria"><i class="fas fa-list fa-2x"></i></a></div>
        </div>


    </div>
</section>
<%@include file = "includes/footer.jsp" %>
</div>

</body>
</html>