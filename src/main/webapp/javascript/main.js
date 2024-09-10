/**
 * 
 */
document.getElementById('tipo').addEventListener('change', function() {
	// Oculta todos los campos adicionales
	hideAndRemoveRequired('clienteFields', ['telefono', 'comuna']);
	document.getElementById('clienteFields').style.display = 'none';
	hideAndRemoveRequired('profesionalFields', ['titulo', 'fechaIngreso']);
	document.getElementById('profesionalFields').style.display = 'none';
	hideAndRemoveRequired('administrativoFields', ['area', 'experienciaPrevia']);
	document.getElementById('administrativoFields').style.display = 'none';

	// Muestra los campos correspondientes según el tipo de usuario seleccionado
	const tipoUsuario = this.value;
	if (tipoUsuario === 'Cliente') {
		showAndAddRequired('clienteFields', ['telefono', 'comuna']);
		document.getElementById('clienteFields').style.display = 'block';
	} else if (tipoUsuario === 'Profesional') {
		showAndAddRequired('profesionalFields', ['titulo', 'fechaIngreso']);
		document.getElementById('profesionalFields').style.display = 'block';
	} else if (tipoUsuario === 'Administrativo') {
		showAndAddRequired('administrativoFields', ['area', 'experienciaPrevia']);
		document.getElementById('administrativoFields').style.display = 'block';
	}


});


//Función para que los campos de los tipos de usuario sean "required" al momento de seleccionar el tipo
function showAndAddRequired(fieldId, fieldNames) {

	document.getElementById(fieldId).style.display = 'block';
	fieldNames.forEach(function(name) {
		document.getElementById(name).setAttribute('required', 'required');
	});
}

function hideAndRemoveRequired(fieldId, fieldNames) {
	document.getElementById(fieldId).style.display = 'none';
	fieldNames.forEach(function(name) {
		document.getElementById(name).removeAttribute('required');
	});
}


