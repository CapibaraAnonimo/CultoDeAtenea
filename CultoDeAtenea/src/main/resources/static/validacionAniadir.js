let formulario = document.forms.aniadir;
let clasificacion = formulario.elements.clasificacion;
let marca = formulario.elements.marca;
let enviar = formulario.enviar;
let errores = document.querySelectorAll(".mensajeError");

for (let c of clasificacion) {
    c.addEventListener("change", valClasificacion);
}
marca.addEventListener("change", valClasificacion);


for (let e of errores) {
    e.style.display = 'none';
}


function valClasificacion() {
    let claSeleccionado;

    for (let c of clasificacion) {
        if (c.checked)
            claSeleccionado = c;
    }

    if (marca.options[marca.selectedIndex].value === 'ColdSteel' && clasificacion.value === 'decorativa') {
        clasificacion[2].classList.add('radioInvalid');
        enviar.classList.add('disabled')
        document.getElementById("errorClasificación").style.display = 'block';
    } else {
        clasificacion[2].classList.remove('radioInvalid');
        enviar.classList.remove('disabled')
        document.getElementById("errorClasificación").style.display = 'none';
    }
}