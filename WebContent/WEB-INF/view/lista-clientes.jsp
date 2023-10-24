<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListaCliente</title>

  <jsp:include page="/cabecera.jsp"/>

</head>
<body class="bg-dark">

<jsp:include page="/menu.jsp"/>

<div class="container">



<div class="row">

<div class="col-12">

<h1 class="text-center text-light">Ejemplo De Spring DAO</h1>
<h2 class="text-center text-light">Lista de Clientes</h2>

<table class="table table-dark table-striped text-center">

<tr>
<th>Nombre</th>
<th>Apellido</th>
<th>Email</th>
<th>Modificar</th>
<th>Eliminar</th>
</tr>

<c:forEach var="clienteTemp" items="${clientes}">

<!-- Link para Actualizar -->
<c:url var="linkActualizar" value="/cliente/muestraFormularioActualizar">

<c:param name="clienteId" value="${clienteTemp.id }"></c:param>

</c:url>

<!-- Link para actualizar -->

<c:url var="linkEliminar" value="/cliente/eliminar">

<c:param name="clienteId" value="${clienteTemp.id }"></c:param>

</c:url>


<tr> 
<td>${clienteTemp.nombre} </td>
<td>${clienteTemp.apellido}</td>
<td>${clienteTemp.email}</td>
<td> <a href="${linkActualizar}"> <input type="button" class="btn btn-primary" value="Modificar"></a></td>
<td> <a href="${linkEliminar}"> <input type="button" class="btn btn-warning text-light" value="Eliminar" onClick="if(!(confirm('Seguro que quieres borrar este Cliente?'))) return false"></a></td>
</tr>

</c:forEach>

</table>

</div>
</div>
</div>

</body>
</html>