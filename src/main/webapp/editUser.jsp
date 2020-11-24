<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@page import="entities.Usuario"%>
<%@page import="entities.Telefone"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Edição de Usuario</title>
</head>
<body>
	<h1>Edição de Usuario</h1>
	<form action='PrimeiroServlet' method="post">

		<%
		Usuario u = (Usuario) request.getAttribute("usuario");
		List<Telefone> listaTelefones = null;
		if (u.getTelefones() != null) {
			listaTelefones = u.getTelefones();
		}
		System.out.println(listaTelefones);
		%>

		<p>
			Nome: <input type='text' name='nome' style="width: 300px"
				value="<%=u.getNome()%>">
		<p>
			Email: <input type='text' name='email' style="width: 300px"
				value="<%=u.getEmail()%>">
		<p>
			Senha: <input type='text' name='senha' style="width: 300px"
				value="<%=u.getSenha()%>">
		<p>
		<h3>Telefones:</h3>
		<table border="1">
			<tr>
				<th style="width: 30px; text-align: center">ddd</th>
				<th style="width: 100px; text-align: center">Numero</th>
				<th style="width: 80px; text-align: center">Tipo</th>
			</tr>
			<%
				for (Telefone t : listaTelefones) {
			%>
			<tr>
				<td><input style="width: 30px; text-align: center" name="ddd" value="<%=t.getDdd()%>"></td>
				<td><input style="width: 100px; text-align: center" name="numero" value="<%=t.getNumero()%>"></td>
				<td><input style="width: 80px; text-align: center" name="tipo" value="<%=t.getTipo()%>"></td>
			</tr>
			<%
				System.out.println(t);
			%>
			<%
				}
			%>
		</table>
		<button name="pagina" value="salvarteste" type="submit">Salvar</button>
		<input type="hidden" value="<%=u.getId()%>" name="id">
		<button type="button"  onclick="parent.location.href='listUser.jsp'">Voltar</button>
	</form>

</body>
</html>