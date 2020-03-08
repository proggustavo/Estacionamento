package model.dao.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.banco.Banco;
import model.banco.BaseDAO;
import model.dao.movientos.PlanoDAO;
import model.seletor.Seletor;
import model.vo.cliente.ClienteVO;
import model.vo.cliente.ContratoVO;
import model.vo.movimentos.PlanoVO;

public class ContratoDAO implements BaseDAO<Object>{

	@Override
	public Object criarResultSet(ResultSet result) {
		ContratoVO contrato = new ContratoVO();

		try {

			contrato.setId(result.getInt("idcontrato"));
			
			int idPlano = result.getInt("idplano");
			PlanoDAO planoDAO = new PlanoDAO();
			PlanoVO planoVO = (PlanoVO) planoDAO.consultarPorId(idPlano);
			contrato.setPlano(planoVO);
			
			int idCliente = result.getInt("idcliente");
			ClienteDAO clienteDAO = new ClienteDAO();
			ClienteVO clienteVO = (ClienteVO) clienteDAO.consultarPorId(idCliente);
			contrato.setCliente(clienteVO);
			
//			Date dt_entrada = result.getDate("dt_entrada");
//			Date dt_saida = result.getDate("dt_saida");
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//			LocalDateTime local_dt_entrada = LocalDateTime.parse((CharSequence) dt_entrada, dtf);
//			LocalDateTime local_dt_saida = LocalDateTime.parse((CharSequence) dt_saida, dtf);
//			
			contrato.setDtEntrada(result.getTimestamp("hr_entrada").toLocalDateTime());
			contrato.setDtSaida(result.getTimestamp("hr_saida").toLocalDateTime());
			contrato.setAtivo(result.getBoolean("ativo"));
			contrato.setN_cartao(result.getLong("n_cartao"));
			contrato.setValor(result.getDouble("valor"));
			
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

		return contrato;
	}

	@Override
	public ArrayList<?> consultarTodos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet result = null;

		ArrayList<ContratoVO> lista = new ArrayList<ContratoVO>();
		String qry = " SELECT * FROM CONTRATO ";

		try {
			result = stmt.executeQuery(qry);
			while (result.next()) {
				ContratoVO vo = (ContratoVO) criarResultSet(result);
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
		String qry = " SELECT * FROM CONTRATO WHERE ID=? ";
		ContratoVO contrato = null;
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, qry);
		ResultSet result = null;
		
		try {
			
			stmt.setInt(1, id);
			result = stmt.executeQuery(qry);
			
			while (result.next()) {
				contrato = (ContratoVO) criarResultSet(result);
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

		return contrato;
	}

	@Override
	public Object cadastrar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
