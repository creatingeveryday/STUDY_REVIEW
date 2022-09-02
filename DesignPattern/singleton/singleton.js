const objA = { name: "aa" };
const objB = { name: "aa" };
console.log(objA === objB);

class Singleton {
    constructor() {
        if (!Singleton.instance) {
            Singleton.instance = this
        }
        return Singleton.instance
    }

    getInstance() {
        return this.instance
    }
}

const obj1 = new Singleton();
const obj2 = new Singleton();
console.log(obj1 === obj2);