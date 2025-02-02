package Controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controler", "/main", "/insert", "/select","/update","/excluir" })
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contacto = new JavaBeans();

	public Controler() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.print(action);
		if (action.equals("/main")) {
			Contacto(request, response);
		} else if (action.equals("/insert")) {
			NovoContacto(request, response);
		} else if (action.equals("/select")) {
			ListarContacto(request, response);
		}else if (action.equals("/update")) {
			atualizarContacto(request, response);
		}else if (action.equals("/excluir")) {
			excluir(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		
	}

	// Listar Contactos
	protected void Contacto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obter a lista de contatos do DAO
		List<JavaBeans> contactos = dao.listarContactos();

		// Adicionar a lista ao request
		request.setAttribute("contactos", contactos);

		// Encaminhar a requisição para a página agenda.jsp
		request.getRequestDispatcher("agenda.jsp").forward(request, response);
	}

	// Novo Contacto
	protected void NovoContacto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("agenda.jsp");
		// Teste de recepção dos dados do Formulário
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));
		// Setar as variar=veis JAvaBeans
		contacto.setNome(request.getParameter("nome"));
		contacto.setFone(request.getParameter("fone"));
		contacto.setEmail(request.getParameter("email"));

		dao.inserirContacto(contacto);
		// Redirecionar para o Main
		response.sendRedirect("main");
	}
	protected void ListarContacto(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String idconStr = request.getParameter("idcon"); // Obtém o parâmetro como String

	    if (idconStr != null && !idconStr.isEmpty()) { // Verifica se não é nulo ou vazio
	        try {
	            int idcon = Integer.parseInt(idconStr); // Converte para int
	            System.out.println(idcon);
	            contacto.setIdcon(idcon);
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	            System.out.println("Erro ao converter idcon para int: " + idconStr);
	        }
	    } else {
	        System.out.println("idcon não foi fornecido ou está vazio.");
	    }
	    dao.selecionarContacto(contacto);
	    // Setar os atributos ao formulário com o conteúdo do JavaBeans
	    request.setAttribute("idcon", contacto.getIdcon());
	    request.setAttribute("nome", contacto.getNome());
	    request.setAttribute("fone", contacto.getFone());
	    request.setAttribute("email", contacto.getEmail());
	    //Encaminhar para o documento editar.jsp
	    RequestDispatcher rd=request.getRequestDispatcher("Editar.jsp");
	    rd.forward(request, response);
	}
	protected void atualizarContacto(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // Obter os parâmetros da requisição
	    int idcon = Integer.parseInt(request.getParameter("idcon"));
	    String nome = request.getParameter("nome");
	    String fone = request.getParameter("fone");
	    String email = request.getParameter("email");

	    // Criar um objeto Contacto com os dados recebidos
	    JavaBeans contacto = new JavaBeans();
	    contacto.setIdcon(idcon);
	    contacto.setNome(nome);
	    contacto.setFone(fone);
	    contacto.setEmail(email);

	    // Atualizar o contacto no banco de dados
	    dao.atualizarContacto(contacto);

	    // Redirecionar ou enviar uma resposta após a atualização
	    response.sendRedirect("main"); // ou qualquer página de sucesso
	}

	protected void excluir(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // Obter o parâmetro da requisição
	    int idcon = Integer.parseInt(request.getParameter("idcon"));

	    // Criar um objeto Contacto com o id recebido
	    JavaBeans contacto = new JavaBeans();
	    contacto.setIdcon(idcon);

	    // Apagar o contacto no banco de dados
	    dao.apagarContacto(contacto);

	    // Redirecionar ou enviar uma resposta após a exclusão
	    response.sendRedirect("main"); // ou qualquer página de sucesso
	}

}
