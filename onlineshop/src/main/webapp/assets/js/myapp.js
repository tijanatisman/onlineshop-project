$(function() {
	// solving the active manu problem

	switch (manu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
	default:
		$('#home').addClass('active');
		break;
	}
});