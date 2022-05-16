const popperButton = document.querySelectorAll("#eliminar");
const popperPopup = document.querySelectorAll("#popper-popup");
const popperSection = document.querySelector("#popper-section");
const popperArrow = document.querySelectorAll("#popper-arrow");

let popperInstance = null;

//create popper instance
function createInstance() {
    popperInstance = Popper.createPopper(popperButton, popperPopup, {
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
    if (popperInstance) {
        popperInstance.destroy();
        popperInstance = null;
    }
}

//show and create popper
function showPopper(event) {
    popperPopup.setAttribute("show-popper", "");
    popperArrow.setAttribute("data-popper-arrow", "");
    createInstance();
}

//hide and destroy popper instance
function hidePopper(event) {
    popperPopup.removeAttribute("show-popper");
    popperArrow.removeAttribute("data-popper-arrow");
    destroyInstance();
}

//toggle show-popper attribute on popper to hide or show it with CSS
function togglePopper(event) {
    if (event.target.hasAttribute("show-popper")) {
        hidePopper(event);
    } else {
        showPopper(event);
    }
}
//execute togglePopper function when clicking the popper reference/button
for (let i = 0; i<popperButton.length; i++) {
    popperButton[i].addEventListener("click", function (e) {
        e.preventDefault();
        togglePopper(e);
    });
}