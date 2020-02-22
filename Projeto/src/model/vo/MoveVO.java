package model.vo;

import java.time.LocalDateTime;

public class MoveVO {
	
	private int id;
	private long ticket_cartao;
	private CarroVO carro;
	private ClienteVO cliente;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private double valor;
	private boolean cbx;
	
	public MoveVO(int id, long ticket_cartao, CarroVO carro, ClienteVO cliente, LocalDateTime entrada,
			LocalDateTime saida, double valor, boolean cbx) {
		super();
		this.id = id;
		this.ticket_cartao = ticket_cartao;
		this.carro = carro;
		this.cliente = cliente;
		this.entrada = entrada;
		this.saida = saida;
		this.valor = valor;
		this.cbx = cbx;
	}

	public MoveVO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTicket_cartao() {
		return ticket_cartao;
	}

	public void setTicket_cartao(long ticket_cartao) {
		this.ticket_cartao = ticket_cartao;
	}

	public CarroVO getCarro() {
		return carro;
	}

	public void setCarro(CarroVO carro) {
		this.carro = carro;
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public boolean isCbx() {
		return cbx;
	}

	public void setCbx(boolean cbx) {
		this.cbx = cbx;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
