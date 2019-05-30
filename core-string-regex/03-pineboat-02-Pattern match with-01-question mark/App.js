console.log("pattern: /a?/");

console.log(/a?/.test("")); //true
console.log(/a?/.test("a"));//true
console.log(/a?/.test("aa"));//true
console.log(/a?/.test("aaa"));//true
console.log(/a?/.test("b"));//true
console.log(/a?/.test("ab"));//true

console.log("pattern: /^a?$/");
console.log(/^a?$/.test("")); // true
console.log(/^a?$/.test("a")); // true

console.log(/^a?$/.test("aa")); // false
console.log(/^a?$/.test("aaa")); // false
console.log(/^a?$/.test("b")); // false
console.log(/^a?$/.test("ab")); // false