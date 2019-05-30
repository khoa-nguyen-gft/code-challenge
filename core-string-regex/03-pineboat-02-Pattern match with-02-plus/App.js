//It can match one or more occurrences of preceeding pattern.
console.log("pattern: /a+/");



console.log(/a+/.test('a')); // true
console.log(/a+/.test('aa')); // true
console.log(/a+/.test('aaa')); // true
console.log(/a+/.test('ab')); // true
console.log(/a+/.test('ba')); // true

console.log(/a+/.test('')); // false
console.log(/a+/.test('b')); // false

//looks for a start to end, no other characters allowed.
console.log("pattern: /^a+$/");

console.log(/^a+$/.test('a')); // true
console.log(/^a+$/.test('aa')); // true
console.log(/^a+$/.test('aaa')); // true

console.log(/^a+$/.test('ab')); // false
console.log(/^a+$/.test('ba')); // false
console.log(/^a+$/.test('')); // false
console.log(/^a+$/.test('b')); // false

