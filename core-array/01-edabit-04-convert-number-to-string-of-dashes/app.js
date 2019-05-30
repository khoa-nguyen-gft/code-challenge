function Go(num) {
	return '-'.repeat(num);
}

function Gov2(num) {
	return Array(num).fill('-').join('');
}


function Gov3(num) {
	return Array.from({length: num}).fill('-');
}

console.log(Gov3(10));