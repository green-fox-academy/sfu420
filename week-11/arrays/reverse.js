// -  Create a variable named `numbers`
//    with the following content: `[3, 4, 5, 6, 7]`
// -  Reverse the order of the elements in `numbers`
// 	   -  do it with the built in method
//	   -  do it with creating a new temp array and a loop
// -  Print the elements of the reversed `numbers`

let numbers = [3, 4, 5, 6, 7];

// with built in method
console.log(numbers.reverse());
numbers.reverse();


// with loop
let temp = [];
let y = 0;

for (let index = numbers.length; index > 0; index--) {
    temp[y] = numbers[index - 1];
    y++;
}
console.log(temp);