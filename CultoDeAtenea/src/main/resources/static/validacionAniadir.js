let formulario = document.forms.aniadir;
let clasificacion = formulario.elements.clasificacion;
let marca = formulario.marca;
let enviar = formulario.enviar;

for (let c of clasificacion) {
    c.addEventListener("change", valClasificacion);
}

function valClasificacion(q) {
    let seleccionado;

    if (clasificacion[0].checked) {
        clasificacion[0].classList.add("radioInvalid");
    }

    for (let c of clasificacion) {
        if(c.checked)
            seleccionado = c;
    }

    if (marca.value() === 'ColdSteel' && seleccionado.value() === 'decorativa') {
        clasificacion.document.style('color: red');
    }
}