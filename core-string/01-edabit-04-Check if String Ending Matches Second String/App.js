function checkEnding(str1, str2) {
    var str11 = str1.substring(str1.length - str2.length);
    console.log(str11);
    //console.log(str1);

	return (str11 == str2);
}


checkEnding("abc", "bc");// ➞ true

checkEnding("abc", "d" );//➞ false

checkEnding("samurai", "zi" );//➞ false

checkEnding("feminine", "nine");// ➞ true

checkEnding("convention", "tio" );//➞ false