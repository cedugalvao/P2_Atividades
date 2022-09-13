package classe;

import java.util.ArrayList;

public class Usuario {

	private String cargo;
	private String nome;
	private String senha;
	private int Id;
	private ArrayList<Projeto> projetos = new ArrayList<>();
	private ArrayList<Atividades> atividade = new ArrayList<>();
	private ArrayList<Bolsas> bolsas = new ArrayList<>();

		/* Getters e Setters*/
	public void status() {
		System.out.println(cargo);
		System.out.println(Id);
		System.out.println(nome);
		System.out.println(senha);
		
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public ArrayList<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(ArrayList<Projeto> projetos) {
		this.projetos = projetos;
	}
	public ArrayList<Atividades> getAtividade() {
		return atividade;
	}

	public void setAtividade(ArrayList<Atividades> atividade) {
		this.atividade = atividade;
	}

	public ArrayList<Bolsas> getBolsas() {
		return bolsas;
	}

	public void setBolsas(ArrayList<Bolsas> bolsas) {
		this.bolsas = bolsas;
	}
	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}
	
		/* Construtor */
    public Usuario (String nome, String senha, String cargo, int Id){
        this.nome = nome;
        this.cargo = cargo;
        this.senha = senha;
        this.Id = Id;
    }
    
    	/* Mostrar Usuário */
    public void userShow(ArrayList<Projeto> projectList){
        System.out.println("\n Sobre o Usuario:");
        System.out.println("Nome : " + this.nome);
        if(this.cargo == "AG"){System.out.println("Cargo => Aluno de Graduação");}
        else if(this.cargo == "AM"){System.out.println("Cargo => Aluno de Mestrado");}
        else if(this.cargo == "AD"){System.out.println("Cargo => Aluno de Doutorado");}
        else if(this.cargo =="PR"){System.out.println("Cargo => Professor");}
        else if(this.cargo == "PE"){System.out.println("Cargo => Pesquisador");}
        else if(this.cargo == "PD"){System.out.println("Cargo => Profissional - Desenvolvedor");}
        else if(this.cargo == "PT"){System.out.println("Cargo => Profissional - Testador");}
        else if(this.cargo == "PA"){System.out.println("Cargo => Profissional - Analista");}
        else if(this.cargo == "TEC"){System.out.println("Cargo => Técnico");}
        
        	/* Projetos do Usuário */
        System.out.println("Projetos:");
        for(Projeto proj:projectList){
            if(proj.getProjetos(this.nome)){
                System.out.println("    - "+proj.getID());
            }
        }
        	/* Atividades do Usuário */
        System.out.println("Atividades:");
        for(Projeto proj:projectList){
            if(proj.getProjetos(this.nome)){
                for(Atividades act:proj.getArrayListaAtividades()){
                    if(act.getAtividades(this.nome)){
                        System.out.println("    - [Atividades de Projeto] "+act.getIdAtividade());
                    }
                }
            }
            else{
                for(Atividades act:proj.getArrayListaAtividades()){
                    if(act.getAtividades(this.nome)){
                        System.out.println("     - [Atividade de Projeto Externo] "+act.getIdAtividade());
                    }
                }
            }
        }
    }
    
    	/*Projetos*/
    public void projetos(ArrayList<Projeto> listaProjeto){
        System.out.println("\nProjetos:");
        for(Projeto proj:listaProjeto){
            if(proj.getProjetos(this.nome)){
                System.out.println("    - "+proj.getID());
            }
        }
    }

	public void atividades(ArrayList<Projeto> listaProjeto) {
		// TODO Auto-generated method stub
		
	}

	public void tempo() {
		// TODO Auto-generated method stub
		
	}
}
