var TaskRepo = (function(){
    var taskRepo;
    function createRepo(){
        var taskRepo = new Object("Task");
        return taskRepo;
    }

    return {
        getInstance: function(){
            if (!taskRepo){
                console.log("init instance");
                taskRepo = createRepo();
                return taskRepo;
            }
            console.log("retreive instance");
            return taskRepo;
        }
    };
})();

var repo1 = TaskRepo.getInstance();
var repo2 = TaskRepo.getInstance();

if (repo1 === repo2){
    console.log("same instance");
}