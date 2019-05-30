findLargestNum = (arr)=>{
    var max = arr[0];
    for (i = 0; i < arr.length; i ++){
        max = (max > arr[i]) ? max : arr[i]; 
    }
    console.log(max);
    return max;
}



findLargestNum([4, 5, 1, 3])// ➞ 5

findLargestNum([300, 200, 600, 150])// ➞ 600

findLargestNum([1000, 1001, 857, 1])// ➞ 1001