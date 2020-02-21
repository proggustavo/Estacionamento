package model.vo;

import java.time.LocalDateTime;

public class Tester {

	CaixaVO caixa;
	CarroVO carro;
	ClienteVO cliente;
	EnderecoVO endereco;
	LostTicketVO ticketPerdido;
	MoveVO movimento;
	
	public CaixaVO getCaixa() {
		return caixa;
	}
	public void setCaixa(CaixaVO caixa) {
		this.caixa = caixa;
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
	public EnderecoVO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}
	public LostTicketVO getTicketPerdido() {
		return ticketPerdido;
	}
	public void setTicketPerdido(LostTicketVO ticketPerdido) {
		this.ticketPerdido = ticketPerdido;
	}
	public MoveVO getMovimento() {
		return movimento;
	}
	public void setMovimento(MoveVO movimento) {
		this.movimento = movimento;
	}
	
	public void setCaixa()	 {
		caixa.setId(1);
		caixa.setDescricao("Descrevendo Alguma Coisa no Caixa");
		caixa.setFormaPgto(1);
		caixa.setPlano("Mensal Teste");
		caixa.setPlano_vencimento(LocalDateTime.now());
		caixa.setValorTicket(33.141517);
	}
	public void setCarro() {
		carro.setId(1);
		carro.setDescricao("Descrevendo Algum Carro");
		carro.setMarca("Marca Qualquer");
		carro.setModelo("Modelo Qualquer");
		carro.setPlaca("Placa Qualquer");
	}
	public void setCliente() {
		cliente.setId(1);
		cliente.setCarro(carro);
		cliente.setCPF("12345678910");
		cliente.setNome("Sr. Barata Voadora");
		cliente.setTelefone("00988776655");
		cliente.setEndereco(endereco);
	}
	public void setEndereco() {
		endereco.setId(1);
		endereco.setNumero(999);
		endereco.setCidade("Palhoçada");
		endereco.setBairro("Dos ladrões");
		endereco.setRua("Rua do Assalto");
	}
	public void setLostTicket() {
		ticketPerdido.setId(1);
		ticketPerdido.setNome(cliente.getNome());
		ticketPerdido.setCPF(cliente.getCPF());
		ticketPerdido.setPlaca(cliente.getCarro().getPlaca());
		ticketPerdido.setFormaPgto(1);
		ticketPerdido.setRenavam("Não Sei o que é um renavam");
	}
	public void setMovimento() {
		movimento.setId(1);
		movimento.setCarro(carro);
		movimento.setCbx(true);
		movimento.setCliente(cliente);
		movimento.setEntrada(LocalDateTime.now());
		movimento.setSaida(LocalDateTime.MAX);
		movimento.setTicket_cartao(40028922);
	}
}
