class Person{
    constructor(name, age) {
        this.personName = name
        this.personAge = age
    }

    greet() {
        return `Hello ${this.personName}`
    }

    getPersonName() {
        return this.personName;
    }
}

class Officer extends Person{
    constructor(name, age, dept) {
        super(name, age)
        this.officerDept = dept
    }

    info() {
        return `Hello my name is ${this.personName}, I'm working in ${this.officerDept}..`
    }
}


const mahend = new Person("Mahendran", 22);
console.log(mahend.greet())
const selva = new Person("Selva", 22)
selva.personName = "Selvanatarajan"
console.log(selva.getPersonName())

const michel = new Officer("Richard Michel", 42, "Medical Department")
console.log(michel.info())

// create class using class expression
const state = class State1 {
    constructor(name) {
        this.stateName = name
    }
}

const kerla = new state("Kerla")
console.log(kerla)

// create object using anonymous class
const country = class {
    constructor(name) {
        this.countryName = name
    }
}

const india = new country("India")
console.log(india)


// ------------------------------------------------------------------------------------------------------------




class Car {
    #carName;
    #carColor;
    #carYear;
    #carEngineType;

    constructor(name, color, year, engineType) {
        this.#carName = name
        this.#carColor = color
        this.#carYear = year
        this.#carEngineType = engineType
    }

    get year() {
        return this.#carYear;
    }

    getCarName() {
        return this.#carName;
    }

    get carName() {
        return this.#carName;
    }

    setCarName(data) {
        this.#carName = data
    }

    set engineType(value) {
        this.#carEngineType = value 
    }

    get engineType() {
        return this.#carEngineType;
    }
}


const nissan = new Car("Nissan", "Black", 2020, "Petrol")
console.log(nissan.getCarName())
nissan.setCarName("Mahindra")
console.log(nissan.getCarName())
console.log(nissan.year)
console.log(nissan.carName)
console.log(nissan.engineType)
nissan.engineType = "diseal";
console.log(nissan.engineType)