let campo = document.querySelector("#socialcard")
// se trae la info del .json

//contador likes
/*let contador = 0;
let msg = "Solo puedes dar un like por obra de arte"
function contar() {
    document.getElementById("btnlikes").innerHTML = contador++;
    if (contador = 1) {
        alert(msg)
    }
}*/

const getData = async () => {

    const resp = await fetch(url);
    console.log(resp)

    const data = await resp.json();
    data.forEach(card => {
        const {image, name, author, price, collection, forsale} = card;
        campo.innerHTML += ` 
         <div class="card">
                <img src="${image}" alt="">
                <p style="color:blue; font-weight:bold">${"Titulo: " + name}</p>
                <p>${"Autor: " + author}</p>
                <p>${"Precio: " + price}</p>
                <p>${"Colección: " + collection}</p>
                <p>${"En venta: " + forsale}</p>
                <button id="btncomprar" style="border-radius:50px;width: 100px;height: 60px;margin-left: 150px;" class="btn btn-primary">Comprar</button>         
            </div> 
       `
    })
}
window.addEventListener('DOMContentLoaded', getData);