package model.banco;

import java.util.List;

public interface BaseDAO {
	
	public void remover(Object... obj);
	
	public void validar(Object... obj);
	
	public List<?> listarTodos();
	
	public List<?> pesquistar(String... strings);

	public Object recibo(Object... obj);
	
}
