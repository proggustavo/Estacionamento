package model.banco;

import java.util.List;

import model.vo.CaixaVO;

public interface DAOi_Caixa {

	//Caixa
	
	public void adicionarValor(CaixaVO vo);
	
	public void removerValor(CaixaVO vo);
	
	public void fecharCaixa(CaixaVO vo);
	
	public List<CaixaVO> relatorioCaixa();

}
