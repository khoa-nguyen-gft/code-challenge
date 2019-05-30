var Sequence = (function(){
    // Private variable to store current counter value.
    var current = 0;


    // Object that's returned from the IIFE.
    return {
        getCurrentValue: function(){
            return current;
        },

        getNextValue: function(){
            current = current + 1;
            return current;
        }
    };

})();

console.log(typeof Sequence);
console.log(Sequence.getNextValue());
console.log(Sequence.getNextValue());
console.log(Sequence.getCurrentValue());