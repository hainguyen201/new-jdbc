<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chu" /></title>
<link rel="stylesheet"
	href=" <c:url value="/template/admin/assets/css/bootstrap.min.css" />" />
<link rel="stylesheet"
	href=" <c:url value="/template/admin/assets/font-awesome/4.5.0/css/font-awesome.min.css" />" />

<link rel="stylesheet"
	href=" <c:url value="/template/admin/assets/css/ace.min.css" />"
	class="ace-main-stylesheet" id="main-ace-style" />
<script
	src='<c:url value="/template/admin/assets/js/ace-extra.min.js" />'></script>
<link rel="stylesheet"
	href="http://ajax.googleleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href='<c:url value="/code.jquery.com/1.12.1/themes/base/jquery-ui.css"/>'>
<script
	src="http://ajax.googleleapis.com/ajax/libs/jquery/3.2.1/query.min.js"></script>
<script
	src='<c:url value="/template/admin/assets/js/jquery-2.1.4.min.js"/>'
	type="text/javascript"></script>
<script src='<c:url value="/template/paging/jquery.twbsPagination.js"/>'
	type="text/javascript"></script>
</head>
<body class="no-skin">
	<%@include file="/common/admin/header.jsp"%>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>
		<%@include file="/common/admin/menu.jsp"%>
		<dec:body />
		<%@include file="/common/admin/footer.jsp"%>
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>

	<script src=<c:url value="/template/admin/assets/js/bootstrap.min.js"/>></script>
	<script
		src=<c:url value="/template/admin/assets/js/jquery-ui.custom.min.js"/>'></script>
	<script
		src=<c:url value="/template/admin/assets/js/jquery.ui.touch-punch.min.js"/>'></script>
	<script
		src=<c:url value="/template/admin/assets/js/jquery.easypiechart.min.js"/>'></script>
	<script
		src=<c:url value="/template/admin/assets/js/jquery.sparkline.index.min.js"/>'></script>
	<script
		src=<c:url value="/template/admin/assets/js/jquery.flot.min.js"/>'></script>
	<script
		src=<c:url value="/template/admin/assets/js/jquery.flot.pie.min.js"/>'></script>
	<script
		src=<c:url value="/template/admin/assets/js/jquery.flot.resize.min.js"/>'></script>

	<!-- ace scripts -->
	<script
		src=<c:url value="/template/admin/assets/js/ace-elements.min.js"/>'></script>
	<script src=<c:url value="/template/admin/assets/js/ace.min.js"/>'></script>
	<script src=<c:url value="/template/admin/assets/js/bootstrap.min.js"/>'></script>
	<script src=<c:url value="/template/admin/assets/js/jquery-ui.min.js"/>'></script>
	<script
		src='<c:url value="/template/paging/jquery.twbsPagination.js"/>'
		type="text/javascript"></script>
</body>
</html>