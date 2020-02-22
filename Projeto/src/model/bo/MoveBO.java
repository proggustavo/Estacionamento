package model.bo;

import java.util.ArrayList;

import model.banco.DAOi_Inicio;
import model.dao.MoveDAO;
import model.vo.MoveVO;

public class MoveBO {

	private DAOi_Inicio dao = new MoveDAO();
	
	public ArrayList<MoveVO> boConsultarTabelaInicio(String text) {
		return (ArrayList<MoveVO>) dao.pesquisar(text);
	}

}
