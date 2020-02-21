package model.vo;

public class CarroVO {
	
	private int id;
	private String marca;
	private String modelo;
	private String descricao;
	private String placa;
	
	public CarroVO(int id, String marca, String modelo, String descricao, String placa) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.descricao = descricao;
		this.placa = placa;
	}

	public CarroVO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
