function sequence(num) {

    var result;
    // returns an N-element array filled with undefined (i.e. A = [undefined, undefined, ...]).
    result = Array.apply(null, {length: num});
    //The second goes over that array and takes its indices, resulting in an array of element indices:
    // A.map(Function.call, Number) returns an N-element array, whose index I gets the result of Function.call.call(Number, undefined, I, A)
    // Function.call.call(Number, undefined, I, A) collapses into Number(I), which is naturally I.
    // Result: [0, 1, ..., N-1].
    result = result.map(Function.call, Number);
    result.push(num);
    console.log(result);
    return result;
}


sequence(13);