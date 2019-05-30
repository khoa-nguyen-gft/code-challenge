function sequence(num) {

    var result;
    result = Array.from(Array(num).keys());
    console.log(result);
    return result;
}


sequence(13);