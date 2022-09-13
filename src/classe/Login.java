package classe;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
    public ArrayList<Projeto> listaProjeto = new ArrayList<Projeto>();
    public ArrayList<Atividades> lsitaAtividades = new ArrayList<Atividades>();
    public Usuario usuarioOnline = new Usuario(null, null, null, 0);
    public Usuario usuarioEvalueate = new Usuario(null, null, null, 0);
    public Usuario adicionarUsuarioAdd = new Usuario(null, null, null, 0);

    public Login(){
        this.iniciarLogin();
    }
    // --- Template ONE
    private void iniciarLogin(){
        Scanner input = new Scanner(System.in);
        boolean controlador = true;
        while(controlador){
            System.out.println("\nOque deseja fazer:\n1 - Realizar o Login\n2 - Criar um Novo Usuário\n3 - Realizar uma Recuperação de Senha\n4 - Encerrar o programa");
            int option = input.nextInt();
            switch(option){           
                case 1:
                	loginUsuario();
                    break;                    
                case 2:
                	criar();
                    break;
                case 3:
                    recuperarSenha();
                    break;
                case 4:
                    controlador = false;
                    break;
                default:
                    System.out.print("Comando Invalido.");
                    break;                
            }
        }
    }
    	/*Criação*/
    private void criar(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nDigite o nome de cadastro do Novo usuário:");
        String nome = scan.nextLine();
        System.out.println("Digite o número indetificador de cadastro do Novo usuário:");
        int Id = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o cargo de cadastro do Novo usuário:");
        System.out.println("AG - Cargo => Aluno de Graduação");
        System.out.println("AD - Aluno de Mestrado");
        System.out.println("AD - Aluno de Doutorado");
        System.out.println("PR - Professor");
        System.out.println("PE - Pesquisador");
        System.out.println("PD - Profissional - Desenvolvedor");
        System.out.println("PT - Profissional - Testador");
        System.out.println("PA - Profissional - Analista");
        System.out.println("TEC - Técnico");
        String cargo = scan.next();
        System.out.println("Digite a senha de cadastro do Novo usuário:");
        scan.nextLine();
        String senha = scan.nextLine();
        Usuario novoUsuario = new Usuario(nome,cargo,senha,Id);
        listaUsuario.add(novoUsuario);
        novoUsuario.status();
        System.out.println("Usuario "+novoUsuario.getNome()+" foi adicionado.");

    }
    	/*Login*/
    private void loginUsuario(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o Id para login:");
        int Id = input.nextInt();
        input.nextLine();
        System.out.println("Digite a senha para login:");
        String senha = input.nextLine();
        input.nextLine();
        int controle = 0;
        for(Usuario usuario : listaUsuario){
        	
            if(listaUsuario.isEmpty()){
                controle = 1;
            }
            else{
                if(usuario.getId() == Id && usuario.getSenha().equals(senha)){
                    usuarioOnline = usuario;
                    controle = 2;
                    break;
                }
            }
        }
        switch(controle){
            case 0:
                System.out.println("Usuario invalido.");
                break;
            case 1:
                System.out.println("Usuarios não cadastrados.");
                break;
            case 2:
                if(usuarioOnline.getCargo() == "PR" || usuarioOnline.getCargo() == "PE"){
                    admMenu();
                }
                else{
                    menuGeral();
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }
    	/*Recuperar Senha*/
    private void recuperarSenha(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nDigite o email para recuperação da senha:");
        int Id = input.nextInt();
        Usuario procuraUsuario = new Usuario(null, null, null, 0);
        int controlador = 0;
        for(Usuario usuario : listaUsuario){
            if(listaUsuario.isEmpty()){
                controlador = 1;
            }
            else{
                if(usuario.getId() == Id){
                    procuraUsuario = usuario;
                    controlador = 2;
                    break;
                }
            }
        }
        switch(controlador){
            case 0:
                System.out.println("Usuario invalido.");
                break;
            case 1:
                System.out.println("Usuarios não cadastrados.");
                break;
            case 2:
                System.out.println("Digite a nova senha:");
                String senha = input.nextLine();
                procuraUsuario.setSenha(senha);
                System.out.println("Senha alterada com sucesso.");
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }

    }

    /*Menu Geral*/
    private void menuGeral(){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n1 - Perfil\n2 - Projetos\n3 - Atividades\n4 - Área de Relatórios\\n5 - Encerrar seção");
            int option = input.nextInt();
            switch(option){                
                case 1:
                    profile();  
                    break;
                case 2:
                    projetosUsuario();  
                    break;
                case 3:
                    atividadesUsuario();   
                    break;
                case 4:
                    relatoriosUsuario();      
                    break;
                case 5:
                    control = false;
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }
    	/*Menu ADM*/
    private void admMenu(){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n1 - Área de Atividades\n2 - Perfil\n3 - Projetos\n4 - Atividades\n5 - Área de Relatórios\n6 - Área de Usuarios\n7 - Área de Projetos\n8 - Finalizar");
            int option = input.nextInt();
            switch(option){
                case 1:
                	admActivities();
                    break;
                case 2:
                    profile();   
                    break;
                case 3:
                    projetosUsuario();    
                    break;                                       
                case 4:
                    atividadesUsuario();    
                    break;
                case 5:
                    relatoriosUsuario();      
                    break;
                case 6:
                    admUsuario();      
                    break;
                case 7:
                    admProjeto();     
                    break;
                case 8:                   
                    control = false;
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    private void profile(){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n1 - Retornar ao Menu Principal\n2 - Visualizar informações Pessoais\n3 - Editar informações Pessoais");
            int option = input.nextInt();
            switch(option){
                case 1:
                    control = false;
                    break;
                case 2:
                    usuarioOnline.userShow(listaProjeto);
                    break;
                case 3:
                    editorUsuario();
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    /*Editar Usuario*/
    public void editorUsuario(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a Opção escolhida:\n[1] - Editar Email\n[2] - Editar Senha");
        int option = input.nextInt();
        switch(option){
            case 1:
                System.out.println("Digite o novo numero de indetificação(Id):");
                input.nextLine();
                int Id = input.nextInt();
                usuarioOnline.setId(Id);
                System.out.println("Numero de indetificação(Id) alterado com sucesso.");
                break;
            case 2:
                System.out.println("Digite a nova senha:");
                input.nextLine();
                String password = input.nextLine();
                usuarioOnline.setSenha(password);
                System.out.println("Senha alterada com sucesso.");
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    /* ______________ Projetos ______________ */
    private void projetosUsuario(){
        usuarioOnline.projetos(listaProjeto);
    }

    /* _____________ Atividades _____________ */
    private void atividadesUsuario(){
        usuarioOnline.atividades(listaProjeto);
    }

    /* Relatorios */
    private void relatoriosUsuario(){
        Scanner input = new Scanner(System.in);
        boolean controlador = true;
        while(controlador){
            System.out.println("Digite a Opção escolhida:\n[0] - Retornar ao Menu Principal\n[1] - Relatório de Projetos\n[2] - Relatório de Atividades\n[3] - Relatório de Projetos");
            int option = input.nextInt();
            switch(option){
                case 0:
                    controlador = false;
                    break;
                case 1:
                    System.out.println("\nRelatório de Projetos");
                    System.out.println("Quantidade de Projetos na Universidade: "+listaProjeto.size());
                    int contador01 = 0;int contador02 = 0; int contador03 = 0; int contador04 = 0;
                    for(Projeto proj:listaProjeto){
                        if(proj.getStatus() == "Semdno criados"){
                            contador01++;
                        }
                        else if(proj.getStatus() == "Iniciados"){
                            contador02++;
                        }
                        else if(proj.getStatus() == "Em andamento"){
                            contador03++;
                        }
                        else if(proj.getStatus() == "Concluídos"){
                            contador04++;
                        }
                    }
                    System.out.println("     Sendo criados: "+contador01+"\n     Iniciados: "+contador02+"\n     Em andamento: "+contador03+"\n     Concluídos: "+contador04+"\n");
                    break;
                case 2:
                    System.out.println("\nRelatório de Atividades");
                    int contador = 0;
                    for(Projeto proj:listaProjeto){
                        contador += proj.getArrayListaAtividades().length;
                    }
                    System.out.println("Quantidade de Atividades na Unidade Acadêmica: "+contador+"\n");
                    break;
                case 3:
                    System.out.println("Informe o Projeto procurado:");
                    input.nextLine();
                    String idProject = input.nextLine();
                    int c = 0;
                    Projeto PROJECT = new Projeto();
                    for(Projeto project : listaProjeto){
                        if(listaProjeto.isEmpty()){
                            c = 1;
                        }
                        if(project.getID().equals(idProject)){
                            PROJECT = project;
                            c = 2;
                        }
                    }
                    if(c == 0){
                        System.out.println("Projeto não encontrado.");
                    }
                    else if(c==1){
                        System.out.println("Não existe projetos cadastrados.");
                    }
                    else if(c==2){
                        PROJECT.consultarProjetos();
                    }
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    /* __________ Área de Usuário __________ */
    private void admUsuario(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do usuario:");
        String name = input.nextLine();
        Usuario person = new Usuario(null, null, null, 0);
        boolean c = false;
        for(Usuario usuario:listaUsuario){
            if(usuario.getNome().equals(name)){
                person = usuario;
                c = true;
                break;
            }
        }
        if(c){
            boolean control = true;
            while(control){
                System.out.println("Digite a Opção escolhida:\n[0] - Retornar ao Menu Principal\n[1] - Consulta por Usuários\n[2] - Gerenciamento da Bolsa");
                int option = input.nextInt();
                switch(option){
                    case 0:
                        control = false;
                        break;
                    case 1:
                        person.userShow(listaProjeto);
                        break;
                    case 2:
                        person.tempo();
                        break;
                    default:
                        System.out.println("Comando Invalido.");
                        break;
                }
            }
        }
        else{
            System.out.println("Usuario não encontrado.");
        }
    }
  
    /* Projetos adm */
    private void admProjeto(){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n1 - Criar Projeto\n2 - Remover Informações de Projeto\n4 - Editar Informações de Projeto\n5 - Alterar Status de Projeto\n6 - Consulta de Projetos\n7 - Retornar ao Menu Principal");
            int option = input.nextInt();
            switch(option){
                case 1:
                	Projeto project = new Projeto();     
                    listaProjeto.add(project);
                    break;
                case 2:
                    removerProjetos();    
                    break; 
                case 3:
                    editarProjetos();   
                    break; 
                case 4:
                   editarEstado();    
                    break;
                case 5:                   
                    consultarProjetos();    
                    break;
                case 6:                    
                    control = false;
                    break;

                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    private void removerProjetos(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a Opção escolhida:\n1 - Remover usuario do projeto\n2 - Remover atividade do projeto");
        int option = input.nextInt();
        switch(option){
            case 1:
                System.out.println("Informe o Projeto para remover:");
                input.nextLine();
                String idProject = input.nextLine();
                int controlador = 0;
                Projeto Projeto = new Projeto();
                for(Projeto projeto : listaProjeto){
                    if(listaProjeto.isEmpty()){
                        controlador = 1;
                    }
                    if(projeto.getID().equals(idProject)){
                        Projeto = projeto;
                        controlador = 2;
                    
                    }
                }
                if(controlador == 0){
                    System.out.println("Dados Incorretos");
                }
                else if(controlador == 1){
                    System.out.println("Não foram criados Projetos");
                }
                else if(controlador ==2){
                    if(usuarioOnline == Projeto.getCoordenador()){
                        Projeto.removerUsuario();
                    }
                    else{
                        System.out.println("Você não é Coordenador deste Projeto, você não tem permissão para alterar esse projeto.");
                    }
                }
                else{
                    System.out.println("Comando Incorreto.");
                }
                break;
            case 2:
                System.out.println("Qual Projeto deseja remover:");
                input.nextLine();
                String id = input.nextLine();
                int c = 0;
                Projeto Proj = new Projeto();
                for(Projeto projeto : listaProjeto){
                    if(listaProjeto.isEmpty()){
                        c = 1;
                    }
                    if(projeto.getID().equals(id)){
                        Proj = projeto;
                        c = 2;
                    
                    }
                }
                if(c==0){
                    System.out.println("Dados Incorretos");
                }
                else if(c==1){
                    System.out.println("Não foram criados Projetos");
                }
                else if(c==2){
                    if(usuarioOnline == Proj.getCoordenador()){
                        Proj.removerAtividade();
                    }
                    else{
                        System.out.println("Você não é Coordenador deste Projeto, você não tem permissão para alterar esse projeto.");
                    }
                }
                else{
                    System.out.println("Comando Incorreto.");
                }
                break;
            default:
                System.out.println("Comando Incorreto.");
                break;
        }
    }
  
    private void editarProjetos(){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual Projeto deseja adicionar informações:");
        String idProjeto = input.nextLine();
        int controlador = 0;
        Projeto Projeto = new Projeto();
        for(Projeto projeto : listaProjeto){
            if(listaProjeto.isEmpty()){
                controlador = 1;
            }
            if(projeto.getID().equals(idProjeto)){
                Projeto = projeto;
                controlador = 2;

            }
        }
        switch(controlador){
            case 0:
                System.out.println("Dados Incorretos");
                break;
            case 1:
                System.out.println("Não foram criados Projetos");
                break;
            case 2:
                if(usuarioOnline == Projeto.getCoordenador()){
                    Projeto.editarProjeto(listaUsuario);
                }
                else{
                    System.out.println("Você não é Coordenador deste Projeto, você não tem permissão para alterar esse projeto");
                }
                break;
            default:
                System.out.println("Comando Incorreto.");
                break;
        }
    }

    private void editarEstado(){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual Projeto para adicionar:");
        String idProjeto = input.nextLine();
        int control = 0;
        Projeto Projeto = new Projeto();
        for(Projeto projeto : listaProjeto){
            if(listaProjeto.isEmpty()){
                control = 1;
            }
            if(projeto.getID().equals(idProjeto)){
                Projeto = projeto;
                control = 2;

            }
        }
        switch(control){
            case 0:
                System.out.println("Dados Invalidos");
                break;
            case 1:
                System.out.println("Não existe Projetos criados");
                break;
            case 2:
                if(usuarioOnline == Projeto.getCoordenador()){
                    Projeto.getStatus();
                    System.out.println("Status do Projeto alterado com sucesso.");
                }
                else{
                    System.out.println("Você não é Coordenador deste Projeto, você não tem permissão para alterar esse projeto");
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    private void consultarProjetos(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto procurado:");
        String nomeProjeto = input.nextLine();
        int controlador = 0;
        Projeto Projeto = new Projeto();
        for(Projeto projeto : listaProjeto){
            if(listaProjeto.isEmpty()){
                controlador = 1;
            }
            if(projeto.getID().equals(nomeProjeto)){
                Projeto = projeto;
                controlador = 2;

            }
        }
        switch(controlador){
            case 0:
                System.out.println("Dados Invalidos");
                break;
            case 1:
                System.out.println("Não existe Projetos criados");
                break;
            case 2:
                if(usuarioOnline == Projeto.getCoordenador()){
                    Projeto.consultarProjetos();
                }
                else{
                    System.out.println("Você não é Coordenador deste Projeto, você não tem permissão para criar atividades nesse projeto");
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    /* _________ Área de Atividades _________ */
    private void admActivities(){
        Scanner input = new Scanner(System.in);
        boolean controle = true;
        while(controle){
            System.out.println("Digite a Opção escolhida:\n1 - Criar Atividade\n2 - Remover Informações de Atividades\n3 - Editar Informações de Atividades\n4 - Consulta por Atividades\n5- Retornar ao Menu Principal");
            int opcao = input.nextInt();
            switch(opcao){
                
                case 1:
                    criarAtividade();      
                    break;
                case 2:
                    removerAtividade();      
                    break;
                case 3:
                    editarAtividade();
                    break;
                case 4:
                    consultarAtividade();
                    break;
                case 5:
                    controle = false;
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    private void criarAtividade(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto para adicionar:");
        String nomeProjeto = input.nextLine();
        int controlador = 0;
        Projeto Projeto = new Projeto();
        for(Projeto projeto : listaProjeto){
            if(listaProjeto.isEmpty()){
                controlador = 1;
            }
            if(projeto.getID().equals(nomeProjeto)){
                Projeto = projeto;
                controlador = 2;

            }
        }
        switch(controlador){
            case 0:
                System.out.println("Dados Invalidos");
                break;
            case 1:
                System.out.println("Não existe Projetos criados");
                break;
            case 2:
                if(usuarioOnline == Projeto.getCoordenador()){
                    Atividades atividades = new Atividades(listaUsuario);
                    Projeto.adiconarAtividades(atividades);
                }
                else{
                    System.out.println("Você não é Coordenador deste Projeto, ou seja, não pode criar atividades desse projeto");
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    private void removerAtividade(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto para adicionar:");
        String idProjeto = input.nextLine();
        int controle = 0;
        Projeto Projeto = new Projeto();
        for(Projeto projeto : listaProjeto){
            if(listaProjeto.isEmpty()){
                controle = 1;
            }
            if(projeto.getID().equals(idProjeto)){
                Projeto = projeto;
                controle = 2;

            }
        }
        switch(controle){
            case 0:
                System.out.println("Dados Incorretos");
                break;
            case 1:
                System.out.println("Não foram criados Projetos");
                break;
            case 2:
                System.out.println("Digite o nome da atividade que deseja modificar:");
                String idAct = input.nextLine();
                Atividades act = new Atividades(null);
                boolean c = false;
                for(Atividades activities : Projeto.getArrayListaAtividades()){
                    if(activities.getIdAtividade().equals(idAct)){
                        act = activities;
                        c = true;
                        break;
                    }
                }
                if(c){
                    if(usuarioOnline == Projeto.getCoordenador()){
                        act.removerInformacao();
                    }
                    else{
                        System.out.println("Você não é coordenador desse Projeto");
                    }
                }
                else{
                    System.out.println("A Atividade não foi encontrada.");
                }
                break;
            default:
                System.out.println("Comando Incorreto.");
                break;
        }
    }

    private void editarAtividade(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto a ser adicionar:");
        String idProject = input.nextLine();
        int controle = 0;
        Projeto Projetos = new Projeto();
        for(Projeto projeto : listaProjeto){
            if(listaProjeto.isEmpty()){
                controle = 1;
            }
            if(projeto.getID().equals(idProject)){
                Projetos = projeto;
                controle = 2;

            }
        }
        switch(controle){
            case 0:
                System.out.println("Dados Incorretos");
                break;
            case 1:
                System.out.println("Não foram criados Projetos");
                break;
            case 2:
                System.out.println("Digite o nome da atividade a se editar:");
                String idAtividade = input.nextLine();
                Atividades act = new Atividades(listaUsuario);
                boolean c = false;
                for(Atividades activities : Projetos.getArrayListaAtividades()){
                    if(activities.getIdAtividade().equals(idAtividade)){
                        act = activities;
                        c = true;
                        break;
                    }
                }
                if(c){
                    if(usuarioOnline == Projetos.getCoordenador()){
                        act.editarInformacao(listaUsuario);
                    }
                    else{
                        System.out.println("Você não é coordenador desse Projeto");
                    }
                }
                else{
                    System.out.println("Atividade não encontrada.");
                }
                break;
            default:
                System.out.println("Comando Incorreto.");
                break;
        }
    }

    private void consultarAtividade(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto para adicionar:");
        String idProject = input.nextLine();
        int controle = 0;
        Projeto Projetos = new Projeto();
        for(Projeto projeto : listaProjeto){
            if(listaProjeto.isEmpty()){
                controle = 1;
            }
            if(projeto.getID().equals(idProject)){
                Projetos = projeto;
                controle = 2;

            }
        }
        switch(controle){
            case 0:
                System.out.println("Dados Invalidos");
                break;
            case 1:
                System.out.println("Não existe Projetos criados");
                break;
            case 2:
                if(usuarioOnline == Projetos.getCoordenador()){
                    Projetos.consultarAtividade();
                }
                else{
                    System.out.println("Você não é Coordenador deste Projeto, você não tem permissão para criar atividades nesse projeto");
                }
                break;
            default:
                System.out.println("Comando Incorreto.");
                break;
        }
    }

}
