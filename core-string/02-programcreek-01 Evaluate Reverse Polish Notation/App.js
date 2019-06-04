function evalRPN(tokens) {
    var stack = [];
    var result;

    tokens.forEach(token => {
        var operations = '+-*/';
        var operation = operations.indexOf(token);
        
        if (operation == -1) {
            stack.push(token);
        }
        else {
            switch (operation) {
                case 0:
                    stack.push(parseInt(stack.pop()) + parseInt(stack.pop()));
                    break;
                case 1:
                    stack.push(parseInt(stack.pop()) - parseInt(stack.pop()));
                    break;
                case 2:
                    stack.push(parseInt(stack.pop()) * parseInt(stack.pop()));
                    break;
                case 3:
                    stack.push(parseInt(stack.pop()) / parseInt(stack.pop()));
                    break;
            }

        }
    })

    return stack.pop();
}

var tokens = ["2", "1", "+", "3", "*"];
console.log(evalRPN(tokens));