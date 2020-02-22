package model.banco;

import java.util.Date;
import java.util.List;

import model.vo.MovimentoVO;

public interface DAOi_Movimento {

	// Movimentação
	
	public List<MovimentoVO> listarMovimento(Date dtInicio, Date dtFinal);

}
