var TaskRepo = function(){

    var get = function(id){
        console.log ("Repository: get task by " + id);
        return {
            name: "new task from db "
        }
    }

    var save = function(data){
        console.log ("Repository: save task to DB: " + data.name);
    }

    return {
        get: get,
        save: save
    }
}

module.exports = TaskRepo();



