package model.vo;

import java.time.LocalDateTime;

public class MoveVO {
	
	private int id;
	private long ticket_cartao;
	private CarroVO carro;
	private ClienteVO cliente;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private boolean cbx;
	private MoveVO vo;
	
	public MoveVO(int id, long ticket_cartao, CarroVO carro, ClienteVO cliente, LocalDateTime entrada,
			LocalDateTime saida, boolean cbx) {
		super();
		this.id = id;
		this.ticket_cartao = ticket_cartao;
		this.carro = carro;
		this.cliente = cliente;
		this.entrada = entrada;
		this.saida = saida;
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

	public MoveVO getVo() {
		return vo;
	}

	public void setVo(MoveVO vo) {
		this.vo = vo;
	}
	
	
}
