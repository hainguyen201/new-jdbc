<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title><dec:title default="Trang chu" /></title>
<link
	href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css" media="all">
<link href="<c:url value='/template/web/css/style.css'/>"
	rel="stylesheet" type="text/css" media="all">
</head>
<body>
	<!-- header -->
	<%@include file="/common/web/header.jsp"%>

	<div class="container">
		<dec:body />
	</div>

	<!-- footer -->
	<%@include file="/common/web/footer.jsp"%>

	<script type="text/javascript" src="/template/web/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="/template/web/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>