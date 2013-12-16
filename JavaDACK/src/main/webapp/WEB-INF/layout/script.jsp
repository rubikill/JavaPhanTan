<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- JavaScript -->
<script
	src="${pageContext.request.contextPath}/admin/js/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/bootstrap.js"></script>

<!-- Page Specific Plugins -->
<script src="${pageContext.request.contextPath}/admin/js/raphael-min.js"></script>
<script
	src="${pageContext.request.contextPath}/admin/js/morris/morris-0.4.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/admin/js/morris/chart-data-morris.js"></script>
<script
	src="${pageContext.request.contextPath}/admin/js/tablesorter/jquery.tablesorter.js"></script>
<script
	src="${pageContext.request.contextPath}/admin/js/tablesorter/tables.js"></script>


<script>
<!-- Fill text field in Modal fade ACCOUNT EDIT dialog-->
$(document).on("click", ".open-AccountEditDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-body #inputEmail").val($("#rowAccount" + index + " #0").text()); 
	$(".modal-body #inputName").val($("#rowAccount" + index + " #1").text()); 
	$(".modal-body #inputPhone").val($("#rowAccount" + index + " #2").text());
	$(".modal-body #inputAddress").val($("#rowAccount" + index + " #3").text());
	$(".modal-body #inputBirthday").val($("#rowAccount" + index + " #4").text());
	$(".modal-body #selectStatus").val($("#rowAccount" + index + " #7").text());
	$(".modal-body #inputToken").val($("#rowAccount" + index + " #6").text());
	$(".modal-body #inputPoint").val($("#rowAccount" + index + " #5").text());
	
});

<!-- Fill text field in Modal fade ACCOUNT BLOCK dialog-->
$(document).on("click", ".open-AccountBlockDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-footer #BlockButton").attr("onClick","location.href='/admin/account/block/" + $("#rowAccount" + index + " #0").text()+ "';"); 
});

<!-- Fill text field in Modal fade PROMOTION BLOCK dialog-->
$(document).on("click", ".open-PromotionBlockDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-footer #BlockButton").attr("onClick","location.href='/admin/promotions/block/" + $("#rowPromotion" + index + " #0").text()+ "';"); 
});



<!-- Fill text field in Modal fade PROMOTION edit dialog-->
$(document).on("click", ".open-PromotionEditDialog", function () 
{ 
	var index = $(this).data('id'); 
	console.log("id:",$("#rowPromotion" + index + " #0").text());
	console.log("name:",$("#rowPromotion" + index + " #1").text());
	
	$(".editModal #id").val($("#rowPromotion" + index + " #0").text());
	$(".editModal #name").val($("#rowPromotion" + index + " #1").text()); 
	$(".editModal #dateStart").val($("#rowPromotion" + index + " #2").text()); 
	$(".editModal #dateEnd").val($("#rowPromotion" + index + " #3").text());
	$(".editModal #content").val($("#rowPromotion" + index + " #4").text());
	$(".editModal #note").val($("#rowPromotion" + index + " #5").text());
	$(".editModal #tagId").val($("#rowPromotion" + index + " #6").text());
	$(".editModal #status").val($("#rowPromotion" + index + " #7").text());
	
});


</script>
<!-- <script src="${pageContext.request.contextPath}/themes/js/angular.min.js"></script> -->