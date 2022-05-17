const popperButton = document.querySelectorAll(".eliminar");
const popperPopup = document.querySelectorAll(".popper-popup");
const popperSection = document.querySelector(".popper-section");
const popperArrow = document.querySelectorAll(".popper-arrow");

let posicion = 0;
let popperInstance = new Array(popperButton.length);

//create popper instance
function createInstance() {
    popperInstance[posicion] = Popper.createPopper(popperButton, popperPopup, {
        placement: 'right', //preferred placement of popper
        modifiers: [
            {
                name: "offset", //offsets popper from the reference/button
                options: {
                    offset: [0, 8]
                }
            },
            {
                name: "flip", //flips popper with allowed placements
                options: {
                    allowedAutoPlacements: ["right", "left", "top", "bottom"],
                    rootBoundary: "viewport"
                }
            }
        ]
    });
}

//destroy popper instance
function destroyInstance() {
    if (popperInstance[posicion]) {
        popperInstance.destroy();
        popperInstance = null;
    }
}

//show and create popper
function showPopper(element) {
    element.nextElementSibling.setAttribute("show-popper", "");
    element.nextElementSibling.lastElementChild.setAttribute("data-popper-arrow", "");
    createInstance();
}

//hide and destroy popper instance
function hidePopper(element) {
    element.nextElementSibling.removeAttribute("show-popper");
    element.lastElementChild.removeAttribute("data-popper-arrow");
    destroyInstance();
}

//toggle show-popper attribute on popper to hide or show it with CSS
function togglePopper(element) {
    if (element.hasAttribute("show-popper")) {
        hidePopper(element);
    } else {
        showPopper(element);
    }
}

//execute togglePopper function when clicking the popper reference/button
for (let i = 0; i < popperButton.length; i++) {
    popperButton[i].addEventListener("click", function (e) {
        let aux = 0;
        for (let p of popperButton) {
            if (p.compareDocumentPosition(e.target)/*p.id === e.target.id*/) {
                posicion = aux;
            } else {
                aux = aux + 1;
            }
        }
        alert(posicion)
        e.preventDefault();
        togglePopper(e.target);
    });
}