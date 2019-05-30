var repo = function(){
    var called = 0;

    var save = function(task){
        called ++;

        console.log("save repo: " + task + " Called " + called + " times");
    }
    console.log("newing up task repo");
    return {
        save: save
    }
}

module.exports = repo;
