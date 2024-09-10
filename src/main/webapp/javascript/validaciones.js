/**Validaciones del formulario de usuario
 * 
 */

    $(document).ready(function() {
        $("#crearUsuarioForm").submit(function(event) {
            var nombre = $("#nombre").val();
            var rut = $("#rut").val();
            var tipo = $("#tipo").val();
            var telefono = $("#telefono").val();
            var comuna = $("#comuna").val();
            var titulo = $("#titulo").val();
            var area = $("#area").val();
            var fechaIngreso = $("#fechaIngreso").val();

            // Expresión para validar solo letras y espacios
            var soloLetras = /^[a-zA-Z\s]+$/;
            // Expresión para validar RUT en formato 12345678-9
            var rutRegex = /^\d{1,8}-[\dKk]$/;
            // Expresión para validar solo números
            var soloNumeros = /^[0-9]+$/;
            // Expresión para validar la fecha en formato DD/MM/AAAA
            var fechaRegex = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/\d{4}$/;

            // Validar que el nombre solo contenga letras
            if (!nombre.match(soloLetras)) {
                alert("El nombre solo debe contener letras.");
                event.preventDefault();
                return;
            }

            // Validar RUT en formato correcto
            if (!rut.match(rutRegex)) {
                alert("El RUT debe tener el formato correcto (ejemplo: 12345678-9).");
                event.preventDefault();
                return;
            }

            // Validar solo números en el teléfono
            if (telefono && !telefono.match(soloNumeros)) {
                alert("El teléfono solo debe contener números.");
                event.preventDefault();
                return;
            }

            // Validar que la comuna solo contenga letras
            if (comuna && !comuna.match(soloLetras)) {
                alert("La comuna solo debe contener letras.");
                event.preventDefault();
                return;
            }

            // Validar que el área solo contenga letras
            if (area && !area.match(soloLetras)) {
                alert("El área solo debe contener letras.");
                event.preventDefault();
                return;
            }

            // Validar que el título solo contenga letras
            if (titulo && !titulo.match(soloLetras)) {
                alert("El título solo debe contener letras.");
                event.preventDefault();
                return;
            }

            // Validar que la fecha tenga el formato DD/MM/AAAA
            if (fechaIngreso && !fechaIngreso.match(fechaRegex)) {
                alert("La fecha debe estar en formato DD/MM/AAAA.");
                event.preventDefault();
                return;
            }

        });
	});
        