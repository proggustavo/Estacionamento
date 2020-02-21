package model.vo;

public class ClienteVO {

	private int id;
	private String nome;
	private String CPF;
	private String telefone;
	private EnderecoVO endereco;
	private CarroVO carro;
	
	public ClienteVO(int id, String nome, String cPF, String telefone, EnderecoVO endereco, CarroVO carro) {
		super();
		this.id = id;
		this.nome = nome;
		CPF = cPF;
		this.telefone = telefone;
		this.endereco = endereco;
		this.carro = carro;
	}

	public ClienteVO() {
		super();
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