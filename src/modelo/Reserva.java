package modelo;

import java.time.LocalDate;

public class Reserva {
	
	private Livro livroReservado;
    private LocalDate dataAtual;
    private LocalDate dataDevolucao;
    private LocalDate dataReservaInicio;
    private LocalDate dataReservaFim;
    private int diasEmprestimo;
    private Usuario usuarioDaVez;
    private boolean disponivel;
    
    
    public Livro getLivroReservado() {
		return livroReservado;
	}


	public void setLivroReservado(Livro livroReservado) {
		this.livroReservado = livroReservado;
	}


	public Reserva(Usuario usuario, Livro livro, int diasEmprestimo) {
        this.usuarioDaVez = usuario;
        this.setLivroReservado(livro);
        this.diasEmprestimo = diasEmprestimo;
        this.dataReservaInicio = LocalDate.now();
        this.dataReservaFim = dataReservaInicio.plusDays(diasEmprestimo);
        this.disponivel = false;
        this.dataAtual = LocalDate.now();
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