// -  Create a variable named `numbers` with the following content:
//   `[3, 4, 5, 6, 7]`
// -  Log the sum of the elements in `numbers` to the console

let numbers = [3, 4, 5, 6, 7];
let sum = 0;

numbers.forEach(element => {
    sum = sum + element;
});

console.log(sum);