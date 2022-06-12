'use strict'

const button = document.getElementById("imagebutton");
let imagepath = '';
let widget_cloudinary = cloudinary.createUploadWidget({
    cloudName: 'closedsea',
    uploadPreset: 'upload_closedsea'
}, (err,result) =>{
    if(!err && result & result.event === 'success'){
        console.log('imagen subida con exito', result.info);
        imagepath.src = result.info.secure_url;
    }
});

button.addEventListener('click', ()=> {
    widget_cloudinary.open();
}, false);

/*let dataCheckbox = ''
document.getElementById("checkboxForm").onclick = function (){
    if(document.getElementById("checkboxForm").checked === true){
        dataCheckbox = true;
    } else {
        dataCheckbox = false;
    }
}*/

const createNftForm = document.querySelector("form");

createNftForm.onsubmit = async (e) => {
    e.preventDefault()
    let data = {
        "id": document.getElementById("id").value,
        "art": document.getElementById("art").value,
        "forSale": document.getElementById("forSale").value,
        //"imagepath": document.getElementById("imagepath").value,
        "imagepath": imagepath.src,
        "price": document.getElementById("price").value,
    };

    let response = await fetch("./api/collections/"+data.id+"/arts",{
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(data),
    });

    let message = await response.json();
    alert(message);

    if(data.forSale ===  "No")
    {
        sessionStorage.setItem(false, data.forSale);
    }else{
        sessionStorage.setItem(false, data.forSale);
    }
    sessionStorage.setItem("art", data.art);
    sessionStorage.setItem("imagepath", data.imagepath);
    sessionStorage.setItem("price", data.price);

    window.location.href = "create-nft-piece.html";
}
