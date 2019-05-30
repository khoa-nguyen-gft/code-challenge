var Task = require('./Task');

var task01 = new Task('create demo for constructors');
var task02 = new Task('create demo for modules');
var task03 = new Task('create demo for singletons');
var task04 = new Task('create demo for prototype');

task01.completedTask();
task02.save();
task03.save();
task04.save();