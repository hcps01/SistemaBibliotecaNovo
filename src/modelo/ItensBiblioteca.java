package modelo; 

public class ItensBiblioteca{
    private String id;
    private String titulo;
    private boolean disponivel;
    private String dataPublicacao;

 
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
    	this.titulo = titulo;
    }
    
    public boolean getDisponivel(){
        return disponivel;
    }
    
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    
    public String getDataPublicacao(){
    	return dataPublicacao;
    }
    
    public void setDataPublicacao(String dataPublicacao){
        this.dataPublicacao = dataPublicacao;
    }
}