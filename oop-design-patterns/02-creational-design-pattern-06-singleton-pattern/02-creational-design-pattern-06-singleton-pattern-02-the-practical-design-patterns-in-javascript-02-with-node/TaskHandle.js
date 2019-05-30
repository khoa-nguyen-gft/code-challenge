var repo = require("./TaskRepo")

var myRepo = repo();

var TaskHandle = function(){
    return{
        save: function(){
            myRepo.save("hi from task handle");
        }
    }
}

module.exports = TaskHandle;