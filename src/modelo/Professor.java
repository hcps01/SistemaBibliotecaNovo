package modelo;

public class Professor extends Usuario{
    private String departamento;
    private String titulacao;
    private String dataContratacao;
    
    public String getDepartamento(){
        return departamento;
    }
    
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
    
    public String getTitulacao(){
        return titulacao;
    }
    
    public void setTitulacao(String titulacao){
        this.titulacao = titulacao;
    }
    
    public String getDataContratacao(){
        return dataContratacao;
    }
    
    public void setDataContratacao(String dataContratacao){
        this.dataContratacao = dataContratacao;
    }
}