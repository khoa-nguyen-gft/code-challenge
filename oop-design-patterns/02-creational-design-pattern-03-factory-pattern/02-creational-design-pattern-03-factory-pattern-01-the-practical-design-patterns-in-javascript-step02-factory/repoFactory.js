var repoFactory = function(){


    this.getRepo = function(repoType){
        if (repoType == 'task') {
            if(this.taskRepo){
                console.log('retrive the task repository');
                return this.taskRepo;
            } else {
                this.taskRepo = require('./TaskRepository');
                return this.taskRepo;
            }
        }
        else if (repoType == 'user'){
            var userRepo = require('./UserRepository');
            return userRepo;

        } else if (repoType == 'project'){
            var productRepo = require('./ProjectRepository');
            return productRepo;
        }
    }
};

module.exports = new repoFactory;


