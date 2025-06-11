package modelo;

import java.time.LocalDate;

public class Reserva {
	
    private Usuario usuarioDaVez;
	private Livro livroReservado;
    private LocalDate dataAtual;
    private LocalDate dataReservaInicio;
    private LocalDate dataReservaFim;
    private LocalDate dataDevolucao;
    private int diasEmprestimo;
    private boolean disponivel;
    
    
    public Reserva(Usuario usuario, Livro livroReservado, Livro livro, LocalDate dataAtual, LocalDate dataReservaInicio, LocalDate dataReservaFim, LocalDate dataEmprestimo, LocalDate dataDevolucao, int diasEmprestimo, boolean disponivel) {
        this.usuarioDaVez = usuario;
        this.setLivroReservado(livro);
        this.dataAtual = LocalDate.now();
        this.dataReservaInicio = LocalDate.now();
        this.dataReservaFim = dataReservaInicio.plusDays(diasEmprestimo);
        this.diasEmprestimo = diasEmprestimo;
        this.dataDevolucao = dataReservaInicio.plusDays(diasEmprestimo);
        this.disponivel = false;
    }
    
    public Livro getLivroReservado() {
		return livroReservado;
	}

	public void setLivroReservado(Livro livroReservado) {
		this.livroReservado = livroReservado;
	}
    
	public LocalDate getDataAtual(){
	        return dataAtual;
	}
    
    public LocalDate getDataReservaInicio() {
		return dataReservaInicio;
	}

	public void setDataReservaInicio(LocalDate dataReservaInicio) {
		this.dataReservaInicio = dataReservaInicio;
	}

	public LocalDate getDataReservaFim() {
		return dataReservaFim;
	}

	public void setDataReservaFim(LocalDate dataReservaFim) {
		this.dataReservaFim = dataReservaFim;
	}

	public LocalDate getDataDevolucao(){
        return dataDevolucao;
    }
    
    public void setDataDevolucao(LocalDate dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }

	public int getDiasEmprestimo(){
        return diasEmprestimo;
    }
    
    public void setDiasEmprestimo(int diasEmprestimo){
        this.diasEmprestimo = diasEmprestimo;
    }
    
    public Usuario getUsuarioDaVez() {
		return usuarioDaVez;
	}

	public void setUsuarioDaVez(Usuario usuarioDaVez) {
		this.usuarioDaVez = usuarioDaVez;
	}

	public boolean getDisponivel() {
		return disponivel;
	}

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;   	
    }
}