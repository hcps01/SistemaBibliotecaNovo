package modelo;

public class Livro extends ItensBiblioteca{
    private String autor;
    private String editora;
    private String idISBN;
    private String tituloBusca;
    private boolean devolvido;
    private int numeroPaginas;
    private boolean disponivel;


    public String getAutor(){
        return autor;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public String getTituloBusca(){
        return tituloBusca;
    }
    
    public void setTituloBusca(String tituloBusca){
        this.tituloBusca = tituloBusca;
    }
    
    public String getEditora(){
        return editora;
    }
    
    public void setEditora(String editora){
        this.editora = editora;
    }
    
    public String getIdISBN(){
        return idISBN;
    }
    
    public void setIdISBN(String idISBN){
        this.idISBN = idISBN;
    }
        
    public int getNumeroPaginas(){
        return numeroPaginas;
    }
    
    public void setNumeroPaginas(int numeroPaginas){
        this.numeroPaginas = numeroPaginas;
    }
      
    public boolean getDevolvido(){
        return devolvido;
    }
    
    public void setDevolvido(boolean devolvido){
        this.devolvido = devolvido;
    }
        
    public boolean isDisponivel(){
        return disponivel;
    }
}
