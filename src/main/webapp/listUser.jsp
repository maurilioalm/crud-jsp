<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="repository.UsuarioDAO"%>
<%@page import="entities.Usuario"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Usuario</title>
</head>
<%
	UsuarioDAO usuarioDao = new UsuarioDAO();
%>
<%
	List<Usuario> listaUsuarios = usuarioDao.findAll();
%>
<body>
	<form action="PrimeiroServlet" name="listaUsuario" method="post">
		<table border="1">
			<tr>
				<th style="width: 50px; text-align: center">Id</th>
				<th style="width: 300px">Nome</th>
				<th style="width: 300px">Email</th>
				<th colspan="2">Functions</th>
			</tr>
			<%
				for (Usuario u : listaUsuarios) {
			%>
			<tr>
				<td style="text-align: center"><%=u.getId()%></td>
				<td><%=u.getNome()%></td>
				<td><%=u.getEmail()%></td>
				<td><button type="submit" value="<%=u.getId()%>" name="id">Edit</button></td>
				<td><button type="submit" value="<%=u.getId()%>"
						name="deletePorId">Delete</button></td>
			</tr>
			<%
				}
			%>
		</table>
		<button type="button" onclick="parent.location.href='createUser.jsp'">Criar
			Usuario</button>
		<input type="hidden" name="pagina" value="Edit">
	</form>
	<button onclick="parent.location.href='loginUser.jsp'">Sair</button>
</body>
</html>