'use strict'

const button = document.getElementById("imagebutton");
let imagepath = '';
let widget_cloudinary = cloudinary.createUploadWidget({
    cloudName: 'closedsea',
    uploadPresets: 'upload_closedsea'
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
getCheckbox.onclick = function (){
    if(document.getElementById("checkboxForm").checked === true){
        dataCheckbox = true;
    } else {
        dataCheckbox = false;
    }
}

const createNftForm = document.querySelector("form");

createNftForm.onsubmit = async (e) => {
    e.preventDefault()
    let data = {
        "forSale": dataCheckbox.value,
        "imagepath": imagepath.value,
        "name": document.getElementById("name").value,
        "price": document.getElementById("price").value,
    };

    let response = await fetch("./api/users/")
}