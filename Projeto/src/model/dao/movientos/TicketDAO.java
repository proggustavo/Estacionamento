package model.dao.movientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.banco.Banco;
import model.banco.BaseDAO;
import model.dao.cliente.ClienteDAO;
import model.seletor.Seletor;
import model.vo.cliente.ClienteVO;
import model.vo.movimentos.TicketVO;

public class TicketDAO implements BaseDAO<Object>{

	@Override
	public Object criarResultSet(ResultSet result) {
		TicketVO ticket = new TicketVO();

		try {

			ticket.setId(result.getInt("idticket"));
			
			int id = result.getInt("idcliente");
			ClienteDAO clienteDAO = new ClienteDAO();
			ClienteVO clienteVO = (ClienteVO) clienteDAO.consultarPorId(id);
			ticket.setCliente(clienteVO);
			
//			Date dt_entrada = result.getDate("dt_entrada");
//			Date dt_saida = result.getDate("dt_saida");
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//			LocalDateTime local_dt_entrada = LocalDateTime.parse((CharSequence) dt_entrada, dtf);
//			LocalDateTime local_dt_saida = LocalDateTime.parse((CharSequence) dt_saida, dtf);
			
			ticket.setDtEntrada(result.getTimestamp("dt_entrada").toLocalDateTime());
			ticket.setDtSaida(result.getTimestamp("dt_saida").toLocalDateTime());
			ticket.setN_ticket(result.getLong("n_ticket"));
			ticket.setValor(result.getDouble("valor"));
			ticket.setHr_validacao(result.getTimestamp("hr_validacao").toLocalDateTime());
		
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
			;

		}

		return ticket;
	}

	@Override
	public ArrayList<?> consultarTodos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet result = null;

		ArrayList<TicketVO> lista = new ArrayList<TicketVO>();
		String qry = " SELECT * FROM TICKET ";

		try {
			result = stmt.executeQuery(qry);
			while (result.next()) {
				TicketVO vo = (TicketVO) criarResultSet(result);
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
		String qry = " SELECT * FROM TICKET WHERE ID=? ";
		TicketVO ticket = null;
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, qry);
		ResultSet result = null;
		
		try {
			
			stmt.setInt(1, id);
			result = stmt.executeQuery(qry);
			
			while (result.next()) {
				ticket = (TicketVO) criarResultSet(result);
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

		return ticket;
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
