'use strict';

const output = document.getElementById("output");
const selectCar = document.getElementById("selectCar");
const selectUpdateCar = document.getElementById("selectUpdateCar");
const selectUpdateMod = document.getElementById("selectUpdateMod");
const selectDeleteCar = document.getElementById("selectDeleteCar");
const selectDeleteMod = document.getElementById("selectDeleteMod");

const getCars = async () => {
    const res = await axios.get("/cars/all/");
    output.innerHTML = "";
    res.data.forEach(car => renderPage(car));
}

const renderPage = ({ carId, make, model, year, colour, trans, fuel, bhp, boughtMileage, mods }) => {

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

    const tableResp = document.createElement("div");
    tableResp.className = "table-responsive";
    card.appendChild(tableResp);

    const cardTable = document.createElement("table");
    cardTable.className = "card-table table";
    tableResp.appendChild(cardTable);

    const tHead = document.createElement("thead");
    cardTable.appendChild(tHead);

    const tr = document.createElement("tr");
    tHead.appendChild(tr);

    const thModName = document.createElement("th");
    thModName.innerText = "Name";
    tr.appendChild(thModName);

    const thModDesc = document.createElement("th");
    thModDesc.innerText = "Desc";
    tr.appendChild(thModDesc);

    const thInstallDate = document.createElement("th");
    thInstallDate.innerText = "Install Date";
    tr.appendChild(thInstallDate);

    const thInstallMileage = document.createElement("th");
    thInstallMileage.innerText = "Mileage";
    tr.appendChild(thInstallMileage);

    const thModPrice = document.createElement("th");
    thModPrice.innerText = "Price";
    tr.appendChild(thModPrice);

    const tBody = document.createElement("tbody");
    cardTable.appendChild(tBody);

    mods.forEach((element) => {
        const modOption = document.createElement("option");
        modOption.value = element.modId;
        modOption.innerText = `${year} ${make} ${model} - ${element.modName} ${element.installDate}`;
        selectDeleteMod.appendChild(modOption);

        let updateModOption = modOption.cloneNode(true);
        selectUpdateMod.appendChild(updateModOption);

        const tr2 = document.createElement("tr");
        tBody.appendChild(tr2);

        const tdName = document.createElement("td");
        tdName.innerText = element.modName
        tr2.appendChild(tdName);

        const tdDesc = document.createElement("td");
        tdDesc.innerText = element.modDesc
        tr2.appendChild(tdDesc);

        const tdInstallDate = document.createElement("td");
        tdInstallDate.innerText = element.installDate
        tr2.appendChild(tdInstallDate);

        const tdInstallMileage = document.createElement("td");
        tdInstallMileage.innerText = element.installMileage
        tr2.appendChild(tdInstallMileage);

        const tdPrice = document.createElement("td");
        tdPrice.innerText = element.modPrice
        tr2.appendChild(tdPrice);
    });

    const cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);

    const sum = mods.map(element => element.modPrice).reduce((a, b) => a + b, 0);

    const totalSpent = document.createElement("h5");
    totalSpent.innerText = `Total Spent: £${sum}`;
    cardFooter.appendChild(totalSpent);

    output.appendChild(column);

    const carOption = document.createElement("option");
    carOption.value = carId;
    carOption.innerText = `${year} ${make} ${model}`;
    selectCar.appendChild(carOption);

    let updateCarOption = carOption.cloneNode(true);
    selectUpdateCar.appendChild(updateCarOption);

    let deleteCarOption = carOption.cloneNode(true);
    selectDeleteCar.appendChild(deleteCarOption);
}

getCars();

document.getElementById("newCar").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        make: this.addMake.value,
        model: this.addModel.value,
        year: this.addYear.value,
        colour: this.addColour.value,
        trans: this.addTrans.value,
        fuel: this.addFuel.value,
        bhp: this.addBhp.value,
        boughtMileage: this.addBoughtMileage.value
    }

    axios.post("/cars/create", data)
        .then(res => {
            getCars();
            this.addMake.focus();
            location.reload();
        }).catch(err => console.log(err));
    console.log(this);
});

document.getElementById("updateCar").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        make: this.updateMake.value,
        model: this.updateModel.value,
        year: this.updateYear.value,
        colour: this.updateColour.value,
        trans: this.updateTrans.value,
        fuel: this.updateFuel.value,
        bhp: this.updateBhp.value,
        boughtMileage: this.updateBoughtMileage.value,
    }

    axios.put(`/cars/update/${this.selectUpdateCar.value}`, data)
        .then(res => {
            location.reload();
            getCars();
            this.make.focus();
        }).catch(err => console.log(err));
    console.log(this);
});

document.getElementById("deleteCar").addEventListener("submit", function (event) {
    event.preventDefault();

    axios.delete(`/cars/remove/${this.selectDeleteCar.value}`)
        .then(res => {
            getCars();
            location.reload();
        }).catch(err => console.log(err));
    console.log(this);

});


document.getElementById("newMod").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        modName: this.addModName.value,
        modDesc: this.addModDesc.value,
        installDate: this.addInstallDate.value,
        installMileage: this.addInstallMileage.value,
        modPrice: this.addModPrice.value,
        car: this.selectCar.value
    }

    axios.post("/mods/create", data)
        .then(res => {
            getCars();
            location.reload();
        }).catch(err => console.log(err));
    console.log(this);
});

document.getElementById("updateMod").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        modName: this.updateModName.value,
        modDesc: this.updateModDesc.value,
        installDate: this.updateInstallDate.value,
        installMileage: this.updateInstallMileage.value,
        modPrice: this.updateModPrice.value,
    }

    axios.put(`/mods/update/${this.selectUpdateMod.value}`, data)
        .then(res => {
            getCars();
            location.reload();
        }).catch(err => console.log(err));
    console.log(this);
});

document.getElementById("deleteMod").addEventListener("submit", function (event) {
    event.preventDefault();

    axios.delete(`/mods/remove/${this.selectDeleteMod.value}`)
        .then(res => {
            getCars();
            location.reload();
        }).catch(err => console.log(err));
    console.log(this);
});