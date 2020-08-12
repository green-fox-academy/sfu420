// -  Create an array named `numbers` with the following content: `[1, 2, 3, 8, 5, 6]`
// -  Change the 8 to 4 with the `.map` method 
// -  Print the fourth element as a test

let numbers = [1, 2, 3, 8, 5, 6];

numbers = numbers.map(function (element, index) {
    return index + 1;
});

console.log(numbers[3]);