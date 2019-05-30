removeDups(["John", "Taylor", "John"])// ➞ ["John", "Taylor"]

removeDups([1, 0, 1, 0])// ➞ [1, 0]

removeDups(['The', 'big', 'cat'])// ➞ ['The', 'big', 'cat']

function removeDups(arr) {
    var result = [...new Set(arr)];
    console.log(result);
    return result;
  }