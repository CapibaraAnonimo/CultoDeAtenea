let altura = 0;
let elemento = document.querySelector("nav:first-of-type");
altura = elemento.getBoundingClientRect().height;
document.querySelector("main").style.cssText += "max-height: " + (window.innerHeight - altura - (16 * 0.5 * 2)) + "px; min-height: " + (window.innerHeight - altura - (16 * 0.5 * 2)) + "px;";
window.addEventListener("resize", reescalar);

function reescalar() {
    altura = elemento.getBoundingClientRect().height;
    document.querySelector("main").style.cssText += "max-height: " + (window.innerHeight - altura - (16 * 0.5 * 2)) + "px; min-height: " + (window.innerHeight - altura - (16 * 0.5 * 2)) + "px;";
}