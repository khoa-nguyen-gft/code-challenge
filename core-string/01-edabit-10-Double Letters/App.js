function doubleLetters(word) {
	//console.log(word);
	
	return word.split('').some(function(item, index, array){
		//console.log(item);
	    //console.log(index);
	    //console.log(array);
			
		  var curIndex = array.indexOf(item);
			if (curIndex != index){
					if (curIndex == index + 1 || curIndex == index -1){
						return true;
					}
			}
		
		  if (array.length == index + 1){
				return false;
			}
		
	})
};

doubleLetters("loop");// ➞ true

doubleLetters("yummy");//  ➞ true

doubleLetters("orange");//  ➞ false

doubleLetters("munchkin");//  ➞ false