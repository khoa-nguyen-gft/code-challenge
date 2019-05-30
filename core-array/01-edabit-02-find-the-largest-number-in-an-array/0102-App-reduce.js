findLargestNum = (arr)=>{
    var result = arr.reduce((first, second)=>{
        return (first > second) ? first : second;
    }, Number.MIN_VALUE);
    console.log(result);

}


findLargestNum([4, 5, 1, 3])// ➞ 5

findLargestNum([300, 200, 600, 150])// ➞ 600

findLargestNum([1000, 1001, 857, 1])// ➞ 1001