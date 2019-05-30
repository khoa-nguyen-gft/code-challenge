function countVowels(str) {
    var result = [...str].filter(e => ['a', 'e', 'i', 'o', 'u'].includes(e));
    console.log(result);
    return result.length;
    
}


function countVowelsPattern(str){
    // JavaScript RegExp Reference
    // Syntax:    /pattern/modifiers;

        //'g'   Perform a global match (find all matches rather than stopping after the first match)
        //'i'	Perform case-insensitive matching
    var result = str.match(/[aeiou]/gi);
    console.log(result);
    return result.length;
}

countVowelsPattern("CelEbration");// ➞ 5

countVowelsPattern("Palm");// ➞ 1

countVowelsPattern("Prediction");// ➞ 4