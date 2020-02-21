package model.vo;

public class LostTicketVO {

	private int id;
	private String nome;
	private String CPF;
	private String placa;
	private String renavam;
	private int formaPgto;
	
	public LostTicketVO(int id, String nome, String cPF, String placa, String renavam, int formaPgto) {
		super();
		this.id = id;
		this.nome = nome;
		CPF = cPF;
		this.placa = placa;
		this.renavam = renavam;
		this.formaPgto = formaPgto;
	}

	public LostTicketVO() {
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public int getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(int formaPgto) {
		this.formaPgto = formaPgto;
	}
	
	
}