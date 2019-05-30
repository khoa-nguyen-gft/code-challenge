verifySubstrs("Onomatopeia", "on", "mato", "ia");// ➞ "Incomplete."

verifySubstrs("Centtippede", "Cent", "tip", "pede");// ➞ "My head, body, and tail."

verifySubstrs("apple", "AP", "PPL", "LE");// ➞ "Incomplete."


function verifySubstrs(mainStr, head, body, tail) {
    var str = [head, body, tail].join("");
    console.log(str);
    if (mainStr.toUpperCase() === str.toUpperCase()){
        console.log("My head, body, and tail.");
		return "My head, body, and tail.";

    }
    
	return "Incomplete.";
}