package model.banco;

import java.util.List;

import model.vo.ClienteVO;

public interface DAOi_Cliente {

	//Cadastrar
	
	public void adicionarCliente(ClienteVO vo);
	
	public void atualizarCliente(ClienteVO vo);
	
	public void remover(ClienteVO vo);
	
	public List<ClienteVO> listarCliente(ClienteVO vo);
	
}
