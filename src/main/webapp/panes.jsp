<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Panaderia Pan Pan Pan</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container m-auto">
		<div class="m-3">
			<div class="row">
				<div class="col">
					<h2>Lista de Panes</h2>
				</div>
				
				<div class="col">
					<h2><a href="pan">Nuevo Pan</a></h2>
				</div>
			</div>
			
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Descripción</th>
						<th>Precio</th>
						<th>Tamaño</th>
						<th>Fecha</th>
						<th colspan="2" class="text-center">Acciones</th>
					</tr>
				</thead>
		
				<c:forEach var="pan" items="${listaPanes}">
					<tr>
						<td>${pan.getId()}</td>
						<td>${pan.getNombre()}</td>
						<td>${pan.getDescripcion()}</td>
						<td>${pan.getPrecio()}</td>
						<td>${pan.getTamanyo()}</td>
						<td>${pan.getFecha()}</td>
						<td>
							<form action="pan/actualizar">
								<input type="hidden" name="txtId" value="${pan.getId()}">
								<input type="submit" class="btn btn-primary" value="Modificar">
							</form>
						</td>
						
						<td>
							<form action="pan/eliminar" method="post">
								<input type="hidden" name="txtId" value="${pan.getId()}">
								<input type="submit" class="btn btn-danger" value="Eliminar">
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
