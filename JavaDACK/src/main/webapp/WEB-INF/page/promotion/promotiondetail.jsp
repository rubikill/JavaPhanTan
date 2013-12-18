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
		<h2>Promotion</h2>
		<h4>
			<b>ID:</b> ${promotion.id }
		</h4>
		<h4>
			<b>Name:</b> ${promotion.name }
		</h4>
		<br>
		<div class="row">
			<div class="col-lg-12">
				<button class="btn btn-primary pull-right" data-toggle="modal"
					data-target="#createModal">Add product</button>
			</div>
		</div>
		<h3>List product in promotions</h3>
		<div class="table-responsive">
			<table class="table table-bordered table-hover tablesorter">
				<thead>
					<tr>
						<th style="width: 5%">Id <i class="fa fa-sort"></i></th>
						<th style="width: 8%">Product Id <i class="fa fa-sort"></i></th>
						<th style="width: 8%">Discount <i class="fa fa-sort"></i></th>
						<th style="width: 15%">Status <i class="fa fa-sort"></i></th>
						<th style="width: 17%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="promotiondetail" items="${listPromotionDetails }"
						varStatus="status">
						<tr class="rowPromotionDetail"
							id="rowPromotionDetail${status.index}">
							<td id="0">${promotiondetail.id }</td>
							<td id="1">${promotiondetail.productId}</td>
							<td id="2">${promotiondetail.discount}</td>
							<td id="3">${promotiondetail.status}</td>

							<td>
								<button class="open-PromotionDetailEditDialog btn btn-warning"
									data-toggle="modal" data-id="${status.index}"
									data-target="#editModal">Edit</button>
								<button class="open-PromotionDetailBlockDialog  btn btn-danger"
									data-toggle="modal" data-id="${status.index}"
									data-target="#deleteModal">Block</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-lg-12">
		<ul class="pagination">
			<li class="disabled"><span>&laquo;</span></li>
			<li class="active"><span>1 <span class="sr-only">(current)</span></span></li>
			<li><span>2 <span class="sr-only">(current)</span></span></li>
			<li><span>3 <span class="sr-only">(current)</span></span></li>
			<li><span>4 <span class="sr-only">(current)</span></span></li>
			<li><span>&raquo;</span></li>
		</ul>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog editModal">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Edit product</h4>
			</div>
			<form:form class="form-horizontal" role="form"
				action="/admin/promotions/${promotion.id }/edit"
				commandName="promotionDetail" method="POST">
				<div class="modal-body">
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Id</label>
						<div class="col-sm-8">
							<form:input path="id" type="text" class="form-control" id="id"
								placeholder="Empty" readonly="readonly" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Product
							ID</label>
						<div class="col-sm-8">
							<form:input path="productId" type="text" class="form-control"
								id="productId" placeholder="Empty" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Discount</label>
						<div class="col-sm-8">
							<form:input path="discount" type="number" class="form-control"
								id="discount" placeholder="Empty" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Status</label>
						<div class="col-sm-8">
							<form:select path="status" class="form-control" id="status">
								<form:option value="Disable" label="Disable" />
								<form:option value="Active" label="Active" />
								<form:option value="Inactive" label="Inactive" />
								<form:option value="Block" label="Block" />
							</form:select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Add</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</form:form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form:form class="form-group"
			action="/admin/promotions/${promotion.id }/block"
			commandName="promotionDetail" method="POST">
			<form:input path="id" type="hidden" id="inputId" />
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Confirm delete</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure to block this product?</p>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" id="BlockButton"
						onClick="">Save changes</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</form:form>
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<!-- Modal -->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Create product</h4>
			</div>
			<form:form class="form-horizontal" role="form"
				action="/admin/promotions/${promotion.id }/add"
				commandName="promotionDetail" method="POST">
				<div class="modal-body">
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Product
							ID</label>
						<div class="col-sm-8">
							<form:input path="productId" type="text" class="form-control"
								id="productId" placeholder="Empty" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Discount</label>
						<div class="col-sm-8">
							<form:input path="discount" type="number" class="form-control"
								id="discount" placeholder="Empty" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Status</label>
						<div class="col-sm-8">
							<form:select path="status" class="form-control" id="status">
								<form:option value="Disable" label="Disable" />
								<form:option value="Active" label="Active" />
								<form:option value="Inactive" label="Inactive" />
								<form:option value="Block" label="Block" />
							</form:select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Add</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</form:form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->