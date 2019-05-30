function month_name(num) {
	const monthNames = ["January", "February", "March", "April", "May", "June",
  "July", "August", "September", "October", "November", "December"];

return monthNames[num -1 ];
}

function month_nameV2(num) {
    //long: uses the full name of the month
    //short: for the short name, 
    //narrow: for a more minimal version
 var month = new Date(2000, num-1).toLocaleString("en-us", {month: "narrow"});
return month;
}


console.log(month_nameV2(3));
console.log(month_nameV2(11));
console.log(month_nameV2(6));
