function minMax(arr) {
  var result = [Math.min.apply(null,arr),Math.max.apply(null, arr)];
	console.log(result);
	return result;
}

minMax([-54, -21])
minMax([1, 2, 3, 4, 5]);// ➞ [1, 5]
minMax([2334454, 5]);// ➞ [5, 2334454]
minMax([1]);// ➞ [1, 1]