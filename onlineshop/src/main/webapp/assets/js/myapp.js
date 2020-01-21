$(function() {
	// solving the active menu problem
	switch (menu) {
	
	case 'All products':
		$('#listProducts').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'Home':
		break;
	default:
		$('#listProducts').addClass('active');
		$('#category_'+menu).addClass('active');
		break;
	}
});