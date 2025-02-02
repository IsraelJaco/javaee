package model;

public class JavaBeans {
	private int idcon;
	private String nome;
	private String fone;
	private String email;
	//
	
	public int getIdcon() {
		return idcon;
	}
	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JavaBeans(int idcon, String nome, String fone, String email) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}
	public JavaBeans(String nome2, String fone2, String email2) {
		// TODO Auto-generated constructor stub
	}
	public void setIdcon(int idcon) {
		this.idcon = idcon;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
