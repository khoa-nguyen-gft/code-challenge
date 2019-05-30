function MultiplyByLength(arr) {
    var result = arr.map(x => x * arr.length);
    console.log(result);
	return result;
}

MultiplyByLength([2, 3, 1, 0]) //➞ [8, 12, 4, 0]
