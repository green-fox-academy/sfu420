// -  Create a function called `printParams`
//    which logs to the console the input parameters
//    (can have multiple number of arguments)

function printParams(params) {
    return console.log(arguments);
}

printParams(5, 'Fox', true);