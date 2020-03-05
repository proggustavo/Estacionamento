package model.vo.movimentos;

import java.time.LocalDateTime;

public class FluxoVO {
	
	private int id;
	private LocalDateTime dt_entrada;
	private LocalDateTime dt_saida;
//	Objects
	private MovimentoVO movimento;
	
	public FluxoVO(int id, LocalDateTime dt_entrada, LocalDateTime dt_saida, MovimentoVO movimento) {
		super();
		this.id = id;
		this.dt_entrada = dt_entrada;
		this.dt_saida = dt_saida;
		this.movimento = movimento;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDateTime getDt_entrada() {
		return dt_entrada;
	}
	
	public void setDt_entrada(LocalDateTime dt_entrada) {
		this.dt_entrada = dt_entrada;
	}
	
	public LocalDateTime getDt_saida() {
		return dt_saida;
	}
	
	public void setDt_saida(LocalDateTime dt_saida) {
		this.dt_saida = dt_saida;
	}
	
	public MovimentoVO getMovimento() {
		return movimento;
	}

	public void setMovimento(MovimentoVO movimento) {
		this.movimento = movimento;
	}
}
