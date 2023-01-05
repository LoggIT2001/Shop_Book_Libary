function incrementValue() {
	var value = parseInt(document.getElementById('quantity').value, 10);
	value = isNaN(value) ? 0 : value;
	if (value < 10000) {
		value++;
		document.getElementById('quantity').value = value;
	}
}
function decrementValue() {
	var value = parseInt(document.getElementById('quantity').value, 10);
	value = isNaN(value) ? 0 : value;
	if (value > 1) {
		value--;
		document.getElementById('quantity').value = value;
	}

}