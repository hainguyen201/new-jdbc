<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="container">
		<div class="login-form">
			<div class="main-div">
			
				<form id="Login" action='<c:url value="/dang-nhap"/>' method="POST">
					<div class="form-group">
						<input type="email" class="form-control" id="inputEmail"
							name="userName" placeholder="Tên đăng nhập">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="inputPassword"
							name="password" placeholder="Mật khẩu">
					</div>
					<input type="hidden" value="login" name="action"/>
					<button type="submit" class="btn btn-primary">Đăng nhập</button>
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>