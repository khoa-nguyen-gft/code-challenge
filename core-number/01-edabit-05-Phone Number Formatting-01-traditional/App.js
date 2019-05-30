formatPhoneNumber([1, 2, 3, 4, 5, 6, 7, 8, 9, 0]);// ➞ "(123) 456-7890"

formatPhoneNumber([5, 1, 9, 5, 5, 5, 4, 4, 6, 8]);//  ➞ "(519) 555-4468"

formatPhoneNumber([3, 4, 5, 5, 0, 1, 2, 5, 2, 7]);//  ➞ "(345) 501-2527"


function formatPhoneNumber(numbers) {
	console.log(numbers);
	var result = '('+ numbers.slice(0, 3).join('') + ') '
	+ numbers.slice(3,6).join('') + '-' 
	+ numbers.slice(6,11).join('');
	console.log(result);
	return result;
}