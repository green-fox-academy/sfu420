// -  Create (dynamically*) a two dimensional list
//    with the following matrix**. Use a loop!
//
//    0 0 0 1
//    0 0 1 0
//    0 1 0 0
//    1 0 0 0
//
// -  Print this two dimensional list to the console
//
// * size should depend on a variable
// ** Relax, a matrix is just like an array

let size = 4;
// let matrix = new Array(size).fill().map(() => Array(size).fill());      // it creates array and fills with undefined
let matrix = new Array(size).fill().map(() => Array(size).fill(0));      // it creates array and fills with 0

console.log(matrix);

for (let x = 0; x < size; x++) {
    for (let y = 0; y < size; y++) {
        if (y === size - (x + 1)) {
            matrix[x][y] = 1;
        // } else {
        //     matrix[x][y] = 0;
        }
    }
}

console.log(matrix);
