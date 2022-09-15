import java.util.ArrayList;
import java.util.Scanner;

public class Login {

	public void menu(Conta conta) {
	    Scanner scan = new Scanner(System.in);

		int controlador = -1;
		
		while(controlador != 0) {
			
			System.out.println("\nEscolha oque deseja fazer:");
			System.out.println("1 - Relizar o Login\n2 - Realizar Cadastro\n3 - Encerrar o programa");
			
			controlador = scan.nextInt();
			
			switch(controlador) {
			case 1:
				login(conta);
				break;
			case 2:
				cadastro(conta);
				break;
			case 3:
				System.out.println("Encerrando!");
				break;
			}
			
			
			
		}
	}

	public void cadastro(Conta conta) {
		Scanner scan = new Scanner(System.in);
		String nome, email, cargo;
		int senha, idProj, idAtiv;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Projetos> projetos = new ArrayList<Projetos>();
		ArrayList<Atividades> atividades = new ArrayList<Atividades>();
		Usuario user = null;
		
		System.out.println("\nInsira o nome para cadastro:");
		nome = scan.nextLine();
		System.out.println("\nInsira o email de cadastro:");
		email = scan.nextLine();
		System.out.println("\n Insira uma senha numerica:");
		senha = scan.nextInt();
		System.out.println("\n Escolha qual o cargo exercido :"
				+ "\nAG - Aluno de Graduação"
				+ "\nAM - Aluno de Mestrado"
				+ "\nAD - Aluno de Doutorado"
				+ "\nPR - Professor"
				+ "\nPES - Pesquisador"
				+ "\nPD - Profissional - Desenvolvedor"
				+ "\nPT - Profissional - Testador"
				+ "\nPA - Profissional - Analista"
				+ "\nTEC - Técnico");
		cargo = scan.nextLine();
		scan.nextLine();
		user = new Usuario(nome, email, cargo, senha);
		
		System.out.println("\nProjetos Involvido:");
		int controle = -1;
		while (controle != 2) {
			System.out.println("\nDigite:"
					+ "1 - Adcionar Projeto"
					+ "2 -Sair");
			controle = scan.nextInt();
			
			switch(controle) {
			case 2:
				break;
			case 1:
				System.out.println("\nInsira o Id do Projeto:");
				idProj = scan.nextInt();
				Projetos projeto = acharProjeto(idProj, conta);
			}
		}		
			
	}
	

	public Projetos acharProjeto(int idProj, Conta conta) {
		// TODO Auto-generated method stub
		return null;
	}


	public void login(Conta conta) {
		Scanner scan = new Scanner(System.in);
		
		String email;
		int senha;
		ArrayList<Usuario> usuario01 = new ArrayList<Usuario>();
		
		Usuario atual = null;
		
		System.out.println("\nEntre com o email:");
		email = scan.nextLine();
		
		System.out.println("\nEntre com a senha numerica:");
		senha = scan.nextInt();
		System.out.println("Enter para confirmar");
		scan.nextLine();
		
		for(Usuario usuario02 : conta.getUsuario()) {
			if(usuario02.getEmail().equals(atual) && usuario02.getSenha() == senha) {
				atual = usuario02;
				break;
			}
			else{
				System.out.println("Senha Incorreta");
				break;
			}			
		}
		if(atual != null) {
			menu(conta, atual);
		}
		else {
			System.out.println("\n Usuario não cadastrado");
		}
	}

	public void menu(Conta conta, Usuario atual) {
		// TODO Auto-generated method stub
		
	}

	public void menu(Usuario usuario, Conta conta) {
		Scanner scan = new Scanner(System.in);
		int controle = -1;
		
		while(controle != 16) {
			System.out.println("\nOque deseja fazer:");
			System.out.println("\n1 - Adicionar Projeto"
					+ "\n2 - Adicionar Atividade"
					+ "\n3 - Alterar Projeto"
					+ "\n4 - Alterar Atividade"
					+ "\n5 - Alterar Usuario"
					+ "\n6 - Remover Projeto"
					+ "\n7 - Remover Atividade"
					+ "\n8 - Remover Usuario"
					+ "\n9 - Ver Usuario"
					+ "\n10 - Ver Projeto"
					+ "\n11 - Ver Atividade"
					+ "\n12 - Alterar estado do Projeto"
					+ "\n13 - Ver estado do Projeto"
					+ "\n14 - Adicionar bolsa"
					+ "\n15 - Relatorios"
					+ "\n16 - Encerrar");
			
			controle = scan.nextInt();
			
			switch(controle) {
			case 16:
				break;
			case 1:
				adcProjeto(conta);
				break;
			case 2:
				adcAtividade(conta);
				break;
			case 3:
				altProjeto(conta);
				break;
			case 4:
				altAtividade(conta);
				break;
			case 5:
				altUsusario(conta);
				break;
			case 6:
				removerProjeto(conta);
				break;
			case 7:
				removerAtividade(conta);
				break;
			case 8:
				removerUsuario(conta);
				break;
			case 9:
				verUsuario(conta);
				break;
			case 10:
				verProjeto(conta);
				break;
			case 11:
				verAtividade(conta);
				break;
			case 12:
				alterarEstadoProjeto(conta);
				break;
			case 13:
				verEstadoProjeto(conta);
				break;
			case 14:
				adcBolsa(conta);
				break;
			case 15:
				relatorio(conta);
				break;				
			}
		}
	}

	public void adcAtividade(Conta conta) {
		Scanner scan = new Scanner(System.in);
		
		int id;
		String nome, descricao, tempoInicio, tempoFim, membros = null, emailCoordenador, tarefas;
		ArrayList<Usuario> participantes = new ArrayList<Usuario>();
		ArrayList<Atividades> atividades = new ArrayList<Atividades>();
				
		System.out.println("\nInsira o ID(numerico) da atividade:");
		id = scan.nextInt();
		System.out.println("\nInsira o nome da Atividade");
		nome = scan.nextLine();
		System.out.println("\nDescreva a Atividade:");
		descricao = scan.nextLine();
		System.out.println("\nInsira a data de inicio da Atividade:");
		tempoInicio = scan.nextLine();
		System.out.println("\nInsira a data de fechamento da Atividade:");
		tempoFim = scan.nextLine();
		System.out.println("\nInsira o email do Coordenador da Atividade");
		emailCoordenador = scan.nextLine();
		System.out.println("\nDeseja desiginar mebros para a Atividade?");
		int controlador = -1;
		if(controlador != 2) {
			System.out.println("\n1 - Sim "
					+ "\n2 - Não");
			controlador = scan.nextInt();
			while(controlador !=2) {
				System.out.println("\n1 - Adicionar membro"
						+ "\n2 - Parar de adicinoar menbros");
				controlador = scan.nextInt();
				scan.nextLine();
				
				switch(controlador) {
				case 1:
					System.out.println("\nInsira o email do Menbro:");
					membros = scan.nextLine();
					Usuario usuario = procurarUsuarios(membros, conta);
					if (usuario != null) {
						participantes.add(usuario);
						System.out.println("\nO Usuraio "+ usuario.getNome() +" foi designado para a atividade.");
						
					}else {
						System.out.println("\nEsse email não pertence a nenhum Usuario.");
						break;
					}
				case 2:
					break;
				}				
			}			
		}
		System.out.println("\nAdicione as tarefas a serem realizadas:");
		tarefas = scan.nextLine();
		Atividades atividade = new Atividades(id, nome,descricao,tempoInicio,tempoFim,membros,emailCoordenador, tarefas);
		atividades = conta.getAtividade();
		atividades.add(atividade);
		conta.setAtividade(atividades);
		
		System.out.println("\nA Atividade" + nome+" foi adicionada. ");		
	}

	private Usuario procurarUsuarios(String membros, Conta conta) {
		for(Usuario usuario : conta.getUsuario())
			if(usuario.getEmail().equals(membros)) {
				return usuario;
			}
		return  null;
	}

	public Usuario procurarUsuario(Usuario usuario2, Conta conta) {
		for(Usuario usuario : conta.getUsuario())
			if(usuario.getEmail().equals(usuario2)) {
				return usuario;
			}
		return  null;
	}

	public void altProjeto(Conta conta) {
		Scanner scan = new Scanner(System.in);
		
		
	}

	public void altAtividade(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void altUsusario(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void removerProjeto(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void removerAtividade(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void removerUsuario(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void verUsuario(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void verProjeto(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void verAtividade(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void alterarEstadoProjeto(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void verEstadoProjeto(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void adcBolsa(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void relatorio(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void adcProjeto(Conta conta) {
		Scanner scan = new Scanner(System.in);
		
		int id, idAtividade;
		String descricao, comecoProjeto, fimProjeto, emailCoordenador, membro;
		Usuario coordenador = null;
		double valorBolsa;
		ArrayList<Usuario> membros = new ArrayList<Usuario>();
		ArrayList<Projetos> projeto = new ArrayList<Projetos>();
		ArrayList<Atividades> atividade = new ArrayList<Atividades>();
		
		System.out.println("\nInsira o Id(numerico) para o projeto:");
		id = scan.nextInt();
		System.out.println("\nInsira a descrição do Projeto:");
		descricao = scan.nextLine();
		System.out.println("\nInsira a data de Inicio do Projeto:");
		comecoProjeto = scan.nextLine();
		System.out.println("\nInsira a data de Encerramento do Projeto:");
		fimProjeto = scan.nextLine();
		System.out.println("\nInsira o email do coordenador do Projeto:");
		emailCoordenador = scan.nextLine();
		
		for (Usuario usuario : conta.getUsuario()) {
			if(usuario.getEmail().equals(emailCoordenador)) {
				coordenador = usuario;
				if(usuario.getCargo() == "PR" | usuario.getCargo() == "PES") {
					coordenador = usuario;
				}else {
					System.out.println("\nO Usuario:" + usuario + " não pode ser Coordenador.");
				}
			}
		}
		if(coordenador == null) {
			System.out.println("\nEsse Usuario não esta cadastrado.");
			return;
		}
		System.out.println("\nDeseja adicionar membros?"
				+ "\n1 - Sim"
				+ "\n2 - Não");
		int controle =-1;
		controle = scan.nextInt();
		scan.nextLine();
		while(controle != 2) {
			System.out.println("\nDigite:"
					+ "\n1 - Adicionar um membro"
					+ "\n2 - Encerrar");
			controle = scan.nextInt();
			switch(controle) {
			case 1:
				System.out.println("\nEmail do Usuario:");
				membro = scan.nextLine();
				Usuario usuario = procurarUsuario(membro, conta);
				if(usuario != null) {
					membros.add(usuario);
					System.out.println("\nUsuario " + usuario.getNome() +" foi adicionado");
				}else {
					System.out.println("\nO email" + membro +" não pertence a nenhum Usuario cadastrado");
					break;
				}
			}
		}
		System.out.println("\nDeseja cadastrar uma Atividade?"
				+ "\n1 - Sim"
				+ "\n2 - Não");
		int controle01 = -1;
		controle01 = scan.nextInt();
		scan.nextLine();
		if(controle !=2) {
			while(controle != 2) {
				System.out.println("\n1 - Adicionar Atividade"
						+ "\n2 - Sair");
				switch(controle01) {
				case 1:
					System.out.println("\nInsira o ID(numerico) da Atividade;");
					idAtividade = scan.nextInt();
					Atividades atividade01 = procurarAtividade(idAtividade, conta);
					if(atividade01 != null) {
						atividade.add(atividade01);
						
					}
				}
			}
		}else {
			return;
		}
		System.out.println("\nInsira o Id(numerico) das atividades:");
		
		
		
	}

	private Atividades procurarAtividade(int idAtividade, Conta atual) {
		// TODO Auto-generated method stub
		return null;
	}
}
