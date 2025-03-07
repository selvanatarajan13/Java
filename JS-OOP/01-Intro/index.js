// // use factory function to create object
// function createCircle(radius) {
//     return {
//         radius,
//         draw: function() {
//             console.log('Draw circle with radius of', radius, 'cm.');

//         }
//     }
// }

// // use constructor function to create object.
// function CircleCreate(radius) {
//     this.circle,
//     this.draw = function() {
//         console.log("Draw circle with radius of", radius, "cm.")
//     }
// }

// const circle = new CircleCreate(3);



// const person = { // this called object literal
//     name: "Mahendran",
//     age: 22,
//     info: function() {
//         return `My name is ${this.name}, I'm ${this.age} years old..`;
//     }
// }

// console.log(person);


// create object using function method
// function createPerson(name, age) {
//     let obj = {};

//     obj.name = name;
//     obj.age = age;

//     obj.info = function() {
//         return `name : ${this.name} and age : ${this.age}..`
//     }

//     return obj;
// }

// const selva = createPerson("Selvanatarajan", 22);
// console.log(selva.info());

// const mani = createPerson("Manikandan", 16);
// console.log(mani.info())


// create object using constructor function
function CreatePerson(name, age) {
    this.name = name;
    this.age = age;

    this.info = function() {
        return `name: ${this.name} and age: ${this.age}..`
    }
}

const mahend = new CreatePerson("Mahendran", 22);
console.log(mahend.info())

// JavaScript factory function
function createCarObj(name, model, engineType) {
    return {
        carName: name,
        carModel: model,
        carEngineType: engineType,

        carInfo: function() {
            return `company: ${this.carName} \n model: ${this.carModel} \n engineType: ${this.carEngineType}..`
        }
    }
}

const skoda = createCarObj("SKODA", 2018, "Hybrid engine - (Petrol and Diseal)");
console.log(skoda.carInfo())


// create object using factory function with shorthand object
function createBikeObj(bikeName, bikeModel, bikePrice) {
    return {
        bikeName,
        bikeModel,
        bikePrice,
        info() {
            return `company: ${this.bikeName}\nmodel: ${this.bikeModel}\nprice: ${this.bikePrice}`
        }
    }
}


const yamaha = createBikeObj("Yamaha", 2018, 115874)
console.log(yamaha.info())


// learn prototype and create own prototype

Object.prototype.capitalize = function (string) {
    return string.charAt(0).toUpperCase() + string.slice(1)
}

function city(cityName) {
    const greet = "vanakkam";
    return {
        cityName,
        greet() {
            return `${this.greet} ${this.city}`
        }
    }
}

const coimbatore = city("coimbatore")
console.log(coimbatore)

const ooty = city("uthagai")
console.log(ooty.capitalize(ooty.cityName))

// create another object using constructor function with prototype

Object.prototype.uppercase = function (data) {
    return data.toUpperCase()
}

function createModel(name, price) {
    this.foodName = name;
    this.foodPrice = price;
}

const pizza = new createModel("Pizza", 120);
console.log(pizza.uppercase(pizza.foodName))