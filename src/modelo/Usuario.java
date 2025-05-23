package modelo;

public class Usuario{
    private String nome;
    private String nomeUsuario;
    private String senha;
    private String email;
    private String endereco;
    private Livro livroReservado;
    private String cpf;

    
    public Usuario(){
        
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNomeUsuario(){
        return nomeUsuario;
    }
    
    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
     
    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public Livro getLivroReservado(){ 
        return livroReservado;
    }
    
    public void setLivroReservado(Livro livro) {
        this.livroReservado = livro;
    }
}

