function doubleChar(str) {
    var result = str.split("")
    .map(s => s+s)
    .reduce((a,b)=> a+b);

    
    result = str.split("")
    .map(s => s+s)
    .join``;


    // '/g' will mean that all of the matching values are replaced
    result = str.replace(/./g, '$&$&');
    console.log(result);
    return result;
}

doubleChar("String");// ➞ "SSttrriinngg"

doubleChar("Hello World!");// ➞ "HHeelllloo  WWoorrlldd!!"

doubleChar("1234!_ ");// ➞ "11223344!!__  "