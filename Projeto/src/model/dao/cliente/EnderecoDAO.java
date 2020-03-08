package model.dao.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.banco.Banco;
import model.banco.BaseDAO;
import model.seletor.Seletor;
import model.vo.cliente.EnderecoVO;

public class EnderecoDAO implements BaseDAO<Object> {

	@Override
	public Object criarResultSet(ResultSet result) {
		
		EnderecoVO endereco = null;
		
		try {
			endereco = new EnderecoVO();
			
			endereco.setId(result.getInt("idendereco"));
			endereco.setNumero(result.getInt("numero"));
			endereco.setRua(result.getString("rua"));
			endereco.setBairro(result.getString("bairro"));
			endereco.setCidade(result.getString("cidade"));
			
		} catch (SQLException e) {
			System.out.println("/****************************************************************/");
			System.out.println(this.getClass());
			System.out.println("Method: cirarResultSet()");
			System.out.println();
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getSQLState());
			System.out.println("/****************************************************************/");
		}
		return endereco;
	}

	@Override
	public ArrayList<EnderecoVO> consultarTodos() {
		
		String qry = " SELECT * FROM ENDERECO ";
		ArrayList<EnderecoVO> lista = new ArrayList<EnderecoVO>();

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, qry);
		ResultSet result = null;
		
		try {
			result = stmt.executeQuery(qry);
			while (result.next()) {
				EnderecoVO e = (EnderecoVO) criarResultSet(result);
				lista.add(e);
			}
		} catch (SQLException e) {
			System.out.println(this.getClass());
			System.out.println("Method: consultarTodos()");
			System.out.println();
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getSQLState());
		} finally {
			Banco.closeResultSet(result);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return lista;
	}

	@Override
	public ArrayList<Object> consultar(Seletor seletor) {
//		String qry = " SELECT * FROM ENDERECO WHERE RUA = '" + text.toUpperCase() + "' ";

		return null;
	}

	@Override
	public Object consultarPorId(int id) {
		
		String qry = " SELECT * FROM ENDERECO WHERE ID=?";
		EnderecoVO endereco = null;
		
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, qry);
		ResultSet result = null;
		
		try {
			
			stmt.setInt(1, id);
			result = stmt.executeQuery(qry);
			
			while (result.next()) {
				endereco = (EnderecoVO) criarResultSet(result);
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass());
			System.out.println("Method: consultarPorID()");
			System.out.println();
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getSQLState());
		} finally {
			Banco.closeResultSet(result);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		
		return endereco;
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
