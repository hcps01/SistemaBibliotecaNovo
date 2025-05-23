package modelo;

public class Aluno extends Usuario{
    private String matricula;
    private String curso;
    private String anoIngresso;
    
    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getCurso(){
        return curso;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }

    public String getAnoIngresso(){
        return anoIngresso;
    }

    public void setAnoIngresso(String anoIngresso){
        this.anoIngresso = anoIngresso;
    }
    
}