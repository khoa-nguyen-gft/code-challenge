findLargestNum = (arr)=>{
    console.log(arr);
    console.log(... arr);

    //will not work, because max doesn't accept an array as input.
    //var result = Math.max(arr);


    var result = Math.max(... arr);
    console.log(result);
    return result;

}


findLargestNum([4, 5, 1, 3])// ➞ 5

findLargestNum([300, 200, 600, 150])// ➞ 600

findLargestNum([1000, 1001, 857, 1])// ➞ 1001