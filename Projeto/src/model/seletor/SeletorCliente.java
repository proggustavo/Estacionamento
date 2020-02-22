package model.seletor;

public class SeletorCliente {

	private long cartao;
	private String nome;
	private String cpf;
	private String descricao;

	public boolean temFiltro() {
		
		if (this.cartao > 0) {
			return true;
		}
		if ((this.cpf != null) && (this.cpf.length() > 0)) {
			return true;
		}
		if ((this.nome != null) && (this.nome.length() > 0)) {
			return true;
		}
		if ((this.descricao != null) && (this.descricao.length() > 0)) {
			return true;
		}
		return false;
	}

	public long getCartao() {
		return cartao;
	}

	public void setCartao(long cartao) {
		this.cartao = cartao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
