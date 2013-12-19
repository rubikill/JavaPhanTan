<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-lg-12">
		<h1>
			Dashboard <small>Statistics Overview</small>
		</h1>
		<!-- <ol class="breadcrumb">
			<li><a href=""></a><i class="fa fa-dashboard"></i> Dashboard</li>
			<li class="active"><i class="fa fa-table"></i> Tables</li>
		</ol> -->
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<button class="open-ProductCreateDialog btn btn-primary pull-right"
			data-toggle="modal" data-target="#createModal">New product</button>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<h2>List product</h2>
		<div class="table-responsive">
			<table class="table table-bordered table-hover tablesorter">
				<thead>
					<tr>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th style="width: 40%">Product name <i class="fa fa-sort"></i></th>
						<th style="width: 20%">Product type <i class="fa fa-sort"></i></th>
						<th style="width: 10%">Quantity <i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th hidden="true" style="width: 1%"><i class="fa fa-sort"></i></th>
						<th style="width: 10%">Status <i class="fa fa-sort"></i></th>
						<th style="width: 20%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${listProduct}" varStatus="status">
						<tr class="rowProduct" id="rowProduct${status.index}">
							<td hidden="true" id="0">${product.id }</td>
							<td id="1">${product.name }</td>
							<td id="2">${product.productType.name }</td>
							<td id="3">${product.quantity }</td>
							<td hidden="true" id="4">${product.sellCount }</td>
							<td hidden="true" id="5">${product.importCount }</td>
							<td hidden="true" id="6">${product.manufacturer.name }</td>
							<td hidden="true" id="7">${product.price }</td>
							<td hidden="true" id="8">${product.description }</td>
							<td hidden="true" id="9">${product.productState.name }</td>
							<td hidden="true" id="10">${product.point }</td>
							<td hidden="true" id="11">${product.productDetail.warranty }</td>
							<td hidden="true" id="12">${product.productDetail.weight }</td>
							<td hidden="true" id="13">${product.productDetail.height }</td>
							<td id="14">${product.status }</td>
							<td hidden="true" id="15">${product.productType.id }</td>
							<td hidden="true" id="16">${product.manufacturer.id }</td>
							<td hidden="true" id="17">${product.productState.id }</td>
							<td hidden="true" id="18">${currentPage}</td>
							<td>

								<button class="open-ProductDetailDialog btn btn-info"
									data-toggle="modal" data-target="#detailModal"
									data-id="${status.index}">Detail</button>
								<button class="open-ProductEditDialog btn btn-warning"
									data-toggle="modal" data-target="#editModal"
									data-id="${status.index}">Edit</button> <c:if
									test="${product.status == 'Active'}">
									<button class="open-ProductBlockDialog btn btn-danger"
										data-toggle="modal" data-target="#deleteModal"
										data-id="${status.index}">Delete</button>
								</c:if> <c:if test="${product.status == 'Inactive'}">
									<button class="open-ProductActiveDialog btn btn-danger"
										data-toggle="modal" data-target="#activeModal"
										data-id="${status.index}">Active</button>
								</c:if>


							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-lg-12">
		<ul class="pagination">
			<li><a href="/admin/products?Page=1"><span>&laquo;</span></a></li>
			<c:forEach var="i" begin="1" end="${totalPage}">
				<c:if test="${i == currentPage}">
					<li class="active"><a href="/admin/products?Page=${i}"><span>${i}<span
								class="sr-only">(current)</span></span></a></li>
				</c:if>
				<c:if test="${i != currentPage}">
					<li><a href="/admin/products?Page=${i}"><span>${i}<span
								class="sr-only">(current)</span></span></a></li>
				</c:if>
			</c:forEach>
			<li><a href="/admin/products?Page=${totalPage}"><span>&raquo;</span></a></li>
			<li><span>${currentPage}/${totalPage}</span></li>
		</ul>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form method="POST" action="/admin/product/edit"
			name="formEditProduct">
			<input type="hidden" name="inputProductId" value=""
				id="inputProductId" /> <input type="hidden" name="inputCurrentPage"
				value="" id="inputCurrentPage" />
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Edit product</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputName"
									name="inputName" placeholder="Name....">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Product
								type</label>
							<div class="col-sm-8">
								<select class="form-control" id="inputProductType"
									name="inputProductType">
									<c:forEach var="i" begin="0"
										end="${listProductType.size() - 1}">
										<option value='${listProductType.get(i).getId()}'>${listProductType.get(i).getName()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Quantity</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="inputQuantity"
									name="inputQuantity" placeholder="Quantity...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Sell
								Count</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="inputSellCount"
									name="inputSellCount" placeholder="SellCount...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Import
								Count</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="inputImportCount"
									name="inputImportCount" placeholder="ImportCount...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Manufacturer</label>
							<div class="col-sm-8">
								<select class="form-control" name="inputManufacturer"
									id="inputManufacturer">
									<c:forEach var="i" begin="0"
										end="${listManufacturer.size() - 1}">
										<option value='${listManufacturer.get(i).getId()}'>${listManufacturer.get(i).getName()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Price</label>
							<div class="col-sm-8">
								<!-- <span class="input-group-addon">$</span> -->
								<input class="form-control" type="text" id="inputPrice"
									name="inputPrice">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Description</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputDescription"
									name="inputDescription" placeholder="Description...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Product
								State</label>
							<div class="col-sm-8">
								<select class="form-control" name="inputProductState"
									id="inputProductState">
									<c:forEach var="i" begin="0"
										end="${listProductState.size() - 1}">
										<option value='${listProductState.get(i).getId()}'>${listProductState.get(i).getName()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Point</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="inputPoint"
									name="inputPoint" placeholder="Point....">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Warranty</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="inputWarranty"
									name="inputWarranty" name="inputPoint"
									placeholder="Warranty...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Weight</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputWeight"
									name="inputWeight" placeholder="Weight...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Height</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputHeight"
									name="inputHeight" placeholder="Height....">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Save changes</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</form>
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- Delete Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form method="POST" action="/admin/product/delete"
			name="formDeleteProduct">
			<input type="hidden" name="inputProductId" value=""
				id="inputProductId" /> <input type="hidden" name="inputCurrentPage"
				value="" id="inputCurrentPage" />
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Confirm delete</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure to delete this product?</p>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Ok</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</form>
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<div class="modal fade" id="activeModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form method="POST" action="/admin/product/active"
			name="formActiveProduct">
			<input type="hidden" name="inputProductId" value=""
				id="inputProductId" /> <input type="hidden" name="inputCurrentPage"
				value="" id="inputCurrentPage" />
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Confirm Active</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure to active this product?</p>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Ok</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</form>
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- create Modal-->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form method="POST" action="/admin/product/create?Page=${currentPage}"
			name="formCreateProduct">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Add new</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputPassword3"
									name="inputName" placeholder="Name....">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Product
								type</label>
							<div class="col-sm-8">
								<select class="form-control" name="inputProductType">
									<option value='${listProductType.get(0).getId()}'>${listProductType.get(0).getName()}</option>
									<c:forEach var="i" begin="1"
										end="${listProductType.size() - 1}">
										<option value='${listProductType.get(i).getId()}'>${listProductType.get(i).getName()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Quantity</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="inputPassword3"
									name="inputQuantity" placeholder="Quantity...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Sell
								Count</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="inputPassword3"
									name="inputSellCount" placeholder="SellCount...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Import
								Count</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="inputPassword3"
									name="inputImportCount" placeholder="ImportCount...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Manufacturer</label>
							<div class="col-sm-8">
								<select class="form-control" name="inputManufacturer">
									<option value='${listManufacturer.get(0).getId()}'>${listManufacturer.get(0).getName()}</option>
									<c:forEach var="i" begin="1"
										end="${listManufacturer.size() - 1}">
										<option value='${listManufacturer.get(i).getId()}'>${listManufacturer.get(i).getName()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Price</label>
							<div class="col-sm-8">
								<!-- <span class="input-group-addon">$</span> -->
								<input class="form-control" type="text" name="inputPrice">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Description</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputPassword3"
									name="inputDescription" placeholder="Description...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Product
								State</label>
							<div class="col-sm-8">
								<select class="form-control" name="inputProductState">
									<option value='${listProductState.get(0).getId()}'>${listProductState.get(0).getName()}</option>
									<c:forEach var="i" begin="1"
										end="${listProductState.size() - 1}">
										<option value='${listProductState.get(i).getId()}'>${listProductState.get(i).getName()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Point</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="inputPassword3"
									name="inputPoint" placeholder="Point....">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Warranty</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="inputPassword3"
									name="inputWarranty" name="inputPoint"
									placeholder="Warranty...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Weight</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputPassword3"
									name="inputWeight" placeholder="Weight...">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Height</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputPassword3"
									name="inputHeight" placeholder="Height....">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Status
							</label>
							<div class="col-sm-8">
								<select class="form-control" name="inputStatus">
									<option value="Active">Active</option>
									<option value="Block">Block</option>
									<option value="Disable">Disable</option>
									<option value="Inactive">Inactive</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Add Product</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</form>
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<!--  detail modal -->
<div class="modal fade" id="detailModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Details</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Name</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputName"
								name="inputName" placeholder="Name....">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Product
							Type</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputProductType"
								name="inputProductType" placeholder="Name....">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Quantity</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="inputQuantity"
								name="inputQuantity" placeholder="Quantity...">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Sell
							Count</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="inputSellCount"
								name="inputSellCount" placeholder="SellCount...">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Import
							Count</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="inputImportCount"
								name="inputImportCount" placeholder="ImportCount...">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Manufacturer</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputManufacturer"
								name="inputManufacturer" placeholder="Manufacturer...">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Price</label>
						<div class="col-sm-8">
							<!-- <span class="input-group-addon">$</span> -->
							<input class="form-control" type="text" id="inputPrice"
								name="inputPrice">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Description</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputDescription"
								name="inputDescription" placeholder="Description...">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Product
							State</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputProductState"
								name="inputProductState" placeholder="ProductState...">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Point</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="inputPoint"
								name="inputPoint" placeholder="Point....">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Warranty</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="inputWarranty"
								name="inputWarranty" name="inputPoint" placeholder="Warranty...">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Weight</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputWeight"
								name="inputWeight" placeholder="Weight...">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Height</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputHeight"
								name="inputHeight" placeholder="Height....">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Status</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputStatus"
								name="inputStatus" placeholder="Status...">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>