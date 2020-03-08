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
import model.vo.movimentos.FluxoVO;
import model.vo.movimentos.MovimentoVO;

public class FluxoDAO implements BaseDAO<Object> {

	@Override
	public Object criarResultSet(ResultSet result) {
		FluxoVO fluxo = new FluxoVO();

		try {

			fluxo.setId(result.getInt("idfluxo"));
			
			int id = result.getInt("idmovimento");
			MovimentoDAO movimentoDAO = new MovimentoDAO();
			MovimentoVO movimentoVO = (MovimentoVO) movimentoDAO.consultarPorId(id);
			fluxo.setMovimento(movimentoVO);

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

		return fluxo;
	}

	@Override
	public ArrayList<?> consultarTodos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet result = null;

		ArrayList<FluxoVO> lista = new ArrayList<FluxoVO>();
		String qry = " SELECT * FROM FLUXO ";

		try {
			result = stmt.executeQuery(qry);
			while (result.next()) {
				FluxoVO vo = (FluxoVO) criarResultSet(result);
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
		String qry = " SELECT * FROM FLUXO WHERE ID=? ";
		FluxoVO fluxo = null;

		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, qry);
		ResultSet result = null;
		
		try {
			
			stmt.setInt(1, id);
			result = stmt.executeQuery(qry);
			
			while (result.next()) {
				fluxo = (FluxoVO) criarResultSet(result);
			}
		} catch (SQLException e) {
			System.out.println("/****************************************************************/");
			System.out.println(this.getClass().getSimpleName());
			System.out.println("Method: consultarPorId");
			System.out.println(qry);
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getSQLState());
			System.out.println("/****************************************************************/");
		} finally {
			Banco.closeResultSet(result);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return fluxo;
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
