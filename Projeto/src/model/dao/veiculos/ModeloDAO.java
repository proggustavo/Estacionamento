package model.dao.veiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.banco.Banco;
import model.banco.BaseDAO;
import model.seletor.Seletor;
import model.vo.veiculo.MarcaVO;
import model.vo.veiculo.ModeloVO;

public class ModeloDAO implements BaseDAO<Object> {

	@Override
	public Object criarResultSet(ResultSet result) {
		ModeloVO vo = null;

		try {
			vo = new ModeloVO();
			vo.setId(result.getInt("idmodelo"));
			;

			int idMarca = result.getInt("idmarca");
			MarcaDAO marcaDAO = new MarcaDAO();
			MarcaVO marcaVO = (MarcaVO) marcaDAO.consultarPorId(idMarca);

			vo.setMarca(marcaVO);
			vo.setDescricao(result.getString("descricao"));

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
		return vo;
	}

	@Override
	public ArrayList<ModeloVO> consultarTodos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet result = null;

		ArrayList<ModeloVO> lista = new ArrayList<ModeloVO>();
		String qry = " SELECT * FROM MODELO ";

		try {
			result = stmt.executeQuery(qry);
			while (result.next()) {
				ModeloVO vo = (ModeloVO) criarResultSet(result);
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
		String qry = " SELECT * FROM MARCA WHERE DESCRICAO=? ";
		ArrayList<ModeloVO> lista = new ArrayList<ModeloVO>();
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, qry);
		ResultSet result = null;
		
		if (seletor.temFiltro()) {
			qry = seletor.criarFiltroCliente(qry);
		}
		
		try {
			result = stmt.executeQuery(qry);
			while (result.next()) {
				ModeloVO modelo = (ModeloVO) criarResultSet(result);
				lista.add(modelo);
			}
		} catch (SQLException e) {
			System.out.println("/*********************************************************/");
			System.out.println(this.getClass().getSimpleName());
			System.out.println("Method: consultar()");
			System.out.println(qry);
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getSQLState());
			System.out.println("/*********************************************************/");
		} finally {
			Banco.closeResultSet(result);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return lista;
	}

	@Override
	public Object consultarPorId(int id) {

		String qry = " SELECT * FROM MARCA WHERE ID=? ";
		ModeloVO modelo = null;

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, qry);
		ResultSet result = null; 

		try {

			stmt.setInt(1, id);
			result = stmt.executeQuery(qry);

			while (result.next()) {
				modelo = (ModeloVO) criarResultSet(result);
			}
		} catch (SQLException e) {
			System.out.println("/****************************************************************/");
			System.out.println(this.getClass().getSimpleName());
			System.out.println("Method: consultarPorID");
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

		return modelo;
	}

	@Override
	public Object cadastrar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(Object entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
