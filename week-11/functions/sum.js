// Write a function called `sum` that returns the sum of numbers from zero to the given parameter

function sum(param) {
    let sum = 0;
    for (let index = 1; index <= param; index++) {
        sum = sum + index;
    }
    return sum;
}

console.log(sum(5));