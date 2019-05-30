function addUp(num) {
    var result ;
    result = Array.from(Array(num), (val, index) => index + 1);
    result = result.reduce((first, second)=> first+second);
    console.log(result);
    return result;
}

addUp(4);// ➞ 10

addUp(13);// ➞ 91

addUp(600);// ➞ 180300