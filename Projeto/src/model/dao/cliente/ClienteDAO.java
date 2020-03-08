package model.dao.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.banco.Banco;
import model.banco.BaseDAO;
import model.dao.veiculos.CarroDAO;
import model.seletor.Seletor;
import model.vo.cliente.ClienteVO;
import model.vo.cliente.EnderecoVO;
import model.vo.veiculo.CarroVO;

public class ClienteDAO implements BaseDAO<Object> {

	@Override
	public Object criarResultSet(ResultSet result) {
		ClienteVO cliente = new ClienteVO();
		
		try {
			
			cliente.setId(result.getInt("idcliente"));
			cliente.setNome(result.getString("nome"));
			cliente.setCpf(result.getString("cpf"));
			cliente.setRg(result.getString("rg"));
			cliente.setEmail(result.getString("email"));
			cliente.setTelefone(result.getString("telefone"));
			
			int idEndereco = result.getInt("idendereco");
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			EnderecoVO enderecoVO = (EnderecoVO) enderecoDAO.consultarPorId(idEndereco);
			cliente.setEndereco(enderecoVO);
			
			int idCarro = result.getInt("idcarro");
			CarroDAO carroDAO = new CarroDAO();
			CarroVO carroVO = (CarroVO) carroDAO.consultarPorId(idCarro);
			cliente.setCarro(carroVO);

		} catch (SQLException e) {
			System.out.println("/****************************************************************/");
			System.out.println(this.getClass().getSimpleName());
			System.out.println("Method: criarResultSet()");
			System.out.println();
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getSQLState());
			System.out.println("/****************************************************************/");;
			
		}
		
		return cliente;
	}

	@Override
	public ArrayList<?> consultarTodos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet result = null;

		ArrayList<ClienteVO> lista = new ArrayList<ClienteVO>();
		String qry = " SELECT * FROM CLIENTE ";

		try {
			result = stmt.executeQuery(qry);
			while (result.next()) {
				ClienteVO vo = (ClienteVO) criarResultSet(result);
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
		String qry = " SELECT * FROM CARRO ";
		ArrayList<ClienteVO> lista = new ArrayList<ClienteVO>();
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, qry);
		ResultSet result = null;
		
		if (seletor.temFiltro()) {
			qry = seletor.criarFiltroCliente(qry);
		}
		
		try {
			result = stmt.executeQuery(qry);
			while (result.next()) {
				ClienteVO vo = (ClienteVO) criarResultSet(result);
				lista.add(vo);
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
		String qry = " SELECT * FROM CARRO WHERE ID=? ";
		ClienteVO cliente = null;
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, qry);
		ResultSet result = null;
		
		try {
			
			stmt.setInt(1, id);
			result = stmt.executeQuery(qry);
			
			while (result.next()) {
				cliente = (ClienteVO) criarResultSet(result);
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

		return cliente;
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
