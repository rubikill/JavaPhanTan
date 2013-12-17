<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
		<h2>List account</h2>
		<div class="table-responsive">
			<table class="table table-bordered table-hover tablesorter">
				<thead>
					<tr>
						<th style="width: 10%">Email <i class="fa fa-sort"></i></th>
						<th style="width: 10%">Name <i class="fa fa-sort"></i></th>
						<th style="width: 10%">Phone <i class="fa fa-sort"></i></th>
						<th style="width: 18%">Address <i class="fa fa-sort"></i></th>
						<th style="width: 16%">Birthday <i class="fa fa-sort"></i></th>
						<th style="width: 7%">Point <i class="fa fa-sort"></i></th>
						<th style="width: 7%">Type <i class="fa fa-sort"></i></th>
						<th style="width: 7%">Status <i class="fa fa-sort"></i></th>
						<th style="width: 15%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="account" items="${listAccount}" varStatus="status">
						<tr class="rowAccount" id="rowAccount${status.index}">

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
		<form:form class="form-group" action="/admin/account" commandName="account" method="POST">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Edit account</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<form:input path="email" type="email" class="form-control" id="inputEmail"
									placeholder="Empty"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<form:input path="name" type="text" class="form-control" id="inputName"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Phone</label>
							<div class="col-sm-10">
								<form:input path="phone" type="text" class="form-control" id="inputPhone"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Address</label>
							<div class="col-sm-10">
								<form:input path="address" type="text" class="form-control" id="inputAddress"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Birthday</label>
							<div class="col-sm-10">
								<fmt:formatDate value="${Account.birthday}" pattern="dd.MM.yyyy" var="birthday" />
								<form:input path="birthday" type="text" class="form-control" id="inputBirthday"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Type</label>
							<div class="col-sm-10">
								<form:select path="accountTypeId" class="form-control" id="selectAccountType">
									<form:option value="0" label="Select"></form:option>
									<form:options items="${listAccountType}" itemValue="id" itemLabel="name" />
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Status</label>
							<div class="col-sm-10">
								<form:select path="status" class="form-control" id="selectStatus">
									<form:option value="Disable" label="Disable"/>
									<form:option value="Active" label="Active"/>
									<form:option value="Inactive" label="Inactive"/>
									<form:option value="Block" label="Block"/>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Token</label>
							<div class="col-sm-10">
								<form:input path="token" type="text" class="form-control" id="inputToken"
									placeholder="Token"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Point</label>
							<div class="col-sm-10">
								<form:input path="point" type="text" class="form-control" id="inputPoint"
									placeholder="Point"/>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" >Save changes</button>
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

