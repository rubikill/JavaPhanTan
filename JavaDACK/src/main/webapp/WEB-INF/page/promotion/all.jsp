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
			data-target="#createModal">New promotion</button>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<h2>List promotions</h2>
		<div class="table-responsive">
			<table class="table table-bordered table-hover tablesorter">
				<thead>
					<tr>
						<th hidden="true" style="width: 1%">Id <i class="fa fa-sort"></i></th>
						<th style="width: 14%">Name <i class="fa fa-sort"></i></th>
						<th style="width: 8%">Start <i class="fa fa-sort"></i></th>
						<th style="width: 8%">End <i class="fa fa-sort"></i></th>
						<th style="width: 15%">Content <i class="fa fa-sort"></i></th>
						<th style="width: 15%">Note <i class="fa fa-sort"></i></th>
						<th style="width: 7%">Tag id <i class="fa fa-sort"></i></th>
						<th style="width: 7%">Status <i class="fa fa-sort"></i></th>
						<th style="width: 20%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="promotion" items="${listPromotions }"
						varStatus="status">
						<tr class="rowPromotion" id="rowPromotion${status.index}">
							<td hidden="true" id="0">${promotion.id }</td>
							<td id="1"><a href="/admin/promotions/${promotion.id }">${promotion.name
									}</a></td>

							<fmt:formatDate value="${promotion.date_start}"
								pattern="dd/MM/yyyy" var="date_start" />
							<td id="2">${date_start}</td>
							<fmt:formatDate value="${promotion.date_end}"
								pattern="dd/MM/yyyy" var="date_end" />
							<td id="3">${date_end}</td>
							<td id="4">${promotion.content}</td>
							<td id="5">${promotion.note}</td>
							<td id="6">${promotion.tagId}</td>
							<td id="7">${promotion.status}</td>

							<td>
								<button class="open-PromotionEditDialog btn btn-warning"
									data-toggle="modal" data-id="${status.index}"
									data-target="#editModal">Edit</button>
								<button class="open-PromotionActiveDialog  btn btn-success"
									data-toggle="modal" data-id="${status.index}"
									data-target="#activeModal">Active</button>
								<button class="open-PromotionBlockDialog  btn btn-danger"
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
				action="/admin/promotions/edit" commandName="promotion"
				method="POST">
				<div class="modal-body">
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Id</label>
						<div class="col-sm-8">
							<form:input path="id" type="text" class="form-control" id="id"
								placeholder="Empty" readonly="readonly" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Name</label>
						<div class="col-sm-8">
							<form:input path="name" type="text" class="form-control"
								id="name" placeholder="Empty" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Date
							start</label>
						<div class="col-sm-8">
							<form:input path="date_start" type="number" class="form-control"
								id="dateStart" placeholder="Empty" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Date
							end</label>
						<div class="col-sm-8">
							<form:input path="date_end" type="number" class="form-control"
								id="dateEnd" placeholder="Empty" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Content</label>
						<div class="col-sm-8">
							<form:input path="content" type="number" class="form-control"
								id="content" placeholder="Description" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Note</label>
						<div class="col-sm-8">
							<!-- <span class="input-group-addon">$</span> -->
							<form:input path="note" type="text" class="form-control"
								id="note" placeholder="Empty" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Tag
							ID</label>
						<div class="col-sm-8">
							<form:input path="tagId" type="text" class="form-control"
								id="tagId" placeholder="Empty" />
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
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Confirm deactive</h4>
			</div>
			<div class="modal-body">
				<p>Are you sure to deactive this promotion?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="BlockButton"
					onClick="">Save changes</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
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
				<p>Are you sure to active this promotion?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="ActiveButton"
					onClick="">Active</button>
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
			<form:form class="form-horizontal" role="form"
				action="/admin/promotions/add" commandName="promotion" method="POST">
				<div class="modal-body">

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Name</label>
						<div class="col-sm-8">
							<form:input path="name" type="text" class="form-control"
								id="name" placeholder="Empty" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Date
							start</label>
						<div class="col-sm-8">
							<form:input path="date_start" type="number" class="form-control"
								id="date_start" placeholder="Empty" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Date
							end</label>
						<div class="col-sm-8">
							<form:input path="date_end" type="number" class="form-control"
								id="dateEnd" placeholder="Empty" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Content</label>
						<div class="col-sm-8">
							<form:input path="content" type="number" class="form-control"
								id="content" placeholder="Description" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Note</label>
						<div class="col-sm-8">
							<!-- <span class="input-group-addon">$</span> -->
							<form:input path="note" type="text" class="form-control"
								id="note" placeholder="Empty" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Tag
							ID</label>
						<div class="col-sm-8">
							<form:input path="tagId" type="text" class="form-control"
								id="tagId" placeholder="Empty" />
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