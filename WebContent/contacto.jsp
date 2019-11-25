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

<%@include file = "includes/header.jsp" %>
<%@include file = "includes/nav.jsp" %>
<section>
<div class="container">

        <form action="AltaContacto" method="post">
		 <div class="row">
		    <div class="col">
		    <label>Nombre:</label>
		      <input type="text" name="nombre" class="form-control" placeholder="Nombre">
		    </div>
		    <div class="col">
		    <label>Apellido:</label>
		      <input type="text" name="apellido" class="form-control" placeholder="Apellido">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label>Email:</label>
		    <input type="email" class="form-control" name="mail" aria-describedby="emailHelp" placeholder="Introduce tu correo">
		  </div>
		  <div class="form-group">
		    <label>Contraseña:</label>
		    <input type="password" name="clave" class="form-control" placeholder="Contraseña">
		  </div>		 
		  <button type="submit" class="btn btn-primary">Submit</button>
       </form>

                    
                            
    
    </div>
</section>
<%@include file = "includes/footer.jsp" %>
</div>

</body>
</html>