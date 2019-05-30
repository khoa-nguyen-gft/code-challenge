findLargestNum = (arr)=>{
    // `apply` is a convenient way to pass an array of data as parameters to a function.
    //`The first parameter = Math`, you pass to apply of any function
    // But,`max` doesn't depend on the current context. 
    var result = Math.max.apply(Math,arr);
    console.log(result);
    return result;

}


findLargestNum([4, 5, 1, 3])// ➞ 5

findLargestNum([300, 200, 600, 150])// ➞ 600

findLargestNum([1000, 1001, 857, 1])// ➞ 1001