<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<form action='PrimeiroServlet' method="post">
		<h2>Aplicacao CRUD JSP JPA</h2>
		<p>
			Email: <input type='text' name='email'
				placeholder="ex: joao@gmail.com" required="required">
		<p>
			Senha: <input type='password' name='senha' placeholder="ex: 12345" required="required">
		<p>
			<button type='submit' value='login' name="pagina">Entrar</button>
	</form>
</html>