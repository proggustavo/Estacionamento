package controller;

import model.bo.MoveBO;
import model.vo.MoveVO;

public class ControllerInicio {

	private MoveVO vo;
	private MoveBO bo;
	
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
	
	public Object tableValidate(int row) {
		return row;
		
		
	}

	public String excluirUsuarios(MoveVO vo) {
		
		return msg;
	}
	
	

}
