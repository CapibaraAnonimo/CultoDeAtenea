let formulario = document.forms.aniadir;
let descripcion = formulario.descripcion;
let enviar = formulario.enviar;

descripcion.addEventListener("change", valDescripcion);

function valDescripcion(q) {
    if (descripcion.value()[0] === descripcion.value()[0].toUpperCase()) {

    }
}