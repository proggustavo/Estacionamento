package model.vo;

public class EnderecoVO {

	private int id;
	private int numero;
	private String rua;
	private String bairro;
	private String Cidade;
	
	public EnderecoVO(int id, int numero, String rua, String bairro, String cidade) {
		super();
		this.id = id;
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		Cidade = cidade;
	}

	public EnderecoVO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	
	
}