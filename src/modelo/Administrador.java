package modelo;

public class Administrador extends Funcionario{
    private String senhaAdmin = "Admin@123";
    
    public String getSenhaAdmin(){
        return senhaAdmin;
    }
    
    public void setSenhaAdmin(String senhaAdmin){
        this.senhaAdmin = senhaAdmin;   
    }
}
