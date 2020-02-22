package model.vo;

import java.time.LocalDateTime;

public class MovimentoVO {

	private LocalDateTime dtInicio;
	private LocalDateTime dtFinal;
	
	public MovimentoVO(LocalDateTime dtInicio, LocalDateTime dtFinal) {
		super();
		this.dtInicio = dtInicio;
		this.dtFinal = dtFinal;
	}

	public MovimentoVO() {
		super();
	}

	public LocalDateTime getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(LocalDateTime dtInicio) {
		this.dtInicio = dtInicio;
	}

	public LocalDateTime getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(LocalDateTime dtFinal) {
		this.dtFinal = dtFinal;
	}
	
}
