package modelo;

public class Administrador extends Funcionario{
    private String senhaAdmin = "Admin@123";
    
    
    public Administrador(String nomeUsuario, String senha, String email, String endereco, Livro livroReservado, String cpf) {
        super(nomeUsuario, senha, email, endereco, livroReservado, cpf);
    }
    
    public String getSenhaAdmin(){
        return senhaAdmin;
    }
    
    public void setSenhaAdmin(String senhaAdmin){
        this.senhaAdmin = senhaAdmin;   
    }
}
