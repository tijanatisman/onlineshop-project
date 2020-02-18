<div class="container">
	
		<div class="row">
	
			<div class="col-md-12">
				<ol class="breadcrumb">
						<li>
							<a href="${contextRoot}/home">Home</a>
						</li>
						<li>
							<a href="${contextRoot}/show/all/products">Products</a>
						</li>
						<li>
							<a href="${contextRoot}/show/category/${category.id}/products">${category.name}</a>
						</li>
						 <li class="active">
							${product.name}
						</li>
				</ol>
			</div>
		</div>	
		
		<div class="row">
		
			<div class="col-md-4">
				<img src="${contextRoot}/resources/images/${product.code}.jpg" class="img img-responsive"/>	
			</div>	
			
			<div class="col-md-8">
				<h1>${product.name}</h1>
					<hr>
				<p>${product.description}</p>
					<hr>
				<p>Price: &#36; ${product.unitPrice}</p>
					<hr>
				<c:choose>
					<c:when test="${product.quantity < 1}">
						<p>Qty: Available: <span style="color:red;">Out of stock</span></p>
					</c:when>
					<c:otherwise>
						<p>Qty: Available: ${product.quantity}</p>
					</c:otherwise>
				</c:choose>
				
				
					<hr>
				<p>
					<a href="${contextRoot}/show/category/${category.id}/products" class="btn btn-primary">Back</a> &#160;
					
					<c:choose>
						<c:when test="${product.quantity < 1}">
							<a href="javascript.void(0)"  class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a>
						</c:when>
						<c:otherwise>
							<a href="${contextRoot}/cart/add/${product.id}/product"  class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a>
						</c:otherwise>
					</c:choose>
					
				</p>
			</div>
		
		
		
		</div>
		

</div>