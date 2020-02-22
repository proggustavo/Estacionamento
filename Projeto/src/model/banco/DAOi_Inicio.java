package model.banco;

import java.util.List;

import model.vo.MoveVO;

public interface DAOi_Inicio {
	
	// Inicio
	public void remover(MoveVO vo);
	
	public void validar(MoveVO vo);
	
	public List<MoveVO> pesquisar (String text);

	public List<MoveVO> listar (MoveVO vo);
	
	public List<MoveVO> gerarTicket(MoveVO vo);
	
	public List<MoveVO> ultimoRecibo(MoveVO vo);
	
	public List<MoveVO> imprimirRecibo(MoveVO vo);
	
	
}
