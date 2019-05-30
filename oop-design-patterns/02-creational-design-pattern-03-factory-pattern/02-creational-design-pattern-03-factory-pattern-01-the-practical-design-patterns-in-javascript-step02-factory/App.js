var Task = require('./Task');
var factoryRepo = require('./repoFactory');


var task01 = new Task(factoryRepo.getRepo('task').get(1));
var task02 = new Task(factoryRepo.getRepo('task').get(2));

task01.user = factoryRepo.getRepo('user').get(1);
task01.project = factoryRepo.getRepo('project').get(1);

console.log(task01);
console.log(task02);

task01.save();
