package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.banco.DAOi_Inicio;
import model.vo.MoveVO;

public class MoveDAO implements DAOi_Inicio {

	/**
	 * Cria um novo usu�rio a partir do ResultSet
	 * 
	 * @param resultado
	 * @return
	 */
	private MoveVO obterMoveVODoResultSet(ResultSet resultado) {
		MoveVO vo = null;
		try {
//			Constr�i um usu�rio com os dados retornados pela consulta

			vo = new MoveVO();
			vo.setId(resultado.getInt("id"));
			vo.setTicket_cartao(resultado.getInt("ticket_cartao"));
			
//			vo.setCliente((ClienteVO) resultado.getObject("cliente"));;
//			vo.setNome(resultado.getString("nome"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public void remover(MoveVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validar(MoveVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MoveVO> pesquisar(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MoveVO> listar(MoveVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MoveVO> gerarTicket(MoveVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MoveVO> ultimoRecibo(MoveVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MoveVO> imprimirRecibo(MoveVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
}
