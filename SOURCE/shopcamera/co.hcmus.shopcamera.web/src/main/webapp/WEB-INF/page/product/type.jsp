<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row">
	<div class="col-lg-12">
		<h1>Dashboard <small>Statistics Overview</small></h1>
		<!-- <ol class="breadcrumb">
			<li><a href=""></a><i class="fa fa-dashboard"></i> Dashboard</li>
			<li class="active"><i class="fa fa-table"></i> Tables</li>
		</ol> -->
	</div>
</div><!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<button class="btn btn-primary pull-right" data-toggle="modal" data-target="#createModal">New product type</button>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<h2>List product</h2>		
		<div class="table-responsive">
			<table class="table table-bordered table-hover tablesorter">
				<thead>
					<tr>
						<th style="width: 60%">Product type name <i class="fa fa-sort"></i></th>
						<th style="width: 30%">Action</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>/index.html</td>
						<td>
							<button class="btn btn-warning" data-toggle="modal" data-target="#editModal">Edit</button>
							<button class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Block</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-lg-12">
		<ul class="pagination">
			<li class="disabled"><span>&laquo;</span></li>
			<li class="active"><span>1 <span class="sr-only">(current)</span></span></li>
			<li ><span>2 <span class="sr-only">(current)</span></span></li>
			<li ><span>3 <span class="sr-only">(current)</span></span></li>
			<li ><span>4 <span class="sr-only">(current)</span></span></li>
			<li ><span>&raquo;</span></li>
		</ul>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Edit product</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="inputname" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputname" placeholder="Enter product type name...">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Confirm delete</h4>
			</div>
			<div class="modal-body">
				<p>Are you sure to block this account?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- Modal add product type -->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Add new</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="inputname" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputname" placeholder="Enter product type name...">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->