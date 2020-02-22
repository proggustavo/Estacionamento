package model.seletor;

import java.time.LocalDateTime;

public class SeletorInicio {

	private String ticket_cartao;
	private String nome;
	private String descricao;
	private LocalDateTime dtEntrada;
	
	public boolean temFiltro() {

		if ((this.ticket_cartao != null) && (this.ticket_cartao.length() > 0)) {
			return true;
		}
		if ((this.nome != null) && (this.nome.length() > 0)) {
			return true;
		}
		if((this.descricao != null) && (this.descricao.length() > 0)) {
			return true;
		}
		if (this.dtEntrada != null)  {
			return true;
		}
		return false;
	}
	
	//Getter Setter
	public String getTicket_cartao() {
		return ticket_cartao;
	}

	public void setTicket_cartao(String ticket_cartao) {
		this.ticket_cartao = ticket_cartao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(LocalDateTime dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

}
