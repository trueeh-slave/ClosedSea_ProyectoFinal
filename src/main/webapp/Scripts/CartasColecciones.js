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
        const { titulo, categoria, descripcion } = card;
        campo.innerHTML += ` 
         <div class="card" id="card">
            <div class="card-body">
                <h2>${titulo}</h2>

                <label>Categoria:</label>
                <p>${categoria} </p><br>

                <label >Descripcion:</label>
                <p>${descripcion}</p>

                <a href="collections.html">Ver NFT´s</a>
            </div>
       `
    })
}
window.addEventListener('DOMContentLoaded', getData);