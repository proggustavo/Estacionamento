package model.vo.movimentos;

import java.time.LocalDateTime;

import model.vo.cliente.ClienteVO;

public class TicketVO {

	private int id;
	private long n_ticket;
	private double valor;
	private LocalDateTime hr_validacao;
	private LocalDateTime dtEntrada;
	private LocalDateTime dtSaida;
	private ClienteVO cliente;
	
	public TicketVO(int id, long n_ticket, double valor, LocalDateTime hr_validacao, LocalDateTime dtEntrada,
			LocalDateTime dtSaida, ClienteVO cliente) {
		super();
		this.id = id;
		this.n_ticket = n_ticket;
		this.valor = valor;
		this.hr_validacao = hr_validacao;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.cliente = cliente;
	}
	
	public TicketVO() {
		super();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public long getN_ticket() {
		return n_ticket;
	}
	
	public void setN_ticket(long n_ticket) {
		this.n_ticket = n_ticket;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public LocalDateTime getHr_validacao() {
		return hr_validacao;
	}
	
	public void setHr_validacao(LocalDateTime hr_validacao) {
		this.hr_validacao = hr_validacao;
	}
	
	public LocalDateTime getDtEntrada() {
		return dtEntrada;
	}
	
	public void setDtEntrada(LocalDateTime dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	
	public LocalDateTime getDtSaida() {
		return dtSaida;
	}
	
	public void setDtSaida(LocalDateTime dtSaida) {
		this.dtSaida = dtSaida;
	}
	
	public ClienteVO getCliente() {
		return cliente;
	}
	
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	

}
