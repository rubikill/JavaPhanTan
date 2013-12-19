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

<!-- ================================ ACCOUNT =========================== -->

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
	$(".modal-dialog #inputEmail").val($("#rowAccount" + index + " #0").text()); 
});

<!-- Fill text field in Modal fade ACCOUNT BLOCK dialog-->
$(document).on("click", ".open-AccountActiveDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-dialog #inputEmail").val($("#rowAccount" + index + " #0").text()); 
});


<!-- ======================= PROMOTION =============================-->
<!-- Fill text field in Modal fade PROMOTION BLOCK dialog-->
$(document).on("click", ".open-PromotionBlockDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-footer #BlockButton").attr("onClick","location.href='/admin/promotions/block/" + $("#rowPromotion" + index + " #0").text()+ "';"); 
});

<!-- Fill text field in Modal fade PROMOTION ACTIVE dialog-->
$(document).on("click", ".open-PromotionActiveDialog", function () 
{  
	console.log("open promotionactiveDialog");
	var index = $(this).data('id'); 
	$(".modal-footer #ActiveButton").attr("onClick","location.href='/admin/promotions/active/" + $("#rowPromotion" + index + " #0").text()+ "';"); 
});


<!-- Fill text field in Modal fade PROMOTION edit dialog-->
$(document).on("click", ".open-PromotionEditDialog", function () 
{ 
	var index = $(this).data('id'); 
	$(".editModal #id").val($("#rowPromotion" + index + " #0").text());
	$(".editModal #name").val($("#rowPromotion" + index + " #1").text()); 
	$(".editModal #dateStart").val($("#rowPromotion" + index + " #2").text()); 
	$(".editModal #dateEnd").val($("#rowPromotion" + index + " #3").text());
	$(".editModal #content").val($("#rowPromotion" + index + " #4").text());
	$(".editModal #note").val($("#rowPromotion" + index + " #5").text());
	$(".editModal #tagId").val($("#rowPromotion" + index + " #6").text());
	$(".editModal #status").val($("#rowPromotion" + index + " #7").text());
	
});


<!-- ========================= PRODUCT ==================================-->
<!-- Fill text field in Modal fade Product BLOCK dialog-->
$(document).on("click", ".open-ProductBlockDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-dialog #inputProductId").val($("#rowProduct" + index + " #0").text()); 
});

<!-- Fill text field in Modal fade Product Active dialog-->
$(document).on("click", ".open-ProductActiveDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-dialog #inputProductId").val($("#rowProduct" + index + " #0").text()); 
});

<!-- Fill text field in Modal fade Product Detail dialog-->
$(document).on("click", ".open-ProductDetailDialog", function () 
{  
			var index = $(this).data('id');  
			$(".modal-body #inputName").val($("#rowProduct" + index + " #1").text()); 
			$(".modal-body #inputProductType").val($("#rowProduct" + index + " #2").text());
			$(".modal-body #inputQuantity").val($("#rowProduct" + index + " #3").text());
			$(".modal-body #inputSellCount").val($("#rowProduct" + index + " #4").text());
			$(".modal-body #inputImportCount").val($("#rowProduct" + index + " #5").text());
			$(".modal-body #inputManufacturer").val($("#rowProduct" + index + " #6").text());
			$(".modal-body #inputPrice").val($("#rowProduct" + index + " #7").text());
			$(".modal-body #inputDescription").val($("#rowProduct" + index + " #8").text());
			$(".modal-body #inputProductState").val($("#rowProduct" + index + " #9").text());
			$(".modal-body #inputPoint").val($("#rowProduct" + index + " #10").text());
			$(".modal-body #inputWarranty").val($("#rowProduct" + index + " #11").text());
			$(".modal-body #inputWeight").val($("#rowProduct" + index + " #12").text());
			$(".modal-body #inputHeight").val($("#rowProduct" + index + " #13").text());
			$(".modal-body #inputStatus").val($("#rowProduct" + index + " #14").text());
});

<!-- Fill text field in Modal fade Edit Product  dialog-->
$(document).on("click", ".open-ProductEditDialog", function () 
{  
			var index = $(this).data('id');  
			$(".modal-dialog #inputProductId").val($("#rowProduct" + index + " #0").text()); 
			$(".modal-body #inputName").val($("#rowProduct" + index + " #1").text()); 
			$(".modal-body #inputProductType").val($("#rowProduct" + index + " #15").text());
			$(".modal-body #inputQuantity").val($("#rowProduct" + index + " #3").text());
			$(".modal-body #inputSellCount").val($("#rowProduct" + index + " #4").text());
			$(".modal-body #inputImportCount").val($("#rowProduct" + index + " #5").text());
			$(".modal-body #inputManufacturer").val($("#rowProduct" + index + " #16").text());
			$(".modal-body #inputPrice").val($("#rowProduct" + index + " #7").text());
			$(".modal-body #inputDescription").val($("#rowProduct" + index + " #8").text());
			$(".modal-body #inputProductState").val($("#rowProduct" + index + " #17").text());
			$(".modal-body #inputPoint").val($("#rowProduct" + index + " #10").text());
			$(".modal-body #inputWarranty").val($("#rowProduct" + index + " #11").text());
			$(".modal-body #inputWeight").val($("#rowProduct" + index + " #12").text());
			$(".modal-body #inputHeight").val($("#rowProduct" + index + " #13").text());
			});
		


<!-- ==================================== PROMOTION DETAIL ==================================-->

<!-- Fill text field in Modal fade PROMOTION DETAIL EDIT dialog-->
$(document).on("click", ".open-PromotionDetailEditDialog", function () 
{ 
	var index = $(this).data('id'); 	
	$(".editModal #id").val($("#rowPromotionDetail" + index + " #0").text());
	$(".editModal #productId").val($("#rowPromotionDetail" + index + " #1").text()); 
	$(".editModal #discount").val($("#rowPromotionDetail" + index + " #2").text()); 
	$(".editModal #status").val($("#rowPromotionDetail" + index + " #3").text());
	
});

<!-- Fill text field in Modal fade PROMOTION DETAIL BLOCK dialog-->
$(document).on("click", ".open-PromotionDetailBlockDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-dialog #inputId").val($("#rowAccount" + index + " #0").text()); 
});

<!--======================= PRODUCT TYPE ====================-->

<!-- Set href for button in Modal fade PRODUCT TYPE ACTIVE dialog-->
$(document).on("click", ".open-ProductTypeActiveDialog", function () 
{  
	var index = $(this).data('id');
	$(".modal-footer #activeButton").attr("onClick","location.href='/admin/producttype/active/" + $("#rowProductType" + index + " #0").text()+ "';"); 
});

<!-- Set href for button in Modal fade PRODUCT TYPE DEACIVEdialog-->
$(document).on("click", ".open-ProductTypeDeactiveDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-footer #deactiveButton").attr("onClick","location.href='/admin/producttype/deactive/" + $("#rowProductType" + index + " #0").text()+ "';"); 
});

<!-- Fill text field in Modal fade PRODUCT TYPE EDIT dialog-->
$(document).on("click", ".open-ProductTypeEditDialog", function () 
{ 
	var index = $(this).data('id'); 	
	$(".modal-body #inputId").val($("#rowProductType" + index + " #0").text());
	$(".modal-body #inputName").val($("#rowProductType" + index + " #1").text());
	$(".modal-body #inputStatus").val($("#rowProductType" + index + " #2").text());
	
});

<!--========================= ORDERS (HISTORY) =====================-->

<!-- Set href for button in Modal fade ORDER (HISTORY) ACTIVE dialog-->
$(document).on("click", ".open-HistoryActiveDialog", function () 
{  
	var index = $(this).data('id');

	$(".modal-footer #activeButton").attr("onClick","location.href='/admin/orders/active/" + $("#rowHistory" + index + " #0").text()+ "';"); 
});

<!-- Set href for button in Modal fade ORDER (HISTORY) DEACIVEdialog-->
$(document).on("click", ".open-HistoryDeactiveDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-footer #deactiveButton").attr("onClick","location.href='/admin/orders/deactive/" + $("#rowHistory" + index + " #0").text()+ "';"); 
});

<!-- Fill text field in Modal fade ORDER (HISTORY) EDIT dialog-->
$(document).on("click", ".open-HistoryEditDialog", function () 
{ 
	var index = $(this).data('id'); 	
	$(".modal-body #inputId").val($("#rowHistory" + index + " #0").text());
	$(".modal-body #inputEmail").val($("#rowHistory" + index + " #1").text());
	$(".modal-body #inputQuantity").val($("#rowHistory" + index + " #2").text());
	$(".modal-body #inputOrderDate").val($("#rowHistory" + index + " #3").text());
	$(".modal-body #inputDeliveryDate").val($("#rowHistory" + index + " #4").text());
	$(".modal-body #inputPaymentDate").val($("#rowHistory" + index + " #5").text());
	$(".modal-body #selectPaymentType").val($("#rowHistory" + index + " #6").text());
	$(".modal-body #selectPaymentStatus").val($("#rowHistory" + index + " #7").text());
	$(".modal-body #selectStatus").val($("#rowHistory" + index + " #8").text());
	
});

<!--======================= PAYMENT TYPE ====================-->

<!-- Set href for button in Modal fade PAYMENT TYPE ACTIVE dialog-->
$(document).on("click", ".open-PaymentTypeActiveDialog", function () 
{  
	var index = $(this).data('id');
	$(".modal-footer #activeButton").attr("onClick","location.href='/admin/paymenttype/active/" + $("#rowPaymentType" + index + " #0").text()+ "';"); 
});

<!-- Set href for button in Modal fade PAYMENT TYPE DEACIVE dialog-->
$(document).on("click", ".open-PaymentTypeDeactiveDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-footer #deactiveButton").attr("onClick","location.href='/admin/paymenttype/deactive/" + $("#rowPaymentType" + index + " #0").text()+ "';"); 
});

<!-- Fill text field in Modal fade PAYMENT TYPE EDIT dialog-->
$(document).on("click", ".open-PaymentTypeEditDialog", function () 
{ 
	var index = $(this).data('id'); 	
	$(".modal-body #inputId").val($("#rowPaymentType" + index + " #0").text());
	$(".modal-body #inputName").val($("#rowPaymentType" + index + " #1").text());
	$(".modal-body #inputStatus").val($("#rowPaymentType" + index + " #2").text());
	
});

<!--======================= MANUFACTURER ====================-->

<!-- Set href for button in Modal fade MANUFACTURER ACTIVE dialog-->
$(document).on("click", ".open-ManufacturerActiveDialog", function () 
{  
	var index = $(this).data('id');
	$(".modal-footer #activeButton").attr("onClick","location.href='/admin/manufacturer/active/" + $("#rowManufacturer" + index + " #0").text()+ "';"); 
});

<!-- Set href for button in Modal fade MANUFACTURER DEACIVEdialog-->
$(document).on("click", ".open-ManufacturerDeactiveDialog", function () 
{  
	var index = $(this).data('id'); 
	$(".modal-footer #deactiveButton").attr("onClick","location.href='/admin/manufacturer/deactive/" + $("#rowManufacturer" + index + " #0").text()+ "';"); 
});

<!-- Fill text field in Modal fade PRODUCT TYPE EDIT dialog-->
$(document).on("click", ".open-ManufacturerEditDialog", function () 
{ 
	var index = $(this).data('id'); 	
	$(".modal-body #inputId").val($("#rowManufacturer" + index + " #0").text());
	$(".modal-body #inputName").val($("#rowManufacturer" + index + " #1").text());
	$(".modal-body #inputStatus").val($("#rowManufacturer" + index + " #2").text());
	
});


</script>

<!-- <script src="${pageContext.request.contextPath}/themes/js/angular.min.js"></script> -->