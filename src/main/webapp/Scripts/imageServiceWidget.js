'use strict';
const createNftForm = document.querySelector("form");

const button = document.querySelector('#imagePath');
const img = document.querySelector('#image')

let widget_cloudinary = cloudinary.createUploadWidget({
    cloudName: 'closedsea',
    uploadPreset: 'upload_closedsea'
}, (err, result) => {
    if (!err && result && result.event === 'success') {
        console.log('imagen subida con exito', result.info);
        img.src = result.info.secure_url;
    }
});

button.addEventListener('click', () => {
    widget_cloudinary.open();
}, false);

createNftForm.onsubmit = async (e) => {
    e.preventDefault()

    let data = {
        "id": document.getElementById("id").value,
        "name": document.getElementById("name").value,
        "forSale": document.getElementById("forSale").value,
        "imagePath": img.src,
        "price": document.getElementById("price").value,
    };

    let response = await fetch("./api/collections/" + data.id + "/arts", {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(data),
    });

    let message = await response.json();
    alert(message);

    if (data.forSale === "No") {
        sessionStorage.setItem(false, data.forSale);
    } else {
        sessionStorage.setItem(true, data.forSale);
    }

    sessionStorage.setItem("name", data.name);
    sessionStorage.setItem("imagePath", data.imagePath);
    sessionStorage.setItem("price", data.price);

    window.location.href = "create-nft-piece.html";
}
