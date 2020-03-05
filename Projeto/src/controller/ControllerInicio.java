package controller;

import model.vo.movimentos.FluxoVO;

public class ControllerInicio {

	private FluxoVO vo;
	private String msg = "";
	
	/**
	 * Valida o Campo de inserção do Ticket ou de Procurar pela tabela
	 * @param String message
	 * @return String message
	 */
	public String validate(String text) {
		
		if (text.trim().isEmpty() || msg == null) {
			msg += "Por favor, Digite um Valor Valido!";
		}
		
		return msg;
	}
	

	public String excluirUsuarios(FluxoVO vo) {
		
		return msg;
	}

}
