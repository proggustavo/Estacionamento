package model.vo;

import java.time.LocalDateTime;

import model.vo.cliente.ClienteVO;
import model.vo.cliente.ContratoVO;
import model.vo.cliente.EnderecoVO;
import model.vo.movimentos.PlanoVO;
import model.vo.movimentos.TicketVO;
import model.vo.veiculo.CarroVO;
import model.vo.veiculo.MarcaVO;
import model.vo.veiculo.ModeloVO;

public class Tester {

	private MarcaVO marca;
	private ModeloVO modelo;
	private CarroVO carro;
	private EnderecoVO endereco; 
	private ClienteVO cliente;
	private PlanoVO plano;
	private ContratoVO contrato;
	private TicketVO ticket;
//	private MoveVO moveVO;
	
	public void setMarca() {
		this.marca.setId(1);
		this.marca.setMarca("Teste de Marca");
		
	}
	
	public void setModelo() {
		this.modelo.setId(1);
		this.modelo.setMarca(marca);
		this.modelo.setDescricao("Teste de Descricao");
	}
	
	public void setCarro() {
		this.carro.setId(1);
		this.carro.setCor("Branco");
		this.carro.setModelo(modelo);
		this.carro.setPlaca("ABC-1234");
	}
	
	public void setEndereco() {

		this.endereco.setId(1);
		this.endereco.setNumero(10);
		this.endereco.setRua("SILVA JARDIM, 3--");
		this.endereco.setBairro("PRAINHA");
		this.endereco.setCidade("FLORIANOPOLIS");
	}
	
	public void setCliente() {

		this.cliente.setId(1);
		this.cliente.setNome("JOAO");
		this.cliente.setCpf("12345678910");
		this.cliente.setRg("9888777");
		this.cliente.setTelefone("48988776655");
		this.cliente.setEmail("teste@email.com");
		this.cliente.setEndereco(endereco);
		
	}
	
	public void setPlano() {
		
		this.plano.setId(1);
		this.plano.setTipo("PRÉ-PAGO");
		this.plano.setDescircao("PRÉ-PAGO, UTILIZADOR DIÁRIO");
		
	}
	
	public void setContrato() {
		
		this.contrato.setId(1);
		this.contrato.setN_cartao(000111222333);
		this.contrato.setDtEntrada(LocalDateTime.now());
		this.contrato.setDtSaida(LocalDateTime.now());
		this.contrato.setAtivo(true);
		this.contrato.setValor(100.00);
		this.contrato.setPlano(plano);
		this.contrato.setCliente(cliente);

	}
	
	public void setTicket() {
		
		this.ticket.setId(1);
		this.ticket.setCliente(cliente);
		this.ticket.setN_ticket(999888777);
		this.ticket.setValor(30.00);
		this.ticket.setHr_validacao(LocalDateTime.now());

	}
	
}