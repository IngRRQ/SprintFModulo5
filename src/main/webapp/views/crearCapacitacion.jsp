<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Crear Capacitación</title>
  <link
  	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"	rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
  </head>
  <body>
  	<header>
		<%@ include file="navbar2.jsp"%>
	 </header>
	 <main>
		<div class="container position-absolute top-50 start-50 translate-middle">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card shadow-lg p-4">
                    <h2 class="mb-4 text-left">Registro de Capacitación</h2>
        	<form action="crearcapacitacion" method="POST">
            	<div class="mb-3">
              		<label for="identificador" class="form-label">Identifique su capacitación</label>
              		<select class="form-select" aria-label="Default select example">
                		<option value="" selected disabled>Seleccione la Capacitación</option>
                		<option value="1">1 .Prevención de Riesgos en el Trabajo</option>
                		<option value="2">2 .Uso y Manejo de Extintores</option>
                		<option value="3">3 .Primeros Auxilios</option>
                		<option value="4">4 .Trabajos en Altura</option>
                		<option value="5">5 .Manejo de Sustancias Peligrosas</option>
                		<option value="6">6 .Espacios Confinados</option>
                		<option value="7">7 .Ergonomía y Prevención de Lesiones Musculoesqueléticas</option>
                		<option value="8">8 .Seguridad Eléctrica</option>
                		<option value="9">9 .Control de Emergencias y Planes de Evacuación</option>
                		<option value="10">10 .Uso de Equipos de Protección Personal (EPP)</option>
                		<option value="11">11 .Seguridad Vial y Manejo Defensivo</option>
                		<option value="12">12 .Manipulación Manual de Cargas</option>
                		<option value="13">13 .Prevención de Riesgos Psicosociales</option>
                		<option value="14">14 .Seguridad en el Uso de Maquinaria y Herramientas</option>
                		<option value="15">15 .Normativa Legal y Reglamentación en Prevención de Riesgos</option>
              		</select>
            	</div>
            	<div class="mb-3">
              		<label for="dia" class="form-label">Día</label> 
              		<select class="form-select" aria-label="Dia de Semana" id="dia" name="dia" required>
                		<option value="" selected disabled>Seleccione el día de la capacitación</option>
                		<option value="Lunes">Lunes</option>
                		<option value="Martes">Martes</option>
                		<option value="Miercoles">Miércoles</option>
                		<option value="Jueves">Jueves</option>
                		<option value="Viernes">Viernes</option>
              		</select>
            	</div>
            	<div class="mb-3">
              		<label for="hora" class="form-label">Hora</label>
              		<input type="text" class="form-control" id="hora" name="hora" required placeholder="Ingrese la hora de la capacitación"> 
            	</div>
            	<div class="mb-3">
              		<label for="lugar" class="form-label">Lugar</label>
              		<input type="text" class="form-control" id="lugar" name="lugar" required placeholder="Ingrese el lugar de la capacitación">
            	</div>
            	<div class="mb-3">
              		<label for="duracion" class="form-label">Duración (minutos)</label> 
              		<input type="number" class="form-control" id="duracion" name="duracion" required placeholder="Ingrese la duración en horas">
            	</div>
            	<div class="mb-3">
              		<label for="cantidadAsistentes" class="form-label">Cantidad de asistentes</label> 
              		<input type="number" class="form-control" id="cantidadAsistentes" name="cantidadAsistentes" required placeholder="Ingrese la cantidad de asistentes">
            	</div>
            	<button type="submit" class="btn btn-dark">Registrar</button>
        	</form>
        	<br>
        	<!-- Mensaje de registro exitoso al recibir confirmacion del Servlet -->
            	
            	<% String message = (String)request.getAttribute("message"); if(message != null){ %>
            	
            	<div class="alert alert-success alert-dismissible fade show" role="alert">
              	<%= message %>
              	<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            	</div>
            	<%} %>
          </div>
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
  </body>
</html>