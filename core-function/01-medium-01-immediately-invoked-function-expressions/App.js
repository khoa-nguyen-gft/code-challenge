//The natural function definition
function sayHi() {
    console.log("hi");
}

sayHi();


//the IIFE function
//All that the first character, “!”, is doing here is to make that function into an expression
// instead of a function statement/definition. And then we execute that function immediately.
!function(){
    console.log("IIFE");
}();

//Again void is basically forcing the function to be treated as an expression.
//All the above patterns are useful when we are not interested in the return value from the IIFE.
void function(){
    console.log("void in IIFE");
}();


//But then what if you wanted a return value from the IIFE and you want to use that return 
//value elsewhere? Read on to know the answer!

//Classical IIFE style
(function(){
    console.log("I am not an IIFE yet!");
});

(function(){
    console.log("I am an IIFE!");
}());

(function(){
    console.log("I am an IIFE, too!");
})();

//IIFEs and private variables
//One thing that IIFEs are really good at is to do with their ability to create
//a function scope for the IIFE.
(function IIFE_initGame_inside(){
    // Private variables that no one has access to outside this IIFE
    var lives;
    var weapons;

    init();

    // Private function that no one has access to outside this IIFE
    function init(){
        console.log("Private function that no one has access to outside this IIFE");
        lives = 5;
        weapons = 10;
    }

})();


//IIFEs with parameters
//Not only IIFEs can return values, but IIFEs can also take arguments while they are invoked.
// Let’s see a quick example.
(function(msg, times){
    for(var i = 0; i <= times; i++){
        console.log(msg + i);
    }
})("message", 2);







