package model.dao.movientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.banco.Banco;
import model.banco.BaseDAO;
import model.seletor.Seletor;
import model.vo.movimentos.MovimentoVO;
import model.vo.movimentos.PlanoVO;
import model.vo.movimentos.TicketVO;

public class MovimentoDAO implements BaseDAO<Object>{

	@Override
	public Object criarResultSet(ResultSet result) {
		MovimentoVO movimento = new MovimentoVO();

		try {

			movimento.setId(result.getInt("idmovimento"));
			
			int idC = result.getInt("idcliente");
			TicketDAO ticketDAO = new TicketDAO();
			TicketVO ticketVO = (TicketVO) ticketDAO.consultarPorId(idC);
			movimento.setTicket(ticketVO);
			
			int idP = result.getInt("idplano");
			PlanoDAO planoDAO = new PlanoDAO();
			PlanoVO planoVO = (PlanoVO) planoDAO.consultarPorId(idP);
			movimento.setPlano(planoVO);
			
//			Date dt_entrada = result.getDate("dt_entrada");
//			Date dt_saida = result.getDate("dt_saida");
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//			LocalDateTime local_dt_entrada = LocalDateTime.parse((CharSequence) dt_entrada, dtf);
//			LocalDateTime local_dt_saida = LocalDateTime.parse((CharSequence) dt_saida, dtf);
			
			movimento.setHr_entrada(result.getTimestamp("hr_entrada").toLocalDateTime());
			movimento.setHr_saida(result.getTimestamp("hr_saida").toLocalDateTime());
			
		} catch (SQLException e) {
			System.out.println("/****************************************************************/");
			System.out.println(this.getClass().getSimpleName());
			System.out.println("Method: criarResultSet()");
			System.out.println();
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getSQLState());
			System.out.println("/****************************************************************/");
		}

		return movimento;
	}

	@Override
	public ArrayList<?> consultarTodos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet result = null;

		ArrayList<MovimentoVO> lista = new ArrayList<MovimentoVO>();
		String qry = " SELECT * FROM MOVIMENTO ";

		try {
			result = stmt.executeQuery(qry);
			while (result.next()) {
				MovimentoVO vo = (MovimentoVO) criarResultSet(result);
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("/****************************************************************/");
			System.out.println(this.getClass().getSimpleName());
			System.out.println("Method: consultarTodos()");
			System.out.println(qry);
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getSQLState());
			System.out.println("/****************************************************************/");
		} finally {
			Banco.closeResultSet(result);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return lista;
	}

	@Override
	public ArrayList<?> consultar(Seletor seletor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultarPorId(int id) {
		String qry = " SELECT * FROM MOVIMENTO WHERE ID=? ";
		MovimentoVO movimento = null;
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, qry);
		ResultSet result = null;
		
		try {
			
			stmt.setInt(1, id);
			result = stmt.executeQuery(qry);
			
			while (result.next()) {
				movimento = (MovimentoVO) criarResultSet(result);
			}
		} catch (SQLException e) {
			System.out.println("/****************************************************************/");
			System.out.println(this.getClass().getSimpleName());
			System.out.println("Method: consultarPorID()");
			System.out.println(qry);
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getSQLState());
			System.out.println("/****************************************************************/");
		} finally {
			Banco.closeResultSet(result);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return movimento;
	}

	@Override
	public Object cadastrar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
