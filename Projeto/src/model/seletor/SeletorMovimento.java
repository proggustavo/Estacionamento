package model.seletor;

import java.time.LocalDateTime;

public class SeletorMovimento {

	private LocalDateTime dtInicio;
	private LocalDateTime dtFim;
	
	public boolean temFiltro() {

		if (this.dtInicio != null) {
			return true;
		}
		if (this.dtFim != null) {
			
		}
		return false;
	}

	public LocalDateTime getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(LocalDateTime dtInicio) {
		this.dtInicio = dtInicio;
	}

	public LocalDateTime getDtFim() {
		return dtFim;
	}

	public void setDtFim(LocalDateTime dtFim) {
		this.dtFim = dtFim;
	}
	
}
