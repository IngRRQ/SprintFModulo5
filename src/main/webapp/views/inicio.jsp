<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de Inicio</title>
<!-- Enlace a Bootstrap CSS -->
<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
rel="stylesheet">
<!-- Enlace a la hoja de estilos personalizada -->
<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/styles.css">
<!--Link a googlefont-->
 <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet">
</head>
</head>

<body>
    
     <header class="headline">
      <%@ include file="navbar.jsp"%>
        <div class="container">
            <h1>Bienvenido a Nuestra Empresa</h1>
            <p>Ofrecemos las mejores soluciones en prevención de riesgos.</p>
            <a href="#" class="btn btn-dark btn-lg">Conócenos</a>
        </div>
    </header>
       
    <main>
        <!-- Sección de descripción de la empresa -->
        <section class="container section-description">
            <h3 class="text-center text-md-start mt-4">Somos</h3>
            <p class="text-center text-md-start">
Una empresa de asesorías en prevención de riesgos requiere un sistema de información robusto que 
facilite la gestión eficiente de sus operaciones diarias. Este sistema debe abarcar varios procesos clave,
 como la administración de clientes, la planificación y seguimiento de capacitaciones, y la gestión de profesionales
  y administrativos. En cuanto a la administración de clientes, el sistema debe permitir registrar y actualizar datos, 
  monitorear la asistencia a capacitaciones y mantener un historial de servicios prestados. Para las capacitaciones, 
  es esencial que el sistema permita programar sesiones, asignar instructores, gestionar la asistencia y generar 
  reportes de desempeño y cumplimiento. Además, debe integrar funcionalidades para la gestión del personal, 
  como la asignación de tareas, control de horarios, evaluación de desempeño y manejo de la información de los 
  profesionales en términos de especialización y disponibilidad. Un sistema de información integral no solo optimiza estos procesos, 
  sino que también proporciona herramientas analíticas para tomar decisiones estratégicas basadas en datos reales, mejorando 
  así la eficiencia y la calidad del servicio prestado.            </p>
        </section>
        
        <!-- Sección de capacitaciones con tarjetas de Bootstrap -->
        <div class="container">
            <h3 class="text-center text-md-start section-title">Capacitaciones</h3>
            <div class="row">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <img src="img/cap1.jpg" class="card-img-top" alt="Image 1">
                        <div class="card-body">
                            <h5 class="card-title">Prevención de riesgos en caídas en altura</h5>
                            <p class="card-text">Description for card 1.</p>
                            <a href="#" class="btn btn-dark">Comenzar</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <img src="img/cap2.jpg" class="card-img-top" alt="Image 2">
                        <div class="card-body">
                            <h5 class="card-title">Primeros Auxilios en el trabajo</h5>
                            <p class="card-text">Description for card 2.</p>
                            <a href="#" class="btn btn-dark">Comenzar</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <img src="img/cap3.jpg" class="card-img-top" alt="Image 3">
                        <div class="card-body">
                            <h5 class="card-title">Prevención de riesgos en plaguicidas.</h5>
                            <p class="card-text">Description for card 3.</p>
                            <a href="#" class="btn btn-dark">Comenzar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <%@ include file="footer.jsp"%>
    </footer>
    <!-- JQUERY -->
    <script src="https://code.jquery.com/jquery-3.7.1.slim.js" integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc=" crossorigin="anonymous"></script>
    <!-- CDN de Bootstrap 5.1 -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>