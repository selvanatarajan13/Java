// #- this special character refer to private
// _- this special character refer to protected
// without defining those special character refer to as public

// To hide the complex implementation detail of a class and expose only the nescessary part of the class to the outside is
// called abstraction.

class Student {
    #studentName;
    #studentAge;

    constructor(name, age) {
        this.#studentName = name
        this.#studentAge = age
    }

    info() {
        return `StudentName: ${this.#studentName}\nStudentAge: ${this.#studentAge}`
    }
}

class SchoolStudent extends Student {
    #standard;

    constructor(name, age, std) {
        super(name, age)
        this.#standard = std
    }

    info() {
        // using polymorphism technique to reduce the redudent code
        return super.info() + `\nStandard: ${this.#standard}`
    }
}

class CollegeStudent extends Student {
    #Department;
    #Year;
    constructor(name,age,dept,year) {
        super(name, age)
        this.#Department = dept
        this.#Year = year
    }

    info() {
        return super.info() + `\nDepartment: ${this.#Department}\nYearOfStudying: ${this.#Year}`
    }
}


const mahendran = new SchoolStudent("Mahendran", 18, "12th")
console.log(mahendran.info())

const selva = new CollegeStudent("Selvanatarajan", 22, "ECE", "Passed Out")
console.log(selva.info())