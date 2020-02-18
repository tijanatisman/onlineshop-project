<div class="container">

	<div class="row">
	
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		
		<div class="col-md-9">
			<div class="row">
			
				<div class="col-md-12">
					<c:if test="${userClickAllProducts == true}">
					
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li>
								<a href="${contextRoot}/home">Home</a>
							</li>
							<li class="active">
								All products
							</li>
						
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
						
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li>
								<a href="${contextRoot}/home">Home</a>
							</li>
							<li>
								<a href="${contextRoot}/show/all/products">Category</a>
							</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			
			</div>
			
			<!-- Data table - list of products -->
			<div class="row">
			
				<div class="col-xs-12">
					
					<table id="productListTable" class="table table-striped table-bordered">
						
						<thead>
							<th></th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
							<th>Qty</th>
							<th></th>
						
						</thead>
					</table>
				
				</div>	
				
			</div>
				
		</div>
	</div>

	

	
</div>