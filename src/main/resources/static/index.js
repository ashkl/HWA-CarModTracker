'use strict';

const output = document.getElementById("output");

const getCars = async () => {
    const res = await axios.get("/cars/all/");
    output.innerHTML = "";
    res.data.forEach(car => renderCar(car));
}

const renderCar = ({ id, make, model, year, colour, trans, fuel, bhp, boughtMileage }) => {
    const column = document.createElement("div");
    column.className = "col-4 mt-3";

    const card = document.createElement("div");
    card.className = "card";
    column.appendChild(card);

    const cardImg = document.createElement("img");
    cardImg.className = "card-img-top";
    cardImg.src = "/img/default_car.jpg";
    cardImg.alt = "Car image.";
    card.append(cardImg);

    const cardBody = document.createElement("div");
    cardBody.className = "card-body";
    card.appendChild(cardBody);

    const makeText = document.createElement("h5");
    makeText.className = "card-title";
    makeText.innerText = `${year} ${make} ${model}`;
    cardBody.appendChild(makeText);

    const bhpText = document.createElement("p");
    bhpText.className = "card-text";
    bhpText.innerText = `${bhp} BHP - ${trans} - ${fuel}`;
    cardBody.appendChild(bhpText);

    output.appendChild(column);
}

getCars();

document.getElementById("newForm").addEventListener("submit", function (event) {
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
