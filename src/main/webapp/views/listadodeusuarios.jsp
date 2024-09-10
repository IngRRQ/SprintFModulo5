<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="modelos.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<html>
<head>
<meta charset="UTF-8">
<title>Listado de Usuarios</title>
<!-- Enlace a Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Enlace a la hoja de estilos personalizada -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<header>
		<%@ include file="navbar2.jsp"%>
	</header>
	<main class="container mt-4">
		<h3 class="mb-3 text-left">Lista de Usuarios</h3>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id="tablaUsuario">
				<thead class="table-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Rut</th>
						<th scope="col">Tipo</th>
					</tr>
				</thead>
				<tbody>
					<tr>


						<!-- Codigo Java con for each para que la tabla se llene con los datos que ingresa el cliente en crearcapacitacion -->
						<%
						List<Usuario> usuario = (List<Usuario>) request.getAttribute("usuarios");
						for (Usuario u : usuario) {
						%>
					
					<tr>
						<th scope="row"><%=u.getId()%></th>
						<td><%=u.getNombre()%></td>
						<td><%=u.getRut()%></td>
						<td><%=u.getTipo()%></td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id="tablaCliente"
				style="Display: none;">

				<thead class="table-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Rut</th>
						<th scope="col">Tipo</th>
						<th scope="col">Teléfono</th>
						<th scope="col">Comuna</th>
						<th scope="col">Editar</th>
						<th scope="col">Borrar</th>
					</tr>
				</thead>
				<tbody>
					<tr>


						<!-- Codigo Java con for each para que la tabla se llene con los datos que ingresa el cliente en crearcapacitacion -->
						<%
						Cliente editCL = new Cliente();
						List<Cliente> cliente = (List<Cliente>) request.getAttribute("clientes");
						for (Cliente cl : cliente) {
						%>
					
					<tr>
						<th scope="row"><%=cl.getId()%></th>
						<td><%=cl.getNombre()%></td>
						<td><%=cl.getRut()%></td>
						<td><%=cl.getTipo()%></td>
						<td><%=cl.getTelefono()%></td>
						<td><%=cl.getComuna()%></td>
						<td>
							<button type="button" class="btn btn-warning"
								onclick="<%editCL = cl;%>" data-bs-toggle="modal"
								data-bs-target="#editarCliente">Editar</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger"
								onclick="deleteUser(<%=cl.getId()%>, '<%=cl.getTipo()%>')">Borrar</button>
						</td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
			</div>
			<table class="table table-striped table-hover"
				id="tablaAdministrativo" style="Display: none;">

				<thead class="table-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Rut</th>
						<th scope="col">Tipo</th>
						<th scope="col">Área</th>
						<th scope="col">Experiencia Previa</th>
						<th scope="col">Editar</th>
						<th scope="col">Borrar</th>
					</tr>
				</thead>
				<tbody>
					<tr>


						<!-- Codigo Java con for each para que la tabla se llene con los datos que ingresa el cliente en crearcapacitacion -->
						<%
						Administrativo editAD = new Administrativo();
						List<Administrativo> administrativo = (List<Administrativo>) request.getAttribute("administrativos");
						for (Administrativo a : administrativo) {
						%>
					
					<tr>
						<th scope="row"><%=a.getId()%></th>
						<td><%=a.getNombre()%></td>
						<td><%=a.getRut()%></td>
						<td><%=a.getTipo()%></td>
						<td><%=a.getArea()%></td>
						<td><%=a.getExperienciaPrevia()%></td>
						<td>
							<button type="button" class="btn btn-warning" data-bs-toggle="modal"
								data-bs-target="#editarAdministrativo"
								onclick="<%editAD=a;%>">Editar</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger"
								onclick="deleteUser(<%=a.getId()%>, '<%=a.getTipo()%>')">Borrar</button>
						</td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
			<table class="table table-striped table-hover" id="tablaProfesional"
				style="Display: none;">

				<thead class="table-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Rut</th>
						<th scope="col">Tipo</th>
						<th scope="col">Título</th>
						<th scope="col">Fecha de Ingreso</th>
						<th scope="col">Editar</th>
						<th scope="col">Borrar</th>
					</tr>
				</thead>
				<tbody>
					<tr>


						<!-- Codigo Java con for each para que la tabla se llene con los datos que ingresa el cliente en crearcapacitacion -->
						<%
						Profesional editPF = new Profesional();
						List<Profesional> profesional = (List<Profesional>) request.getAttribute("profesionales");
						for (Profesional p : profesional) {
						%>
					
					<tr>
						<th scope="row"><%=p.getId()%></th>
						<td><%=p.getNombre()%></td>
						<td><%=p.getRut()%></td>
						<td><%=p.getTipo()%></td>
						<td><%=p.getTitulo()%></td>
						<td><%=p.getFechaIngreso()%></td>
						<td>
							<button type="button" class="btn btn-warning"
								data-bs-toggle="modal" data-bs-target="#editarProfesional"
								onclick="<%editPF = p;%>">Editar</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger"
								onclick="deleteUser(<%=p.getId()%>, '<%=p.getTipo()%>')">Borrar</button>
						</td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>

			<div class="container selector mt-5">
				<div class="d-flex justify-content-center">
					<h3>Selecciona lista según tipo de usuario</h3>
				</div>
				<div class="d-flex justify-content-center mt-3">
					<div class="btn-group" role="group"
						aria-label="Botones de selección">
						<button type="button" class="btn btn-warning" id="buttonCliente">Cliente</button>
						<button type="button" class="btn btn-secondary"
							id="buttonProfesional">Profesional</button>
						<button type="button" class="btn btn-warning"
							id="buttonAdministrativo">Administrativo</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Formularios ocultos que editan -->

		<div class="modal fade" id="editarCliente" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Editar
							Cliente</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<!-- Aqui empieza el form de cliente -->
					<form action="listadodeusuarios" method="POST">
						<div class="mb-3">
							<label for="nombre" class="form-label">Nombre de usuario</label>
							<input type="text" class="form-control" id="nombre" name="nombre"
								required value="<%=editCL.getNombre()%>">
						</div>
						<div class="mb-3">
							<label for="rut" class="form-label">RUT</label> <input
								type="text" class="form-control" id="rut" name="rut" required
								value="<%=editCL.getRut()%>">
						</div>
						<div class="mb-3">
							<label for="telefono" class="form-label">Teléfono</label> <input
								type="text" id="telefono" name="telefono" class="form-control"
								value="<%=editCL.getTelefono()%>" required><br> <label
								for="comuna" class="form-label">Comuna</label> <input
								type="text" id="comuna" name="comuna" class="form-control"
								value="<%=editCL.getComuna()%>" required><br> <br>
						</div>
						<div class="mb-3">
							<label for="id" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="id" name="id"
								required value="<%=editCL.getIdCL()%>">
						</div>
						<div class="mb-3">
							<label for="tipo" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="tipo" name="tipo"
								required value="<%=editCL.getTipo()%>">
						</div>
						<div class="mb-3">
							<label for="action" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="action"
								name="action" required value="actualizar">
						</div>
						<button
							type="submit" class="btn btn-dark">Guardar Cambios</button>
					</form>
				</div>
			</div>
		</div>

		<div class="modal fade" id="editarAdministrativo" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Editar
							Administrativo</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<!-- Aqui empieza el form de administrativo-->
					<form action="listadodeusuarios" method="POST">
						<div class="mb-3">
							<label for="nombre" class="form-label">Nombre de usuario</label>
							<input type="text" class="form-control" id="nombre" name="nombre"
								required value="<%=editAD.getNombre()%>">
						</div>
						<div class="mb-3">
							<label for="rut" class="form-label">RUT</label> <input
								type="text" class="form-control" id="rut" name="rut" required
								value="<%=editAD.getRut()%>">
						</div>
						<div class="mb-3">
							<label for="area" class="form-label">Área</label> <input
								type="text" id="area" name="area" class="form-control"
								value="<%=editAD.getArea()%>" required><br> <label
								for="feexperienciaPrevia" class="form-label">Experiencia Previa</label> <input
								type="text" id="experienciaPrevia" name="experienciaPrevia"
								class="form-control" value="<%=editAD.getExperienciaPrevia()%>"
								required><br> <br>
						</div>
						<div class="mb-3">
							<label for="id" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="id" name="id"
								required value="<%=editAD.getIdAD()%>">
						</div>
						<div class="mb-3">
							<label for="tipo" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="tipo" name="tipo"
								required value="<%=editAD.getTipo()%>">
						</div>
						<div class="mb-3">
							<label for="action" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="action"
								name="action" required value="actualizar">
						</div>
						<button
							type="submit" class="btn btn-dark">Guardar Cambios</button>
					</form>
				</div>
			</div>
		</div>

		<div class="modal fade" id="editarProfesional" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Editar
							Profesional</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<!-- Aqui empieza el form de profesional -->
					<form action="listadodeusuarios" method="POST">
						<div class="mb-3">
							<label for="nombre" class="form-label">Nombre de usuario</label>
							<input type="text" class="form-control" id="nombre" name="nombre"
								required value="<%=editPF.getNombre()%>">
						</div>
						<div class="mb-3">
							<label for="rut" class="form-label">RUT</label> <input
								type="text" class="form-control" id="rut" name="rut" required
								value="<%=editPF.getRut()%>">
						</div>
						<div class="mb-3">
							<label for="titulo" class="form-label">Título</label> <input
								type="text" id="titulo" name="titulo" class="form-control"
								value="<%=editPF.getTitulo()%>" required><br> <label
								for="fechaIngreso" class="form-label">Fecha de Ingreso</label> <input
								type="date" id="fechaIngreso" name="fechaIngreso"
								class="form-control" value="<%=editPF.getFechaIngreso()%>"
								required><br> <br>
						</div>
						<div class="mb-3">
							<label for="id" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="id" name="id"
								required value="<%=editPF.getIdPF()%>">
						</div>
						<div class="mb-3">
							<label for="tipo" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="tipo" name="tipo"
								required value="<%=editPF.getTipo()%>">
						</div>
						<div class="mb-3">
							<label for="action" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="action"
								name="action" required value="actualizar">
						</div>
						<button
							type="submit" class="btn btn-dark">Guardar Cambios</button>
					</form>
				</div>
			</div>
		</div>
	</main>

	<footer>
		<%@ include file="footer.jsp"%>
	</footer>
	<!-- JQUERY -->
	<script src="https://code.jquery.com/jquery-3.7.1.slim.js"
		integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc="
		crossorigin="anonymous"></script>
	<!-- CDN de Bootstrap 5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>

	<script>
        function navigateTo(page) {
            window.location.href = page;
        }
    </script>
	<script>
    
    function deleteUser(id, tipo, action) {
        // Lógica para borrar usuario
        if (confirm('¿Estás seguro de que deseas borrar este '+tipo+'?')) {
        	var form = document.createElement('form');
            form.method = 'POST';
            form.action = 'listadodeusuarios'; // El destino donde se manejará el POST

            // Crear un campo oculto para el ID del usuario
            var inputId = document.createElement('input');
            inputId.type = 'hidden';
            inputId.name = 'id';
            inputId.value = id;
            
         	// Crear un campo oculto para el tipo del usuario
            var inputTipo = document.createElement('input');
            inputTipo.type = 'hidden';
            inputTipo.name = 'tipo';
            inputTipo.value = tipo;
            
         	// Crear un campo oculto para el tipo del usuario
            var inputAction = document.createElement('input');
            inputAction.type = 'hidden';
            inputAction.name = 'action';
            inputAction.value = 'borrar';
            
            // Añadir el campo al formulario
            form.appendChild(inputId);
            form.appendChild(inputTipo);
            form.appendChild(inputAction);

            // Añadir el formulario al body y enviarlo
            document.body.appendChild(form);
            form.submit();
        }
    }
    
  //Funciones para cambio de tabla on click
    document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('buttonCliente').addEventListener('click', function() {
    	document.getElementById('tablaUsuario').style.display = 'none';
    	document.getElementById('tablaProfesional').style.display = 'none';
    	document.getElementById('tablaAdministrativo').style.display = 'none';
    	document.getElementById('tablaCliente').style.display = 'block';
    });

    document.getElementById('buttonProfesional').addEventListener('click', function() {
    	document.getElementById('tablaUsuario').style.display = 'none';
    	document.getElementById('tablaProfesional').style.display = 'block';
    	document.getElementById('tablaAdministrativo').style.display = 'none';
    	document.getElementById('tablaCliente').style.display = 'none';
    });

    document.getElementById('buttonAdministrativo').addEventListener('click', function() {
    	document.getElementById('tablaUsuario').style.display = 'none';
    	document.getElementById('tablaProfesional').style.display = 'none';
    	document.getElementById('tablaAdministrativo').style.display = 'block';
    	document.getElementById('tablaCliente').style.display = 'none';
    });
    });
</script>

</body>
</html>
