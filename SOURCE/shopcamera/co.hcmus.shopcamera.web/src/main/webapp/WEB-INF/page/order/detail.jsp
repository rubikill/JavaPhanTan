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
		<h2>History</h2>
		<h4>
			<b>ID:</b> ${history.id }
		</h4>
		<h4>
			<b>Email:</b> ${history.email }
		</h4>
		<fmt:formatDate value="${history.orderDate}" pattern="dd/MM/yyyy"
			var="orderDate" />
		<h4>
			<b>Order date:</b> ${orderDate}
		</h4>
		<br>
		<div class="row">
			<div class="col-lg-12">
				<button class="btn btn-primary pull-right" data-toggle="modal"
					data-target="#createModal">Add product</button>
			</div>
		</div>
		<h3>List products in order</h3>
		<div class="table-responsive">
			<table class="table table-bordered table-hover tablesorter">
				<thead>
					<tr>
						<th style="width: 5%">Id <i class="fa fa-sort"></i></th>
						<th style="width: 8%">Product Id <i class="fa fa-sort"></i></th>
						<th style="width: 8%">Quantity <i class="fa fa-sort"></i></th>
						<th style="width: 15%">Status <i class="fa fa-sort"></i></th>
						<th style="width: 17%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="historyDetail" items="${listHistoryDetails }"
						varStatus="status">
						<tr class="rowHistoryDetail" id="rowHistoryDetail${status.index}">
							<td id="0">${historyDetail.id }</td>
							<td id="1">${historyDetail.productId}</td>
							<td id="2">${historyDetail.amount}</td>
							<td id="3">${historyDetail.status}</td>

							<td>
								<button class="open-HistoryDetailEditDialog btn btn-warning"
									data-toggle="modal" data-id="${status.index}"
									data-target="#editModal">Edit</button>
								<button class="open-HistoryDetailActiveDialog  btn btn-success"
									data-toggle="modal" data-id="${status.index}"
									data-target="#activeModal">Active</button>
								<button class="open-HistoryDetailBlockDialog  btn btn-danger"
									data-toggle="modal" data-id="${status.index}"
									data-target="#deleteModal">Deactive</button>

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
				action="/admin/orders/${history.id }/edit"
				commandName="historyDetail" method="POST">
				<div class="modal-body">
					<form:input path="id" type="hidden" class="form-control" id="id"
						placeholder="Empty" />

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Product
							ID</label>
						<div class="col-sm-8">
							<form:input path="productId" type="text" class="form-control"
								id="productId" placeholder="Empty" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Quantity</label>
						<div class="col-sm-8">
							<form:input path="amount" type="number" class="form-control"
								id="quantity" placeholder="Empty" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Status</label>
						<div class="col-sm-8">
							<form:select path="status" class="form-control" id="status">
								<form:option value="Active" label="Active" />
								<form:option value="Inactive" label="Inactive" />
							</form:select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Save changes</button>
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
			action="/admin/orders/${history.id }/deactive"
			commandName="historyDetail" method="POST">
			<form:input path="id" type="hidden" id="inputId" />
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Confirm deactive</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure to deactive this product?</p>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" id="BlockButton"
						onClick="">Deacttive</button>
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
<div class="modal fade" id="activeModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form:form class="form-group"
			action="/admin/orders/${history.id }/active"
			commandName="historyDetail" method="POST">
			<form:input path="id" type="hidden" id="inputId" />
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Confirm active</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure to active this product?</p>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" id="ActiveButton"
						onClick="">Active</button>
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
				<h4 class="modal-title" id="myModalLabel">Add product</h4>
			</div>
			<form:form class="form-horizontal" role="form"
				action="/admin/orders/${history.id }/add"
				commandName="historyDetail" method="POST">
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
						<label for="inputPassword3" class="col-sm-4 control-label">Quantity</label>
						<div class="col-sm-8">
							<form:input path="amount" type="number" class="form-control"
								id="quantity" placeholder="Empty" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Status</label>
						<div class="col-sm-8">
							<form:select path="status" class="form-control" id="status">
								<form:option value="Active" label="Active" />
								<form:option value="Inactive" label="Inactive" />
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