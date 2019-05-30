
const firstLast = (arr) => {
    var result = [arr.shift(), arr.pop()];
    console.log(result);
    return result;
}
firstLast([5, 10, 15, 20, 25]);// ➞ [5, 25]

firstLast(["edabit", 13, null, false, true]);// ➞ ["edabit", true]

firstLast([undefined, 4, "6", "hello", null]);// ➞ [undefined, null]