<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div class="col-lg-12">
		<h1>
			Payment type 
		</h1>
	</div>
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<button class="btn btn-primary pull-right" data-toggle="modal"
			data-target="#createModal">New payment type</button>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<h2>List pament type</h2>
		<div class="table-responsive">
			<table class="table table-bordered table-hover tablesorter">
				<thead>
					<tr>
						<th hidden="true" style="width: 1%">ID <i class="fa fa-sort"></i></th>
						<th style="width: 49%">Payment type name <i
							class="fa fa-sort"></i></th>
						<th style="width: 20%">Status <i class="fa fa-sort"></i></th>
						<th style="width: 30%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="paymentType" items="${listPaymentType}"
						varStatus="status">
						<tr class="rowPaymentType" id="rowPaymentType${status.index}">
							<td hidden="true" id="0" value="${paymentType.id }">${paymentType.id }</td>
							<td id="1">${paymentType.name }</td>
							<td id="2">${paymentType.status }</td>
							<td>
								<button class="open-PaymentTypeEditDialog btn btn-warning"
									data-toggle="modal" data-target="#editModal"
									data-id="${status.index}">Edit</button>
								<button class="open-PaymentTypeActiveDialog btn btn-success"
									data-toggle="modal" data-target="#activeModal"
									data-id="${status.index}">Active</button>
								<button class="open-PaymentTypeDeactiveDialog btn btn-danger"
									data-toggle="modal" data-target="#deactiveModal"
									data-id="${status.index}">Deactive</button>
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
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Edit payment</h4>
			</div>
			<form:form class="form-horizontal" role="form"
				action="/admin/paymenttype/edit" commandName="paymentType"
				method="POST">

				<div class="modal-body">
					<form:input path="id" type="hidden" id="inputId" />
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<form:input path="name" type="text" class="form-control"
								id="inputName" placeholder="Enter payment type name..." />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Status</label>
						<div class="col-sm-10">
							<form:select path="status" class="form-control" id="inputStatus">
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
				<p>Are you sure to active this payment type?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onClick="" id="activeButton">Active</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

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
				<p>Are you sure to deactive this payment type?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onClick="" id="deactiveButton">Deactive</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<!-- /.modal -->

<!-- Modal add payment type -->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Add new</h4>
			</div>
			<form:form class="form-horizontal" role="form"
				action="/admin/paymenttype/add" commandName="paymentType"
				method="POST">
				<div class="modal-body">

					<div class="modal-body">
						<div class="form-group">
							<label for="inputname" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<form:input path="name" type="text" class="form-control"
									id="inputName" placeholder="Enter payment type name..." />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Status</label>
							<div class="col-sm-10">
								<form:select path="status" class="form-control" id="status">
									<form:option value="Active" label="Active" />
									<form:option value="Inactive" label="Inactive" />
								</form:select>
							</div>
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