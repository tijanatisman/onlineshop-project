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
//	var products = [
//		['1','ABV'],
//		['2','GDD'],
//		['3','EZZ'],
//		['4','IJK'],
//		['5','LLJ'],
//		['6','MNN'],
//		['7','JOP'],
//		['8','RST']
//	];
	
	var $table = $('#productListTable');
	
	//execute below code only where we have this table
	if($table.length){
		console.log('inside the table!');
		
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}
		
		
		$table.dataTable({
			lengthMenu: [[5,10,15,-1],['5','10','15','ALL']], //-1 znaci da ce se prikazati svi proizvodi iz liste
			pageLength: 5,
//			data: products //ovo moze da se brise, to su oni proizvodi koje sam zakucala gore, umesto toga pravim ajax request uz pomoc kog dobijam data
		
			ajax: {
				url: jsonUrl,
				dataSrc: '' //ovo se stavlja jer u jsonu nemamo ni jedan objekat u koji stavljamo niz sa podacima o prozivodima, nego se u jsonu nalazi samo taj niz podataka o proizvodima i zato ovo dataSrc ostaje prazno
			},
				columns: [
					{
						data: 'code',
						mRender: function(data, type, row){
							return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg" class="dataTableImages"/>';
						}
					},
					{
						data: 'name'
					},
					{
						data: 'brand'
					},
					{
						data: 'unitPrice',
						mRender: function(data, type, row){
							return '&#36;' + data;
						}
					},
					{
						data: 'quantity',
						mRender: function(data, type, row){
							if(data < 1){
								return '<span style="color:red">Out of stock</span>';
							}
							return data;
						}
					},
					{
						data: 'id',
						bSortable: false,
						mRender: function(data, type, row){
							var str = '';
							str += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';							
							
							if(row.quantity < 1){
								str += '<a href="javascript.void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}else{
								str += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
							
							return str;
						}
					}
				]
		});
	}
	
	
	
});