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

let dataCheckbox = ''
document.getElementById("checkboxForm").onclick = function (){
    if(document.getElementById("checkboxForm").checked === true){
        dataCheckbox = true;
    } else {
        dataCheckbox = false;
    }
}

const createNftForm = document.querySelector("form");

let collec =  sessionStorage.getItem("name");

createNftForm.onsubmit = async (e) => {
    e.preventDefault()
    let data = {
        "forSale": dataCheckbox.value,
        "imagepath": imagepath.value,
        "title": document.getElementById("title").value,
        "price": document.getElementById("price").value,
        "email": sessionStorage.getItem("email"),

    };
    let response = await fetch("./api/collections/"+collec+"/arts",{
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(data),
    });

    let message = await response.json();
    alert(message);

    sessionStorage.setItem("forSale", data.forSale);
    sessionStorage.setItem("imagepath", data.imagepath);
    sessionStorage.setItem("title", data.title);
    sessionStorage.setItem("price", data.price);

    window.location.href = "wallet.html";
}