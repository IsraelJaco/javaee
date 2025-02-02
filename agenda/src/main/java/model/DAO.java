package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

public class DAO {
	// Dados de conexão com o banco de dados
	private static final String URL = "jdbc:mysql://localhost:3306/dbagenda";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	// Método para estabelecer a conexão
	public Connection getConnection() {
		Connection connection = null;
		try {
			// Carregar o driver JDBC do MySQL
			Class.forName("com.mysql.jdbc.Driver");

			// Estabelecer conexão
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC não encontrado: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		}
		return connection;
	}

	// Método para inserir um contato
	public void inserirContacto(JavaBeans contacto) {
		// Query SQL para inserção
		String sql = "INSERT INTO contactos (nome, fone, email) VALUES (?, ?, ?)";

		// Tentar estabelecer conexão e inserir os dados
		try (Connection conn = getConnection()) {
			if (conn == null) {
				System.out.println("Erro: Conexão com o banco de dados não foi estabelecida.");
				return;
			}

			// Preparar a query
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				// Preencher os parâmetros
				stmt.setString(1, contacto.getNome());
				stmt.setString(2, contacto.getFone());
				stmt.setString(3, contacto.getEmail());

				// Executar a query
				stmt.executeUpdate();
				System.out.println("Contato inserido com sucesso!");
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir contato: " + e.getMessage());
		}
	}

	public List<JavaBeans> listarContactos() {
		List<JavaBeans> contactos = new ArrayList<>();
		String sql = "SELECT * FROM contactos";

		try (Connection conn = getConnection()) {
			if (conn == null) {
				System.out.println("Erro: Conexão com o banco de dados não foi estabelecida.");
				return contactos;
			}
			System.out.println("Conexão estabelecida com sucesso.");

			try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					int idcon = rs.getInt("idcon");
					String nome = rs.getString("nome");
					String fone = rs.getString("fone");
					String email = rs.getString("email");

					System.out.println("Contato encontrado: "+idcon+","+ nome + ", " + fone + ", " + email);

					JavaBeans c = new JavaBeans();
					c.setIdcon(idcon);
					c.setNome(nome);
					c.setFone(fone);
					c.setEmail(email);

					contactos.add(c);
				}
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar os contatos: " + e.getMessage());
		}

		return contactos;
	}

	public void selecionarContacto(JavaBeans Contacto) {
		String sql = "select * from contactos where idcon=?";
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, Contacto.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Contacto.setIdcon(rs.getInt(1));
				Contacto.setNome(rs.getString(2));
				Contacto.setFone(rs.getString(3));
				Contacto.setEmail(rs.getString(4));
				con.close();

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Falha ao se conectar com o banco" + e);
		}

	}
	public void atualizarContacto(JavaBeans Contacto) {
	    String sql = "update contactos set nome=?, fone=?, email=? where idcon=?";
	    try {
	        Connection con = getConnection();
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, Contacto.getNome());
	        pst.setString(2, Contacto.getFone());
	        pst.setString(3, Contacto.getEmail());
	        pst.setInt(4, Contacto.getIdcon());
	        pst.executeUpdate();
	        con.close();
	    } catch (Exception e) {
	        // TODO: handle exception
	        System.out.println("Falha ao atualizar o banco de dados: " + e);
	    }
	}
	public void apagarContacto(JavaBeans Contacto) {
	    String sql = "delete from contactos where idcon=?";
	    try {
	        Connection con = getConnection();
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setInt(1, Contacto.getIdcon());
	        pst.executeUpdate();
	        con.close();
	    } catch (Exception e) {
	        // TODO: handle exception
	        System.out.println("Falha ao apagar o contato no banco de dados: " + e);
	    }
	}


}
