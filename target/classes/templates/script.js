let buttonGS = document.querySelector(".buttons_googlePlay")
let buttonAS = document.querySelector(".buttons_appleStore")
buttonGS.onmouseover = function(event) {
    buttonGS.innerHTML = "Скоро будет"
};
buttonGS.onmouseout = function(event) {
    buttonGS.innerHTML = "<div class=" 
                        +"gsIMG" 
                        +"></div> <div class=" 
                        + "flex" 
                        + ">Скачать с <span>Google Store</span>  </div>"
};

buttonAS.onmouseover = function(event) {
    buttonAS.innerHTML = "Скоро будет"
};
buttonAS.onmouseout = function(event) {
    buttonAS.innerHTML = "<div class=" 
                        +"appIMG" 
                        +"></div> <div class=" 
                        + "flex" 
                        + ">Скачать с <span>App Store</span>  </div>"
};

