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
	<main class="container">
		<h3 class="mb-3">Lista de Usuarios</h3>
		<table class="table">

			<thead>
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
                List<Usuario> usuario = (List<Usuario>)request.getAttribute("usuarios");
                    for(Usuario u : usuario){
                        %>
				
				<tr>
					<th scope="row"><%=u.getId()%></th>
					<td><%=u.getNombre()%></td>
					<td><%=u.getRut()%></td>
					<td><%=u.getTipo()%></td>
					<td>
                    <button type="button" class="btn btn-warning" onclick="editUser(<%=u.getId()%>)">Editar</button>
                    <button type="button" class="btn btn-danger" onclick="deleteUser(<%=u.getId()%>)">Borrar</button>
                </td>
				</tr>
				<%}%>

			</tbody>
		</table>
	</main>
	<div class="selector">
    <div class="container mt-5">
        <div class="d-flex justify-content-center">
            <h3>Selecciona lista según tipo de usuario</h3>
        </div>
        <div class="d-flex justify-content-center mt-3">
            <div class="btn-group" role="group" aria-label="Botones de selección">
                <button type="button" class="btn btn-warning" onclick="navigateTo('cliente.jsp')">Cliente</button>
                <button type="button" class="btn btn-secondary" onclick="navigateTo('profesional.jsp')">Profesional</button>
                <button type="button" class="btn btn-warning" onclick="navigateTo('administrativo.jsp')">Administrativo</button>
                <button type="button" class="btn btn-dark" onclick="navigateTo('otro.jsp')">Otro</button>
            </div>
        </div>
    </div>
</div>
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
    function editUser(id) {
        // Lógica para editar usuario
        window.location.href = 'editarUsuario.jsp?id=' + id;
    }

    function deleteUser(id) {
        // Lógica para borrar usuario
        if (confirm('¿Estás seguro de que deseas borrar este usuario?')) {
            window.location.href = 'borrarUsuario.jsp?id=' + id;
        }
    }
</script>
</body>
</html>
