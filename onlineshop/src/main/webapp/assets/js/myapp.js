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
	
	
	//code for jquery DataTable
	//create a dataset
	var products = [
		['1','ABV'],
		['2','GDD'],
		['3','EZZ'],
		['4','IJK'],
		['5','LLJ'],
		['6','MNN'],
		['7','JOP'],
		['8','RST']
	];
	
	var $table = $('#productListTable');
	
	//execute below code only where we have this table
	if($table.length){
//		console.log('inside the table!');
		
		$table.dataTable({
			lengthMenu: [[5,10,15,-1],['5','10','15','ALL']], //-1 znaci da ce se prikazati svi proizvodi iz liste
			pageLength: 5,
			data: products
		});
	}
	
	
	
});