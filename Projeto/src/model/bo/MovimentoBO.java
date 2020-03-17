package model.bo;

import java.util.ArrayList;

import model.dao.movientos.MovimentoDAO;
import model.vo.movimentos.MovimentoVO;

public class MovimentoBO {

	private MovimentoDAO dao = new MovimentoDAO();

	public ArrayList<MovimentoVO> consultarTodos() {
		return dao.consultarTodos();

	}
}
