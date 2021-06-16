'use strict';

const output = document.getElementById("output");
const selectCar = document.getElementById("selectCar");

const getCars = async () => {
    const res = await axios.get("/cars/all/");
    output.innerHTML = "";
    res.data.forEach(car => renderCar(car));
}

const renderCar = ({ carId, make, model, year, colour, trans, fuel, bhp, boughtMileage }) => {

    const column = document.createElement("div");
    column.className = "col-4 mt-3";

    const card = document.createElement("div");
    card.className = "card";
    column.appendChild(card);

    const cardImg = document.createElement("img");
    cardImg.className = "card-img-top";
    cardImg.src = "/img/default_car.jpg";
    cardImg.alt = "Car image.";
    card.appendChild(cardImg);

    const cardBody = document.createElement("div");
    cardBody.className = "card-body";
    card.appendChild(cardBody);

    const makeText = document.createElement("h4");
    makeText.className = "card-title";
    makeText.innerText = `${year} ${make} ${model}`;
    cardBody.appendChild(makeText);

    const bhpText = document.createElement("h6");
    bhpText.className = "card-text";
    bhpText.innerText = `${bhp} BHP - ${trans} - ${fuel}`;
    cardBody.appendChild(bhpText);

    const extraText = document.createElement("p");
    extraText.className = "card-text";
    extraText.innerText = `${colour} - ${boughtMileage} Miles when bought.`;
    cardBody.appendChild(extraText);

    output.appendChild(column);

    const carOption = document.createElement("option");
    carOption.value = carId;
    carOption.innerText = `${year} ${make} ${model}`;

    selectCar.appendChild(carOption);
}

getCars();

document.getElementById("newCar").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        make: this.make.value,
        model: this.model.value,
        year: this.year.value,
        colour: this.colour.value,
        trans: this.trans.value,
        fuel: this.fuel.value,
        bhp: this.bhp.value,
        boughtMileage: this.boughtMileage.value
    }

    axios.post("/cars/create", data)
        .then(res => {
            getCars();
            this.make.focus();
        }).catch(err => console.log(err));
    console.log(this);
});


document.getElementById("newMod").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        modName: this.modName.value,
        modDesc: this.modDesc.value,
        installDate: this.installDate.value,
        installMileage: this.installMileage.value,
        modPrice: this.modPrice.value,
        car: this.selectCar.value
    }

    axios.post("/mods/create", data)
        .catch(err => console.log(err));
    console.log(this);
});