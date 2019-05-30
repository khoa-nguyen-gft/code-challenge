function nameShuffle(str) {
    var result;
    result = str.split(' ').reverse().join(' ');
    console.log(result);

    return result;
    
}


nameShuffle("Donald Trump")// ➞ "Trump Donald"

nameShuffle("Rosie O'Donnell")// ➞ "O'Donnell Rosie"

nameShuffle("Seymour Butts")// ➞ "Butts Seymour"