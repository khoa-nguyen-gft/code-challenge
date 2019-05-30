var Repo = function(){

    var getTask = function(id){
        console.log ("Repository: get task by " + id);
        return {
            name: "name of " + id
        }
    }

    var saveTask = function(data){
        console.log ("Repository: save task to DB: " + data.name);
    }

    return {
        getTask: getTask,
        saveTask: saveTask
    }
}

module.exports = Repo();
