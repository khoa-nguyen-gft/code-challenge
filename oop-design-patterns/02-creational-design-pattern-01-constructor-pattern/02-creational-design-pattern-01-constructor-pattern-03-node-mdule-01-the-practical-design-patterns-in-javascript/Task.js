var Task = function(name){
    this.name = name;
    this.completed = false;
}

Task.prototype.completedTask = function(){
    console.log("completed task: " + this.name);
    this.completed = true;
}

Task.prototype.save = function(){
    console.log('save: ' + this.name);
}

module.exports = Task;