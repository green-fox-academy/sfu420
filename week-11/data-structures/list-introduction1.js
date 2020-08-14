let list = [];

console.log(list.length);
list.push('William');
console.log('isEmpty: ' + (Array.isArray(list) && !list.length));
list.push('John');
list.push('Amanda');
console.log(list.length);
console.log(list[2]);

list.forEach(element => console.log(element));

list.forEach((e, i) => console.log(i + 1 + '. ' + e));

delete list[1];

list.reverse().forEach(element => console.log(element));