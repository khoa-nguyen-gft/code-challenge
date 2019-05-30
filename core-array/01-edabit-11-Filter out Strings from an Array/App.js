function filterArray(arr) {
    //console.log(arr);
    var result =   arr.filter(n => typeof n === 'number');
	console.log(result);
	return result;
}

filterArray([1, 2, "a", "b"]);// ➞ [1, 2]

filterArray([1, "a", "b", 0, 15]);// ➞ [1, 0, 15]

filterArray([1, 2, "aasf", "1", "123", 123]);//➞ [1, 2, 123]