package model.vo;

import java.time.LocalDateTime;

public class CaixaVO {

	private MoveVO moveVO;
	
	private int id;
	private int formaPgto;
	private double valorTicket;
	private String descricao;
	private String plano;
	private LocalDateTime plano_vencimento;
	private LocalDateTime horaValidacao;
	private boolean cbx;
//	private double saldoDinheiro;
//	private double saldoCartao;
//	private double total;
	
	
	public CaixaVO(int id, MoveVO moveVO, String descricao, int formaPgto, double valorTicket, String plano,
			LocalDateTime plano_vencimento, LocalDateTime horaValidacao, boolean cbx) {
		super();
		this.id = id;
		this.moveVO = moveVO;
		this.descricao = descricao;
		this.formaPgto = formaPgto;
		this.valorTicket = valorTicket;
		this.plano = plano;
		this.plano_vencimento = plano_vencimento;
		this.horaValidacao = horaValidacao;
		this.setCbx(cbx);
		
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

	public MoveVO getMoveVO() {
		return moveVO;
	}

	public void setMoveVO(MoveVO movimento) {
		this.moveVO = movimento;
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

	public LocalDateTime getHoraValidacao() {
		return horaValidacao;
	}

	public void setHoraValidacao(LocalDateTime horaValidacao) {
		this.horaValidacao = horaValidacao;
	}

	public boolean isCbx() {
		return cbx;
	}

	public void setCbx(boolean cbx) {
		this.cbx = cbx;
	}
}
