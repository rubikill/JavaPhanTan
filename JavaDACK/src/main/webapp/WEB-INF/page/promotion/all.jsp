<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			data-target="#createModal">New product type</button>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<h2>List product</h2>
		<div class="table-responsive">
			<table class="table table-bordered table-hover tablesorter">
				<thead>
					<tr>
						<th style="width: 20%">Name <i class="fa fa-sort"></i></th>
						<th style="width: 10%">Start <i class="fa fa-sort"></i></th>
						<th style="width: 10%">End <i class="fa fa-sort"></i></th>
						<th style="width: 15%">Content <i class="fa fa-sort"></i></th>
						<th style="width: 15%">Note <i class="fa fa-sort"></i></th>
						<th style="width: 10%">Tag id <i class="fa fa-sort"></i></th>
						<th style="width: 10%">Discount <i class="fa fa-sort"></i></th>
						<th style="width: 10%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="promotion" items="${listPromotions }" varStatus="status">
						<tr class="rowAccount${status.index} ">

							<td id="0">${account.email }</td>
							<td id="1">${account.name }</td>
							<td id="2">${account.phone }</td>
							<td id="3">${account.address }</td>
							<fmt:formatDate value="${account.birthday}" pattern="dd/MM/yyyy" var="birthday" />
							<td id="4">${birthday }</td>
							<td id="5">${account.point }</td>
							<td id="6">${account.accountType.name }</td>
							<td id="7">${account.status }</td>
							<td>
								<button class="open-AccountEditDialog btn btn-warning"
									data-toggle="modal" data-id="${status.index}"
									data-target="#editModal">Edit</button>
								<button class="open-AccountDeleteDialog  btn btn-danger"
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
	<div class="modal-dialog">
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
							<input type="text" class="form-control" id="inputPassword3"
								placeholder="Empty">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Date
							start</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="inputPassword3"
								placeholder="Empty">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Date
							end</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="inputPassword3"
								placeholder="Empty">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Content</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="inputPassword3"
								placeholder="Description">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Note</label>
						<div class="col-sm-8">
							<!-- <span class="input-group-addon">$</span> -->
							<input type="text" class="form-control" id="inputPassword3"
								placeholder="Empty">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Tag
							ID</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputPassword3"
								placeholder="Empty">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Discount</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputPassword3"
								placeholder="Empty">
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Status</label>
						<div class="col-sm-8">
							<select class="form-control">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div>


				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
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
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Confirm delete</h4>
			</div>
			<div class="modal-body">
				<p>Are you sure to block this account?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- Modal add product type -->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
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
								placeholder="Empty">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Date
							start</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="inputPassword3"
								placeholder="Empty">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Date
							end</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="inputPassword3"
								placeholder="Empty">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Content</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="inputPassword3"
								placeholder="Description">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Note</label>
						<div class="col-sm-8">
							<!-- <span class="input-group-addon">$</span> -->
							<input type="text" class="form-control" id="inputPassword3"
								placeholder="Empty">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Tag
							ID</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputPassword3"
								placeholder="Empty">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Discount</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputPassword3"
								placeholder="Empty">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Status</label>
						<div class="col-sm-8">
							<select class="form-control">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->