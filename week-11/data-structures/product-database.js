let products = {
    Eggs: 200,
    Milk: 200,
    Fish: 400,
    Apples: 150,
    Bread: 50,
    Chicken: 550,
};

console.log('Fish costs: ' + products.Fish);

let sum = 0;
Object.values(products).forEach(e => sum += e);
console.log('Average price: ' + sum / Object.values(products).length);

let below300 = Object.values(products).filter(e => e < 300).length;
console.log('Below 300: ' + below300);

let isExactly125 = Object.values(products).filter(e => e === 125).length;
console.log('Anything for 125: ' + !!isExactly125);

let cheapest = Object.entries(products).sort((a, b) => a[1] - b[1]);
console.log('Cheapest product is: ' + cheapest[0]);