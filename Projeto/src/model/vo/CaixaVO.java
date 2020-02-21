package model.vo;

import java.time.LocalDateTime;

import com.sun.jmx.snmp.Timestamp;

import sun.util.resources.LocaleData;

public class CaixaVO {

	private int id;
	private MoveVO movimento;
	private String descricao;
	private int formaPgto;
	private double valorTicket;
	private String plano;
	private LocalDateTime plano_vencimento;
//	private double saldoDinheiro;
//	private double saldoCartao;
//	private double total;
	
	public CaixaVO(int id, MoveVO movimento, String descricao, int formaPgto, double valorTicket, String plano,
			LocalDateTime plano_vencimento) {
		super();
		this.id = id;
		this.movimento = movimento;
		this.descricao = descricao;
		this.formaPgto = formaPgto;
		this.valorTicket = valorTicket;
		this.plano = plano;
		this.plano_vencimento = plano_vencimento;
//		this.saldoDinheiro = saldoDinheiro;
//		this.saldoCartao = saldoCartao;
//		this.total = total;
	}

	public CaixaVO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MoveVO getMovimento() {
		return movimento;
	}

	public void setMovimento(MoveVO movimento) {
		this.movimento = movimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(int formaPgto) {
		this.formaPgto = formaPgto;
	}

	public double getValorTicket() {
		return valorTicket;
	}

	public void setValorTicket(double valorTicket) {
		this.valorTicket = valorTicket;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public LocalDateTime getPlano_vencimento() {
		return plano_vencimento;
	}

	public void setPlano_vencimento(LocalDateTime localDateTime) {
		this.plano_vencimento = localDateTime;
	}
	
}
