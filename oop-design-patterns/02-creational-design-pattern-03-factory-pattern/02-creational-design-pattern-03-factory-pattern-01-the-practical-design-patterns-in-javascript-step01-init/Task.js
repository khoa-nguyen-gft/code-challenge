var Repo = require("./TaskRepository");

var Task = function(data){
    this.name = data.name;
    this.completed = false;
}

Task.prototype.completedTask = function(){
    console.log('Service: completed task: ' + this.name);
    this.completed = true;
}

Task.prototype.save = function(){
    console.log('Service: save task: ' + this.name);
    Repo.saveTask(this);
}

module.exports = Task;