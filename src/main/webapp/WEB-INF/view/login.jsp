<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<!-- 왜 못 불러오는지 확인 필요!!
	<script src="/WEB-INF/external/js/jquery/jquery-3.5.1.js"></script>
	-->
	<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

	<script>
		$(document).ready(function () {
			$('#loginidcheck').click(function () {
				let loginId = $('#loginid').val();

				$.ajax({
					url : '/user/checkloginid/'+loginId,
					success : function(result) {
						if(result.duplicated == true) {
						    alert('이미 등록된 로그인ID입니다. ' + result.availableId + '는 사용할 수 있습니다.');
						}
						else {
						    alert('사용할 수 있는 로그인ID입니다');
						}
					},
					error : function(jqXHR) {
						alert('에러');
					},
					complete : function(jqXHR) {
						alert('완료');
					}
				});
			});
		});

	</script>
</head>
<body>
    <label>로그인 아이디 : </label>
    <input id="loginid" name="loginid" type="text" />
    <input id="loginidcheck" type="button" value="아이디 중복검사" />
</body>
</html>
