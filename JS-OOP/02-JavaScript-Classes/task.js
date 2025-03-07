// create learner object using three different class

// create object using name class
class Learner {
    constructor(name, age) {
        this.studentName = name
        this.studentAge = age
    }

    info() {
        return `StudentName: ${this.studentName}\nStudentAge: ${this.studentAge}`
    }
}

const student1 = new Learner("Mahendran", 22, "Online mode")
console.log(student1.info())

// create object using class expression

const Learner1 = class Learner11 extends Learner {
    constructor(name, age, course) {
        super(name, age)
        this.courseName = course
    }

    info() {
        return super.info() + `\ncourseName: ${this.courseName}` 
    }
}

const student2 = new Learner1("Selvanatarajan", 22, "JavaScript")
console.log(student2.info())

// create object using anonymous class

const Learner2 = class extends Learner1 {
    constructor(name, age, course, mode) {
        super(name, age, course)
        this.mode = mode
    }

    info() {
        return super.info() + `\nLearning mode: ${this.mode}`
    }
}

const student3 = new Learner2("Karthikka", 21, "Java", "Online")
console.log(student3.info())