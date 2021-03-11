<%@page import="com.senati.web.jsps.servlet.vo.VOLogin" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panel de control</title>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<script src="../js/bootstrap.min.js"></script>
<script>
	function guardar(){
		var forma=document.getElementById("formaUsuarios");
		forma.action="../adminUsuarios.servlet";
		var accion=document.getElementById("accion");
		accion.value="guardar";
		forma.submit();
	}
	function actualizar(){
		var forma=document.getElementById("formaUsuarios");
		forma.action="../adminUsuarios.servlet";
		var accion=document.getElementById("accion");
		accion.value="actualizar";
		forma.submit();
	}
	function eliminar(){
		var forma=document.getElementById("formaUsuarios");
		forma.action="../adminUsuarios.servlet";
		var accion=document.getElementById("accion");
		accion.value="eliminar";
		forma.submit();
	}
</script>
</head>
<body>
<div class="container">
<div class="now">
<div class=col-md-2>
</div>
<div class="col-md-8">
<h1 class="text-center">Escuela de Tecnologias de la Información</h1>
<h2 class="text-center">Panel principal</h2>
	<h3 class="text-center">Sistema</h3>
	<p class="text-center">
		<%= ((VOLogin)session.getAttribute("usuarioLogueado")).getNombre() %>
	</p>
	<form action="" method="post" id="formaUsuarios">
	<input type="hidden" name="accion" id="accion">
	<div class="form-group">
	<label>Usuario</label>
	<input type="text" name="usuario" class="form-control">
	<label>Clave</label>
	<input type="password" name="clave" class="form-control">
	<label>Nombre</label>
	<input type="text" name="nombre" class="form-control">
	<label>Edad</label>
	<input type="text" name="edad" class="form-control">
	</div>
	<input type="button" value="guardar" class="btn btn-primary" onclick="guardar();">
	<input type="button" value="actualizar" class="btn btn-default" onclick="actualizar();">
	<input type="button" value="eliminar" class="btn btn-success" onclick="eliminar();">
	</form>
	<table class="table table-condensed">
	<tr>
	<th>Usuario</th>
	<th>Nombre</th>
	<th>Edad</th>
	</tr>
	<%
		
		List<VOLogin> list=(List<VOLogin>)session.getAttribute("listaUsuario"));
		for (VOLogin obj: lista){
	%>
	<tr>
		<td><%=obj.getUsuario()  %></td>
		<td><%=obj.getNombre()  %></td>
		<td><%=obj.getEdad()  %></td>
	</tr>
	<%
		}
	%>
	</table>
	</div>
	<div class="col-md-2">
	</div>
	</div>
	</div>
</body>
</html>