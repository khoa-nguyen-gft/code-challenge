var Repo = require("./TaskRepository");

var Task = function(name){
    this.name = name;
    this.completed = false;
}

Task.prototype.getTask = function(id){
    data = Repo.getTask(id);
    this.name = data.name;
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