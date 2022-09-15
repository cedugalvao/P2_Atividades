import java.util.ArrayList;

public class Usuario {
	private String nome;
	private String email;
	private String cargo;
	private int senha;
	private ArrayList<Projetos> projetos;
	private ArrayList<Atividades> atividades;
	
	/*Construtor*/
	public Usuario(String nome, String email, String cargo, int senha){
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.atividades = new ArrayList<Atividades>();
		this.projetos = new ArrayList<Projetos>();
	}
	
	
	/*Getters e Setters*/

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public ArrayList<Projetos> getProjetos() {
		return projetos;
	}


	public void setProjetos(ArrayList<Projetos> projetos) {
		this.projetos = projetos;
	}


	public ArrayList<Atividades> getAtividades() {
		return atividades;
	}


	public void setAtividades(ArrayList<Atividades> atividades) {
		this.atividades = atividades;
	}
	public String toString() {
		return "Nome:	" +this.getNome()+"\n"
				+ "Projetos atuais:		" + getProjetos()+"\n"
				+ "Atividades Atuais:	" + getAtividades();
	}




	
	
	
}
