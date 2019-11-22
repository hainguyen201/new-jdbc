<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>

<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<i class="ace-icon fa fa-home home-icon"></i>
					<a href="#">Trang chủ</a>
				</ul>
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-12">
								<div class="table-reponsive">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>Tên bài viết</th>
												<th>Mô tả ngắn</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="item" items="${model.listResult}" >
											<tr>
												<td>${item.title } </td>
												<td>${item.shortdescription }</td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
									<ul class="pagination" id="pagination"></ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : 35,
				visiblePages : 10,
				startPage: 4,
				onPageClick : function(event, page) {
					console.info(page + ' (from options)');
				}
			}).on('page', function(event, page) {
				console.info(page + ' (from event listening)');
			});
		});
	</script>
</body>

</html>