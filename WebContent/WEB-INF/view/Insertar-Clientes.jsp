<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar Clientes</title>
 <jsp:include page="/cabecera.jsp"/>
</head>
<body class="bg-dark">

<jsp:include page="/menu.jsp"/>

<div class="container">

<form:form action="insertarCliente" modelAttribute="cliente" method="POST" class="row g-3">

  <div class="col-md-6">
    <label for="inputEmail4" class="form-label text-light">Nombre</label>
    <form:input  class="form-control"  path="nombre" placeholder="ejemplo:jaime"/>
  </div>

  <div class="col-12">
    <label for="inputAddress" class="form-label text-light">Apellido</label>
    <form:input  class="form-control"  path="apellido" placeholder="ejemplo:Perez"/>
  </div>
  <div class="col-12">
    <label for="inputAddress2" class="form-label text-light">Email</label>
    <form:input  class="form-control"  path="email" placeholder="ejemplo: usuario@gmail.com"/>
  </div>
  
  
  
  <div class="col-12">
    <button type="submit" class="btn btn-primary">Crear nuevo cliente</button>
  </div>
</form:form>

</div>


</body>
</html>