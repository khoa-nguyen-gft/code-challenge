function sequence(num) {

    var result;
    result = Array.from(new Array(num), (val, index)=> index);
    result.push(num);
    console.log(result);
    return result;
}


sequence(13);