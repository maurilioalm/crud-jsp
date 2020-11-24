package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Telefone;
import entities.Usuario;
import repository.UsuarioDAO;

/**
 * Servlet implementation class PrimeiroServlet
 */
@WebServlet("/PrimeiroServlet")
public class PrimeiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDao = new UsuarioDAO();
	private boolean autenticado = false;
	private String email;
	private String senha;
	private String localRequisitions;

	public PrimeiroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		localRequisitions = request.getParameter("pagina");
		if (localRequisitions.equals("login")) {
			autenticado = false;
		}

		while (autenticado != true && localRequisitions.equals("login")) {
			email = request.getParameter("email");
			senha = request.getParameter("senha");
			autenticado = usuarioDao.autenticar(email, senha);
			if (autenticado == false) {

				request.getRequestDispatcher("loginUser.jsp").forward(request, response);
			}
		}

		System.out.println(email + " " + senha);

		System.out.println(usuarioDao.autenticar(email, senha));

		System.out.println(localRequisitions);
		if ((usuarioDao.autenticar(email, senha) || autenticado)) {
			autenticado = usuarioDao.autenticar(email, senha);

			// Metodo para Login
			if (localRequisitions.equals("login") && autenticado) {

				request.getRequestDispatcher("listUser.jsp").forward(request, response);
			}

			// Pagina de Edicao
			if (localRequisitions.equals("Edit") && autenticado) {

				if (localRequisitions.equals("Edit") && request.getParameter("deletePorId") != null) {
					Long deletePorId = Long.parseLong(request.getParameter("deletePorId"));
					usuarioDao.abrirTransaction();
					usuarioDao.excluir(deletePorId);
					usuarioDao.fecharTransaction();
					request.getRequestDispatcher("listUser.jsp").forward(request, response);
				}

				Long id = Long.parseLong(request.getParameter("id"));
				System.out.println(id);
				Usuario u = usuarioDao.obterPorId(id);

				request.setAttribute("usuario", u);

				request.getRequestDispatcher("editUser.jsp").forward(request, response);
			}

			// Salvando Edicao
			if (localRequisitions.equals("salvarteste") && autenticado) {

				System.out.println("Entrou");
				Long id = Long.parseLong(request.getParameter("id"));
				System.out.println(id);
				Usuario u = usuarioDao.obterPorId(id);
				System.out.println(u);
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				String senha = request.getParameter("senha");
				System.out.println(nome + " " + email + " " + senha);
				u.setNome(nome);
				u.setEmail(email);
				u.setSenha(senha);
				
				List<Telefone> listaTelefones = new ArrayList<Telefone>();
				Map<String, String[]> map = request.getParameterMap();
				String[] ddds = map.get("ddd");
				String[] numeros = map.get("numero");
				String[] tipos = map.get("tipo");

				System.out.println(ddds.length);

				for (int i = 0; i < ddds.length; i++) {
					System.out.println(i);
					Telefone telefone = new Telefone();
					System.out.println(Integer.parseInt(ddds[i]));
					telefone.setDdd(Integer.parseInt(ddds[i]));
					System.out.println(numeros[i]);
					telefone.setNumero(numeros[i]);
					System.out.println(tipos[i]);
					telefone.setTipo(tipos[i]);
					
					listaTelefones.add(telefone);
				}
				
				System.out.println(listaTelefones);
				System.out.println(u);
				u.setTelefones(listaTelefones);

				
				System.out.println(u);
				usuarioDao.abrirTransaction();
				usuarioDao.atualizar(u);
				usuarioDao.fecharTransaction();
				request.getRequestDispatcher("listUser.jsp").forward(request, response);
			}

			// Criacao de Usuarios
			if (localRequisitions.equals("Salvar") && autenticado) {

				String nomeUsuario = request.getParameter("nome");
				String emailUsuario = request.getParameter("email");
				String senhaUsuario = request.getParameter("senha");
				Usuario usuario = new Usuario(nomeUsuario, emailUsuario, senhaUsuario);

				List<Telefone> listaTelefones = new ArrayList<Telefone>();
				Map<String, String[]> map = request.getParameterMap();
				String[] ddds = map.get("ddd");
				String[] numeros = map.get("numero");
				String[] tipos = map.get("tipo");

				System.out.println(ddds.length);

				for (int i = 0; i < ddds.length; i++) {
					System.out.println(i);
					Telefone telefone = new Telefone();
					System.out.println(Integer.parseInt(ddds[i]));
					telefone.setDdd(Integer.parseInt(ddds[i]));
					System.out.println(numeros[i]);
					telefone.setNumero(numeros[i]);
					System.out.println(tipos[i]);
					telefone.setTipo(tipos[i]);
					
					listaTelefones.add(telefone);
				}
				
				System.out.println(listaTelefones);
				System.out.println(usuario);
				usuario.setTelefones(listaTelefones);

				/*
				 * Telefone telefone1 = new Telefone(); Telefone telefone2 = new Telefone();
				 * List<Telefone> telefones = new ArrayList<Telefone>(); if
				 * (!request.getParameter("numero1").isEmpty() &&
				 * request.getParameter("numero1") != null && request.getParameter("ddd1") !=
				 * null) { telefone1.setDdd(Integer.parseInt(request.getParameter("ddd1")));
				 * telefone1.setNumero(request.getParameter("numero1"));
				 * telefone1.setTipo(request.getParameter("tipo1")); telefones.add(telefone1); }
				 * if (!request.getParameter("numero2").isEmpty() &&
				 * request.getParameter("numero2") != null && request.getParameter("ddd2") !=
				 * null) { telefone2.setDdd(Integer.parseInt(request.getParameter("ddd2")));
				 * telefone2.setNumero(request.getParameter("numero2"));
				 * telefone2.setTipo(request.getParameter("tipo2")); telefones.add(telefone2); }
				 */

				usuarioDao.abrirTransaction();
				usuarioDao.incluir(usuario);
				usuarioDao.fecharTransaction();

				System.out.println(usuario);

				request.getRequestDispatcher("listUser.jsp").forward(request, response);

			}
		}

	}

}
