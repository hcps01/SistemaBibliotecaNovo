package controle;

import visao.*;
import modelo.*;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class BibliotecaManager {
    
    String opc;
    int opcInt;
    private int diasEmprestimo; // Adicione esta linha

    private List<Usuario> listaUsuarios = new ArrayList<>();

    
    Scanner scanner = new Scanner(System.in);
    
    ArrayList<Aluno> listaAluno = new ArrayList<>();
    ArrayList<Professor> listaProfessor = new ArrayList<>();
    ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
    ArrayList<Livro> listaLivro = new ArrayList<>();
    ArrayList<Usuario> listaReserva = new ArrayList<>();
    ArrayList<Usuario> listaNomeUsuario = new ArrayList<>();
    ArrayList<Administrador> listaAdministrador = new ArrayList<>();

    
    // Constutor da classe
    
     public BibliotecaManager() { 
    
     TelaLogin telaLogin = new TelaLogin(); //Inicaliza a classe TelaLogin, a primeira tela
    
     telaLogin.getBotaoLogin().addActionListener(e -> {
    	
        String matricula = telaLogin.getCampoUsuario().getText(); // Variáveis recebem as Strings de getCampoUsuario ou getCampoSenha
        String senha = telaLogin.getCampoSenha().getText();
        
        Usuario usuarioLogado = autenticar(matricula, senha); // Chama o método de autenticação. Instancia e recebe os valores do parâmetro

         if(usuarioLogado != null){ //Vefifica se a instância é nula 
        	 
        	 if (usuarioLogado instanceof Administrador) {
                 exibirFuncaoAdministrador();
             } else if (usuarioLogado instanceof Funcionario) {
                 exibirFuncaoFuncionario();
             } else if (usuarioLogado instanceof Professor) {
                 exibirFuncaoUsuarioComum();
             } else if (usuarioLogado instanceof Aluno) {
                 exibirFuncaoUsuarioComum();
             }
     
             }else {
        	    JOptionPane.showMessageDialog(null, "Login inválido. Tente novamente.");
         }
       });
     }
    
     
    
     public Usuario autenticar(String matricula, String senha) { // Para cada instancia de Usuario verifica se o nome e senha inseridos equivale a alguma instancia da lista.	    	
            for (Usuario u : listaUsuarios) { 
                if (u.getNomeUsuario().equals(matricula) && u.getSenha().equals(senha)) { 
                return u;
                }
            }
        
        return null;
             
     }
     

     public void aceitarDevolucao(){
        Livro livro = new Livro();

        if (listaReserva.isEmpty()) {
           System.out.println("Não há nenhuma reserva no momento.");
           return;
        }

        System.out.println("Aceitar devolução? (s/n)");
        opc = scanner.nextLine();

        if (opc.equalsIgnoreCase("s")) {
           Usuario usuario = listaReserva.remove(0); // Remove o primeiro usuário da lista
           livro.setDevolvido(true);
           System.out.println("Devolução confirmada.");
        }
      }


     public boolean confirmarReserva(int diasEmprestimo) {
     LocalDate dataReservaInicio = LocalDate.now();
     LocalDate dataReservaFim = LocalDate.now().plus(3, ChronoUnit.DAYS);  // Prazo para confirmação
     LocalDate dataAtual = LocalDate.now();
    
     System.out.println("Confirmar Empréstimo (s/n): ");
     String opc = scanner.nextLine();

    // Confirmação do empréstimo
     if (opc.equalsIgnoreCase("s")) {
        if (!dataAtual.isBefore(dataReservaInicio) && !dataAtual.isAfter(dataReservaFim)) {
            // O prazo para o empréstimo está dentro do intervalo
            LocalDate dataDevolucao = LocalDate.now().plusDays(diasEmprestimo);  // Período de empréstimo

            System.out.println("Empréstimo Confirmado. Data de devolução: " + dataDevolucao);
            return true;
        } else {
            // Se o prazo para a reserva expirar
            System.out.println("Prazo para confirmação de empréstimo expirado.");
            Usuario usuario = listaReserva.remove(0);  // Remove o usuário da vez da lista de reservas
            System.out.println("Usuário removido da lista de reservas.");
            return false;
        }
        } else {
        System.out.println("Empréstimo não confirmado.");
        return false;
       }
     }


     public void exibirFuncaoUsuarioComum(){
	 JFrame telaUsuarioComum = new JFrame();

     System.out.println(" ");
     System.out.println(" ");
     switch(opcInt){
        case 1 :
            System.out.println("Digite o título do livro que deseja buscar:");
            String tituloBusca = scanner.next();  // Pega o título do livro que será buscado
            scanner.nextLine();  
            buscarLivroWrapper(tituloBusca);
            
            break;
        case 2 :
            reservarLivro();
            break;
  
       }      
     }

     public void exibirFuncaoFuncionario() {
     System.out.println(" ");
     System.out.println(" ");
     switch(opcInt) {
        case 1:
            System.out.println("Digite o título do livro que deseja buscar:");
            String tituloBusca = scanner.next(); // Pega o título do livro que será buscado
            scanner.nextLine();  
            buscarLivroWrapper(tituloBusca);
            break;
        case 2:
            reservarLivro();
            break;
        case 3: 
            cadastrarUsuario();
            break;
        case 4:
            cadastrarLivro();
            break;
        case 5:
            aceitarDevolucao();
            break;
        case 6:
            System.out.println("Deseja confirmar o empréstimo? (s/n)");
        String opc = scanner.nextLine();  // Captura a resposta do usuário
        if (opc.equalsIgnoreCase("s")) {  // Verifica se o usuário deseja confirmar
        boolean sucesso = confirmarReserva(diasEmprestimo);  // Usa o valor já definido de diasEmprestimo
          if (sucesso) {
            System.out.println("Empréstimo confirmado com sucesso.");
        } else {
            System.out.println("Falha ao confirmar o empréstimo.");
        }
        } else {
        System.out.println("Empréstimo não confirmado.");
        }
        break;   
        }   // Chama um método que lida com o booleano
            ;
     }

      public void exibirFuncaoAdministrador(){
      System.out.println(" ");
      System.out.println(" ");
      switch(opcInt){
        case 1 :
            System.out.println("Digite o título do livro que deseja buscar:");
            String tituloBusca = scanner.next();  // Pega o título do livro que será buscado
            buscarLivroWrapper(tituloBusca);
            
            break;
        case 2 :
            reservarLivro();
            break;
        case 3 : 
            adminCadastrarUsuario();
            break;
        case 4 :
        	cadastrarLivro();
             break;
        case 5 :
            aceitarDevolucao();
            break;
        case 6:
            System.out.println("Deseja confirmar o empréstimo? (s/n)");
            String opc = scanner.nextLine();  // Captura a resposta do usuário

        if (opc.equalsIgnoreCase("s")) {  // Verifica se o usuário deseja confirmar
    	
           boolean sucesso = confirmarReserva(diasEmprestimo);  // Usa o valor já definido de diasEmprestimo
           
           if (sucesso) {
        	   
            System.out.println("Empréstimo confirmado com sucesso.");
           } else {
            System.out.println("Falha ao confirmar o empréstimo.");
           }
           } else {
           System.out.println("Empréstimo não confirmado.");
           }
            break;   
           } 
     }


     public void cadastrarUsuario(){
     switch(opcInt){
        case 1 : 
            cadastrarAluno();
            break;
        case 2 : 
            cadastrarProfessor();
           break;
      }
    }


     public void cadastrarAluno(){
     Aluno aluno = new Aluno();
     System.out.println("Informe os dados do aluno");
     System.out.println("Nome:");
     aluno.setNome(scanner.nextLine());
    
     System.out.println("Endereço");
     aluno.setEndereco(scanner.nextLine());
    
     System.out.println("Email:");
     aluno.setEmail(scanner.nextLine());
    
     System.out.println("Matrícula:");
     aluno.setMatricula(scanner.nextLine());
    
     System.out.println("Curso:");
     aluno.setCurso(scanner.nextLine());
      
     System.out.println("CPF:");
     aluno.setCpf(scanner.nextLine());
    
     System.out.println("Definir senha para o novo Usuário");
     aluno.setSenha(scanner.nextLine());

     listaAluno.add(aluno);
     }
        

     public void adminCadastrarUsuario(){
     switch(opcInt){
        case 1 : 
            cadastrarAluno();
            break;
        case 2 : 
            cadastrarProfessor();
            break;
        case 3 : 
            cadastrarFuncionario();
            break;
      }
     }

     public void cadastrarProfessor(){
     Professor professor = new Professor();
     System.out.println("Informe os dados do professor");
     System.out.println("Nome:");
     professor.setNome(scanner.nextLine());
    
     System.out.println("Endereço");
     professor.setEndereco(scanner.nextLine());
    
     System.out.println("Email:");
     professor.setEmail(scanner.nextLine());
    
     System.out.println("Departamento:");
     professor.setDepartamento(scanner.nextLine());
    
     System.out.println("Titulacao:");
     professor.setTitulacao(scanner.nextLine());
    
     System.out.println("Data de contratação:");
     professor.setDataContratacao(scanner.nextLine());
    
     System.out.println("CPF:");
     professor.setCpf(scanner.nextLine());
    
     System.out.println("Definir senha para o novo Usuário");
     professor.setSenha(scanner.nextLine());

     listaProfessor.add(professor);
     }


     public void cadastrarFuncionario(){
     Funcionario funcionario = new Funcionario(); 
     System.out.println("Informe os dados do funcionário");
    
     System.out.println("Nome:");
     funcionario.setNome(scanner.nextLine());
    
     System.out.println("Endereço");
     funcionario.setEndereco(scanner.nextLine());
    
     System.out.println("Email:");
     funcionario.setEmail(scanner.nextLine());
    
     System.out.println("Cargo:");
     funcionario.setCargo(scanner.nextLine());
    
     System.out.println("Departamento:");
     funcionario.setDepartamento(scanner.nextLine());
    
     System.out.println("Endereço:");
     funcionario.setEndereco(scanner.nextLine());
    
     System.out.println("CPF:");
     funcionario.setCpf(scanner.nextLine());
    
     System.out.println("Definir senha para o novo Usuário");
     funcionario.setSenha(scanner.nextLine());

     listaFuncionario.add(funcionario);
     }


     public void cadastrarLivro(){
     Livro livro = new Livro();

     System.out.println("Autor:");
     livro.setAutor(scanner.nextLine());

     System.out.println("Editora:");
     livro.setEditora(scanner.nextLine());

     System.out.println("idISBN:");
     livro.setIdISBN(scanner.nextLine());

     System.out.println("Número de Páginas:");
     livro.setNumeroPaginas(scanner.nextInt());
     scanner.nextLine(); // limpa o ENTER pendente
    
     listaLivro.add(livro);
     }


     public void reservarLivro() {
     System.out.println("Digite o título do livro para buscar:");
     String tituloBusca = scanner.nextLine();
     Livro livro = buscarLivro(tituloBusca); 
     Usuario usuario = new Usuario(); // Busca o livro antes de tentar reservar

     if (livro != null && livro.isDisponivel()) {
        System.out.println("Item disponível. Pegar emprestado? (s/n)");
        opc = scanner.nextLine();

        if (opc.equalsIgnoreCase("s")) {
            System.out.println("Definir tempo do empréstimo (7 - 14 dias):");
            int diasEmprestimo = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            // Gerar nota de empréstimo
            String nota = "---------- NOTA DE RESERVA ----------\n" +
                          "Título do Livro: " + livro.getTituloBusca() + "\n" +
                          "Autor: " + livro.getAutor() + "\n" +
                          "ISBN: " + livro.getIdISBN() + "\n" +
                          "Usuário: " + usuario.getNome() + "\n" +
                          "Data da Reserva: " + java.time.LocalDate.now() + "\n" +
                          "Prazo de Devolução: " + java.time.LocalDate.now().plusDays(diasEmprestimo) + "\n" +
                          "--------------------------------------";

            System.out.println("Confirmar empréstimo? (s/n)");
            opc = scanner.nextLine();

            if (opc.equalsIgnoreCase("s")) {
                livro.setDisponivel(false); // Marca como não disponível
                System.out.println("Empréstimo Confirmado");
                System.out.println(nota);
                listaReserva.add(usuario);
            }else {
                System.out.println("Reserva não concluída.");
            }
            }
            }else {
        System.out.println("Livro não disponível ou não encontrado.");
      }
     }

     public void buscarLivroWrapper(String tituloBusca) {
     Livro livro = buscarLivro(tituloBusca); // Chama o método que busca o livro
    
        if (livro != null) { // Verifica se o livro foi encontrado (não é nulo)
           System.out.println("Livro encontrado: " + livro.getTituloBusca());
        } else {
           System.out.println("Livro não encontrado.");
        }
     }

     public Livro buscarLivro(String tituloBusca) {
        for (Livro livro : listaLivro) {
            if (livro.getTituloBusca().equalsIgnoreCase(tituloBusca)) {
               System.out.println("Livro encontrado: " + livro.getTituloBusca());
               return livro;  // Retorna o livro encontrado
            }
        }
     System.out.println("Livro não encontrado.");
     return null; // Retorna null se o livro não for encontrado
     }
}