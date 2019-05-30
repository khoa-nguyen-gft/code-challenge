function charCount(myChar, str) {
	//var result = str.split("")
	var result = [...str]
	.filter(s=> myChar === s);
	console.log(result.length);
	return result;
}

charCount("a", "edabit")// ➞ 1

charCount("c", "Chamber of secrets")// ➞ 1

charCount("f", "frank and his friends have offered five foxes for sale")// ➞ 7