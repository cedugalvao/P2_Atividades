import java.util.ArrayList;

public class Conta {
	private ArrayList<Usuario> usuario;
	private ArrayList<Projetos> projeto;
	private ArrayList<Atividades> atividade;
	
		/*	Construtor	*/
	public Conta() {
		this.usuario = new ArrayList<Usuario>();
		this.projeto = new ArrayList<Projetos>();
		this.atividade = new ArrayList<Atividades>();
	}
	/**
	 * @return the usuario
	 */
	public ArrayList<Usuario> getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(ArrayList<Usuario> usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the projeto
	 */
	public ArrayList<Projetos> getProjeto() {
		return projeto;
	}
	/**
	 * @param projeto the projeto to set
	 */
	public void setProjeto(ArrayList<Projetos> projeto) {
		this.projeto = projeto;
	}
	/**
	 * @return the atividade
	 */
	public ArrayList<Atividades> getAtividade() {
		return atividade;
	}
	/**
	 * @param atividade the atividade to set
	 */
	public void setAtividade(ArrayList<Atividades> atividade) {
		this.atividade = atividade;
	}
	
}
