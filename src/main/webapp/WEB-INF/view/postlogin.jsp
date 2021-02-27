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
			$('#user').submit(function () {
			    let formArr = $(this).serializeArray();

			    let user = {};
			    for(let key in formArr){
				    user[formArr[key].name] = formArr[key].value;
                }

				$.ajax({
					url : '/user/register',
					data : user,
					method : 'post',
					contentType: 'application/json',
					success : function(user) {
					    alert('id : ' + user.id + ', pwd : ' + user.password + ', name : ' + user.name);
					},
					error : function() {
						alert('에러');
					},
					complete : function() {
						alert('완료');
					}
				});
			});
		});

	</script>
</head>
<body>
    <form id="user">
        <fieldset>
            <label>로그인 아이디 : </label><input id="id" name="id" type="text" />
            <input id="loginidcheck" type="button" value="아이디 중복 검사" /><br/>
            <label>비밀번호 : </label><input id="password" name="password" type="password" /><br/>
            <label>이름 : </label><input id="name" name="name" type="text" /><br/>
            <input type="submit" value="등록" />
        </fieldset>
    </form>
</body>
</html>
