<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html> 
<%@ page import="modelos.*"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Listar capacitación</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"   integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    </head>
    <body>
        <header>
            <%@ include file="navbar2.jsp" %>
        </header>
        <main class="container mt-4">
    <h3 class="mb-3 text-left">Lista de Capacitación</h3>
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead class="table-dark">
                    <tr>
                        <th scope="col">Identificador</th>   
                        <th scope="col">Día</th>
                        <th scope="col">Hora</th>
                        <th scope="col">Lugar</th>
                        <th scope="col">Duración</th>
                        <th scope="col">Cantidad Asistentes</th>
                    </tr>
                </thead>
                <tbody>
                <!-- Codigo Java con for each para que la tabla se llene con los datos que ingresa el cliente en crearcapacitacion -->
                <%
                List<Capacitacion> capacitacion = (List<Capacitacion>)request.getAttribute("capacitaciones");
                    for(Capacitacion c : capacitacion){
                        %>
                    <tr>
                        <th scope="row"><%=c.getIdentificador()%></th>
                        <td><%=c.getDia()%></td>
                        <td><%=c.getHora()%></td>
                        <td><%=c.getLugar()%></td>
                        <td><%=c.getDuracion()%></td>
                        <td><%=c.getCantidadAsistentes()%></td>
                    </tr><%}%>
                </tbody>
            </table>
        		</div>
        		<div class="col-2"></div>		
        	</div>
        </main>
        <footer>
            <%@ include file="footer.jsp" %>
        </footer>
        <!-- JQUERY -->
			<script src="https://code.jquery.com/jquery-3.7.1.slim.js"		integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc="		crossorigin="anonymous"></script>
		<!-- CDN de Bootstrap 5.0 -->
			<script 	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
			<script		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"	crossorigin="anonymous"></script>
    </body>
    </html>