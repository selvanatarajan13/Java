class Todo {
    constructor() {
        this.tasks = []
    }

    setTask(task) {
        this.tasks.push(task)
    }

    getTask() {
        let taskList = '';
        for (let index = 0; index < this.tasks.length; index++) {
            let element = this.tasks[index];
            taskList += `${element.getTask()}\n`
        }
        return taskList;
    }

    getLength() {
        return this.tasks.length
    }
}

class task {
    #task;
    constructor(task) {
        this.#task = task;
    }

    getTask() {
        return this.#task;
    }
}

const tasks = new Todo();

tasks.setTask(new task("Complete HW by this evening.."))
tasks.setTask(new task("Tomorrow will should go to market"))

console.log(tasks.getTask())
console.log(tasks.getLength())

const formData = document.querySelector('form');

formData.addEventListener('submit', (e) => {
    e.preventDefault();
    const listTask = document.getElementById('task')
    console.log(listTask.value)
    document.getElementById('value').innerHTML += listTask.value;
})