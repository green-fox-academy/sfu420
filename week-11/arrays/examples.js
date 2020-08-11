const evens = [2, 4, 6, 8];
const numbers = [1, 3, 5, 7, ...evens];
console.log(numbers); // expected output: [1, 3, 5, 7, 2, 4, 6, 8]


// concatenating two arrays
let arr1 = [0, 1, 2];
let arr2 = [3, 4, 5];

arr1 = [...arr1, ...arr2];
console.log(arr1);
// [ 0, 1, 2, 3, 4, 5 ]


console.log(['apple', 'pear', 'melon'].indexOf('pear'));
// 1


['apple', 'pear', 'melon'].forEach(function (e, i) {
    console.log(e, i);
});
// apple 0
// pear 1
// melon 2


let triples = [1, 2, 3, 4, 5].map(function (e) {
    return e * 3;
});
console.log(triples);
// [ 3, 6, 9, 12, 15 ]


let evens2 = [1, 2, 3, 4, 5].filter(function (e) {
    return e % 2 == 0;
});
console.log(evens2);
// [ 2, 4 ]


let isAllEven = [2, 6, 14, 5, 4].every(function (e) {
    return e % 2 == 0;
});
console.log(isAllEven);
// false


let isAnyEven = [2, 6, 14, 5, 4].some(function (e) {
    return e % 2 == 0;
});
console.log(isAnyEven);
// true


let letters = 'apple'.split('');
console.log(letters);
console.log(letters.join('@'));
// [ 'a', 'p', 'p', 'l', 'e' ]
// a@p@p@l@e