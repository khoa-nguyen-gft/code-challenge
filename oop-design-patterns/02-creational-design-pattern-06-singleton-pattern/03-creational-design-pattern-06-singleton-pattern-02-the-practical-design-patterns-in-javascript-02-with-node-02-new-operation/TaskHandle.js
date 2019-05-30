var myRepo = require("./TaskRepo")

//var myRepo = repo();

var TaskHandle = function(){
    return{
        save: function(){
            myRepo.save("hi from task handle");
        }
    }
}

module.exports = new TaskHandle;
//OR
//module.exports = TaskHandle();