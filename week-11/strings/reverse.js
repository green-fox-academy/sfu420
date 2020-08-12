'use strict';
// Create a function that can reverse a string, which is passed as the parameter
// Use it on this reversed string to check it!

let toBeReversed = `.eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI`;

function reverse(param) {
    let res = '';
  
    for (let index = param.length; index >= 0 ; index--) {
        res = res + param.charAt(index);
    }
    return res;
}

console.log(reverse(toBeReversed));
