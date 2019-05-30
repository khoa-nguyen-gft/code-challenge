function findDigitAmount(num) {
	return num.toString().length;
}

console.log(findDigitAmount(123))// ➞ 3
console.log(findDigitAmount(56))// ➞ 2
console.log(findDigitAmount(7154))// ➞ 4
console.log(findDigitAmount(61217311514))// ➞ 11
console.log(findDigitAmount(0))// ➞ 1