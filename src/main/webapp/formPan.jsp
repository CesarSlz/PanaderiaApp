<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Pan</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container m-auto">
		<div class="m-3">
			<div class="row">
				<div class="col">
					<h2>${accion}</h2>
				</div>
			
				<div class="col">
					<h2><a href="${rutaLista}">Regresar</a></h2>
				</div>
			</div>
		
			<form action="${action}" method="${method}">
			
				<input type="hidden" name="txtId" value="${pan.getId()}">
				
				<div>
					<label for="txtNombre">Nombre</label>
					<input type="text" class="form-control" id="txtNombre" name="txtNombre" value="${pan.getNombre()}">
				</div>
				
				<div>
					<label for="txtDesc">Descripción</label>
					<input type="text" class="form-control" id="txtDes" name="txtDes" value="${pan.getDescripcion()}">
				</div>
				
				<div>
					<label for="txtTamanyo">Tamaño</label>
					<input type="text" class="form-control" id="txtTamanyo" name="txtTamanyo" value="${pan.getTamanyo()}">
				</div>
				
				<div>
					<label for="txtPrecio">Precio</label>
					<input type="text" class="form-control" id="txtPrecio" name="txtPrecio" value="${pan.getPrecio()}">
				</div>
				
				<br>
				
				<input type="submit" class="btn btn-primary" value="${boton}">
			</form>
		</div>
	</div>
</body>
</html>