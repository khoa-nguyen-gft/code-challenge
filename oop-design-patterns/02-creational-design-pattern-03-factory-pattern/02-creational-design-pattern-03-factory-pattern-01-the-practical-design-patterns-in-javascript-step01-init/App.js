var Task = require('./Task');
var taskRepo = require('./TaskRepository');
var userRepo = require('./UserRepository');
var projectRepo = require('./ProjectRepository');


var task01 = new Task(taskRepo.getTask(1));
task01.user = userRepo.get(1);
task01.project = projectRepo.get(1);

console.log(task01);
task01.save();
