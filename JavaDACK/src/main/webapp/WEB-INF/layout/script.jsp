<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- JavaScript -->
<script src="${pageContext.request.contextPath}/admin/js/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/bootstrap.js"></script>

<!-- Page Specific Plugins -->
<script src="${pageContext.request.contextPath}/admin/js/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/morris/morris-0.4.3.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/morris/chart-data-morris.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/tablesorter/jquery.tablesorter.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/tablesorter/tables.js"></script>


<script>
$(document).on("click", ".open-AccountEditDialog", function () 
{ 
	var index = $(this).data('id'); 
	console.log("index", index);
	console.log("name1",$(".rowAccount1 #1").text());
	console.log("name0",$(".rowAccount0 #1").text());
	console.log("name",$(".rowAccount #1").text());
	console.log("name",$(".rowAccount #1").val());
	console.log("name",$(".rowAccount #1").html());
	$(".modal-body #inputEmail").val($("#rowAccount" + index + " #0").text()); 
	$(".modal-body #inputName").val($("#rowAccount" + index + " #1").text()); 
	$(".modal-body #inputPhone").val($("#rowAccount" + index + " #2").text());
	$(".modal-body #inputAddress").val($("#rowAccount" + index + " #3").text());
	$(".modal-body #inputBirthday").val($("#rowAccount" + index + " #4").text());
	$(".modal-body #selectStatus").val($("#rowAccount" + index + " #7").text());
	$(".modal-body #inputToken").val($("#rowAccount" + index + " #6").text());
	$(".modal-body #inputPoint").val($("#rowAccount" + index + " #5").text());
	
});
</script>
<!-- <script src="${pageContext.request.contextPath}/themes/js/angular.min.js"></script> -->