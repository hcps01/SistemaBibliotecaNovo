package modelo; 

public class Funcionario extends Usuario{
	
    private String cargo;
    private String dataContratacao;
    private String departamento;
    
    public String getCargo(){
        return cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    public String dataContratacao(){
        return dataContratacao;
    }
    
    public void setDataContratacao(String dataContratacao){
       this.dataContratacao = dataContratacao;
    }
    
    public String getDepartamento(){
        return departamento;
    }
    
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
}