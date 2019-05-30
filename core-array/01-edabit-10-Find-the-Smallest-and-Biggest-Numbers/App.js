function minMax(arr) {
	var bigger = -Number.MAX_VALUE;
	var smaller = Number.MAX_VALUE;
	for (var i = 0; i < arr.length; i ++){
		if (arr[i] > bigger){
			bigger = arr[i];
		}
		
		if (arr[i] < smaller){
			smaller = arr[i];
		}
    }
    var result = [smaller, bigger];
	console.log(result);
	return result;
}

minMax([-54, -21])
minMax([1, 2, 3, 4, 5]);// ➞ [1, 5]
minMax([2334454, 5]);// ➞ [5, 2334454]
minMax([1]);// ➞ [1, 1]