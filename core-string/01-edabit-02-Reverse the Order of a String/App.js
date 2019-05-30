function reverse(str) {
    var result;

    result = str.split('').reverse().join('');
    console.log(result);

    return result;
    
}


reverse("Hello World")// ➞ "dlroW olleH"

reverse("The quick brown fox.")// ➞ ".xof nworb kciuq ehT"

reverse("Edabit is really helpful!")// ➞ "!lufpleh yllaer si tibadE"