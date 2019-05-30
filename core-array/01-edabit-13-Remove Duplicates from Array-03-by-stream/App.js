removeDups(["John", "Taylor", "John"])// ➞ ["John", "Taylor"]

removeDups([1, 0, 1, 0])// ➞ [1, 0]

removeDups(['The', 'big', 'cat'])// ➞ ['The', 'big', 'cat']

function removeDups(arr) {
    var result = arr.filter((x, i, a) => a.indexOf(x) === i)
    console.log(result);
    return result;
  }