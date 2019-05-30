function getStudentNames(students) {
    var names = students.map(x => {return x.name;});
    console.log(names);
    return names;
}


getStudentNames([{ name: 'Steve'}, { name: 'Mike'}, { name: 'John'}]);