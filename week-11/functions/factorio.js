// -  Create a function called `factorio`
//    that returns it's input's factorial

function factorial(param) {
    let res = 1;
    for (let index = 1; index <= param; index++) {
        res = res * index;
    }
    return res;
}

console.log(factorial(5));