<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign_up.jsp 파일</title>
</head>
<body>
	<h1>sign_up.jsp file</h1>
	
	<form action="/member/signUpConfirm" method="get">
		ID : <input type="text" name="m_id" ><br/>  
		PW : <input type="password" name="m_pw" ><br/>  
		MAIL : <input type="text" name="m_mail" ><br/>  
		PHONE : <input type="text" name="m_phone"><br/> 
      	AGE : <input type="text" name="m_age"><br/> 
		<input type="submit" value="SIGN UP" >  
		<input type="reset" value="CANCEL" >  
	</form>
</body>
</html>