package model.vo.movimentos;

public class PlanoVO {

	private int id;
	private String tipo;
	private String descircao;
	
	public PlanoVO(int id, String tipo, String descircao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descircao = descircao;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescircao() {
		return descircao;
	}

	public void setDescircao(String descircao) {
		this.descircao = descircao;
	}
}
