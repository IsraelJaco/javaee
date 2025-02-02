package model;

public class text {
	public static void main(String[] args) {
	    DAO dao = new DAO();
	    Connection conn = dao.getConnection();
	    if (conn != null) {
	        System.out.println("Conexão com o banco de dados bem-sucedida!");
	    } else {
	        System.out.println("Falha ao conectar ao banco de dados.");
	    }
	}

}
