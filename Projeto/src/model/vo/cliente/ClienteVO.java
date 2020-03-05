package model.vo.cliente;

import model.vo.veiculo.CarroVO;

public class ClienteVO {

	private int id;
	private String nome;
	private String CPF;
	private String RG;
	private String email;
	private String telefone;
	
//	Objects
	private EnderecoVO endereco;
	private CarroVO carro;
	
	public ClienteVO(int id, String nome, String CPF, String RG, String email, String telefone, EnderecoVO endereco,
			CarroVO carro) {
		super();
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.carro = carro;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	public String getRG() {
		return RG;
	}
	
	public void setRG(String rG) {
		RG = rG;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public EnderecoVO getEndereco() {
		return endereco;
	}
	
	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}
	
	public CarroVO getCarro() {
		return carro;
	}

	public void setCarro(CarroVO carro) {
		this.carro = carro;
	}
	
}
