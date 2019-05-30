const firstLast = ([first, second,  ...rest]) => {
    console.log(first);
    console.log(second);
    console.log(rest);

    var result = [first, rest.pop()];
    console.log("result is " + result);
    return result;
}

firstLast([5, 10, 15, 20, 25]);// ➞ [5, 25]

firstLast(["edabit", 13, null, false, true]);// ➞ ["edabit", true]

firstLast([undefined, 4, "6", "hello", null]);// ➞ [undefined, null]