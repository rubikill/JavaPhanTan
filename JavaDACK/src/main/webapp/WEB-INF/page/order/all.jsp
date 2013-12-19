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
		<button class="btn btn-primary pull-right" data-toggle="modal"
			data-target="#createModal">New order</button>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<h2>List orders</h2>
		<div class="table-responsive">
			<table class="table table-bordered table-hover tablesorter">
				<thead>
					<tr>
						<th style="width: 1%" hidden="true" />
						<th style="width: 19%">Email <i class="fa fa-sort"></i></th>
						<th style="width: 8%">Quantity <i class="fa fa-sort"></i></th>
						<th style="width: 10%">Order date <i class="fa fa-sort"></i></th>
						<th style="width: 10%">Delivery date <i class="fa fa-sort"></i></th>
						<th style="width: 10%">Payment date <i class="fa fa-sort"></i></th>
						<th style="width: 7%">Payment type <i class="fa fa-sort"></i></th>
						<th style="width: 7%">Payment status <i class="fa fa-sort"></i></th>
						<th style="width: 7%">Status <i class="fa fa-sort"></i></th>
						<th style="width: 29%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="history" items="${listHistory}" varStatus="status">
						<tr class="rowHistory" id="rowHistory${status.index}">
							<td id="0" hidden="true">${history.id }</td>
							<td id="1">${history.email }</td>
							<td id="2">${history.quantity }</td>
							<fmt:formatDate value="${history.orderDate}" pattern="dd/MM/yyyy"
								var="orderDate" />
							<td id="3">${orderDate}</td>
							<fmt:formatDate value="${history.deliveryDate}"
								pattern="dd/MM/yyyy" var="deliveryDate" />
							<td id="4">${deliveryDate }</td>
							<fmt:formatDate value="${history.paymentDate}"
								pattern="dd/MM/yyyy" var="paymentDate" />
							<td id="5">${deliveryDate }</td>
							<td id="6">${history.paymentType.name }</td>
							<td id="7">${history.paymentStatus}</td>
							<td id="8">${history.status }</td>
							<td>
								<button class="open-HistoryEditDialog btn btn-info"
									data-toggle="modal" data-id="${status.index}"
									data-target="#editModal">Edit</button>
								<button class="open-HistoryActiveDialog  btn btn-success"
									data-toggle="modal" data-id="${status.index}"
									data-target="#activeModal">Active</button>
								<button class="open-HistoryDeactiveDialog  btn btn-danger"
									data-toggle="modal" data-id="${status.index}"
									data-target="#deactiveModal">Deactive</button>
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
	<div class="modal-dialog">
		<form:form class="form-group" action="/admin/orders/edit"
			commandName="history" method="POST">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Edit order</h4>
				</div>
				<div class="modal-body">
					<form:input path="id" id="inputId" type="hidden" />
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-4 control-label">Email</label>
						<div class="col-sm-8">
							<form:input path="email" type="email" class="form-control"
								id="inputEmail" placeholder="Empty" readonly="readonly" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Quantity</label>
						<div class="col-sm-8">
							<form:input path="quantity" type="number" class="form-control"
								id="inputQuantity" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Order
							date</label>
						<div class="col-sm-8">
							<form:input path="orderDate" type="text" class="form-control"
								id="inputOrderDate" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Delivery
							date</label>
						<div class="col-sm-8">
							<form:input path="deliveryDate" type="text" class="form-control"
								id="inputDeliveryDate" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Payment
							date</label>
						<div class="col-sm-8">
							<form:input path="paymentDate" type="text" class="form-control"
								id="inputPaymentDate" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Payment
							type</label>
						<div class="col-sm-8">
							<form:select path="paymentTypeId" class="form-control"
								id="selectPaymentType">
								<form:option value="0" label="Select"></form:option>
								<form:options items="${listPaymentType}" itemValue="id"
									itemLabel="name" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Payment
							status</label>
						<div class="col-sm-8">
							<form:select path="paymentStatus" class="form-control"
								id="selectPaymentStatus">
								<form:option value="Paid" label="Paid" />
								<form:option value="Unpaid" label="Unpaid" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Status</label>
						<div class="col-sm-8">
							<form:select path="status" class="form-control" id="selectStatus">
								<form:option value="Disable" label="Disable" />
								<form:option value="Active" label="Active" />
								<form:option value="Inactive" label="Inactive" />
								<form:option value="Block" label="Block" />
							</form:select>
						</div>
					</div>


				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Save changes</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</form:form>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- Modal -->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<form:form class="form-group" action="/admin/orders/create"
		commandName="history" method="POST">
		<div class="modal-dialog">

			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Create order</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-4 control-label">Email</label>
						<div class="col-sm-8">
							<form:input path="email" type="email" class="form-control"
								id="inputEmail" placeholder="Empty" readonly="readonly" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Quantity</label>
						<div class="col-sm-8">
							<form:input path="quantity" type="number" class="form-control"
								id="inputName" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Order
							date</label>
						<div class="col-sm-8">
							<form:input path="orderDate" type="text" class="form-control"
								id="inputOrderDate" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Delivery
							date</label>
						<div class="col-sm-8">
							<form:input path="deliveryDate" type="text" class="form-control"
								id="inputDeliveryDate" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Payment
							date</label>
						<div class="col-sm-8">
							<form:input path="paymentDate" type="text" class="form-control"
								id="inputPaymentDate" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Payment
							type</label>
						<div class="col-sm-8">
							<form:select path="paymentTypeId" class="form-control"
								id="selectPaymentType">
								<form:option value="0" label="Select"></form:option>
								<form:options items="${listPaymentType}" itemValue="id"
									itemLabel="name" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Payment
							status</label>
						<div class="col-sm-8">
							<form:select path="paymentStatus" class="form-control"
								id="selectPaymentStatus">
								<form:option value="Paid" label="Paid" />
								<form:option value="Unpaid" label="Unpaid" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Status</label>
						<div class="col-sm-8">
							<form:select path="status" class="form-control" id="selectStatus">
								<form:option value="Disable" label="Disable" />
								<form:option value="Active" label="Active" />
								<form:option value="Inactive" label="Inactive" />
								<form:option value="Block" label="Block" />
							</form:select>
						</div>
					</div>


				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Create</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>

			</div>

			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</form:form>
</div>
<!-- /.modal -->

<!-- Modal -->
<div class="modal fade" id="activeModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">

		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Confirm active</h4>
			</div>
			<div class="modal-body">
				<p>Are you sure to active this orders?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="activeButton"
					onclick="">Active</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- Modal -->
<div class="modal fade" id="deactiveModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">

		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Confirm deactive</h4>
			</div>
			<div class="modal-body">
				<p>Are you sure to deactive this orders?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="deactiveButton"
					onclick="">Deactive</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

