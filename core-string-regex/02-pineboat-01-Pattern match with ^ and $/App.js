// Look for a single numeral from the character set
let pattern = /^[0-9]$/
console.log(pattern.test(42)); // false
console.log(pattern.test(4)); // true