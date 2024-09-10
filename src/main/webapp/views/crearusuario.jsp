<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Usuario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<header>
		<%@ include file="navbar2.jsp"%>
	</header>
	<main>
		<section
			class="container position-absolute top-50 start-50 translate-middle col-6">
				<div class="card shadow-lg p-4">
					<h2 class="mb-4 text-left">Registro de Usuario</h2>
						<form action="crearusuario" method="POST" id="crearUsuarioForm">
						<div class="row">
						<div class="col-12">
						<div class="mb-3">
							<label for="nombre" class="form-label">Nombre de usuario</label>
							<input type="text" class="form-control" id="nombre" name="nombre"
								required placeholder="Ingrese el nombre del usuario">
						</div>
						<div class="mb-3">
							<label for="rut" class="form-label">RUT</label> <input
								type="text" class="form-control" id="rut" name="rut" required
								placeholder="Ingrese el RUT del usuario">
						</div>
						<div class="mb-3">
							<label for="tipo" class="form-label">Tipo de usuario</label> <select
								class="form-select" aria-label="Default select example"
								id="tipo" name="tipo" required>
								<option value="" selected disabled>Seleccione el tipo
									de usuario</option>
								<option value="Administrativo">Administrativo</option>
								<option value="Cliente">Cliente</option>
								<option value="Profesional">Profesional</option>
							</select>
							<br/>

							<!-- Campos adicionales que se mostrarán dependiendo del tipo de usuario -->
							<div class="mb-3" id="clienteFields" style="display: none;">
								<label for="telefono" class="form-label">Teléfono</label> <input type="text"
									id="telefono" name="telefono" class="form-control" placeholder="Ingrese el teléfono del cliente" required><br>
								 <label for="comuna" class="form-label">Comuna</label> <input type="text"
									id="comuna" name="comuna" class="form-control" placeholder="Ingrese la comuna del cliente" required><br>
								<br>
							</div>

							<div  class="mb-3" id="profesionalFields" style="display: none;">
								<label for="titulo" class="form-label">Título</label> <input type="text"
									id="titulo" name="titulo" class="form-control" placeholder="Ingrese el título del profesional" required><br>
								 <label for="fechaIngreso" class="form-label">Fecha de Ingreso</label>
								<input type="date" id="fechaIngreso" name="fechaIngreso" class="form-control" placeholder="Ingrese la fecha de ingreso del profesional" required><br>
								<br>
							</div>

							<div  class="mb-3" id="administrativoFields" style="display: none;">
								<label for="area" class="form-label">Área</label> <input
									type="text" id="area" name="area" class="form-control" placeholder="Ingrese el área del administrativo" required><br>
								 <label for="experienciaPrevia" class="form-label">Experiencia Previa</label> <input
									type="text" id="experienciaPrevia" name="experienciaPrevia" class="form-control" placeholder="Ingrese la experiencia previa del administrativo" required><br>
								<br>
							</div>
						</div>
						<button type="submit" class="btn btn-dark">Registrar</button>
						</div>
						</div>
						</form>
						<br>
			<!-- Mensaje de registro exitoso al recibir confirmacion del Servlet -->
			<%
			String message = (String) request.getAttribute("message");
			if (message != null) {
			%>
			<div class="alert alert-success alert-dismissible fade show m-3"
				role="alert">
				<%=message%>
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
			<%
			}
			%>
					</div>
				</div>
			
		</section>
	</main>
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>
	<!-- Javascript custom -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/main.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/validaciones.js"></script>
	<!-- JQUERY -->
	<script src="https://code.jquery.com/jquery-3.7.1.slim.js"
		integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc="
		crossorigin="anonymous"></script>
	<!-- CDN de Bootstrap 5.0 -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
</body>
</html>