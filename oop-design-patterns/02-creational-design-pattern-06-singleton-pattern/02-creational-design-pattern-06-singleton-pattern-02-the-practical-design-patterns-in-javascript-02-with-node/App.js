var taskHandle = require("./TaskHandle");
var taskRepo = require("./TaskRepo");

var myRepo = taskRepo();
var mytaskHandle = taskHandle();

myRepo.save("from App");
mytaskHandle.save();
mytaskHandle.save();
mytaskHandle.save();
