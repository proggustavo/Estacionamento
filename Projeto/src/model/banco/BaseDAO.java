package model.banco;

import java.util.ArrayList;

import model.seletor.Seletor;

public interface BaseDAO<T> {
	
	/**
	 * Método para consultar tudo o que há no db;
	 * @return ArrayList<?>
	 */
	public abstract ArrayList<?> consultarTodos();
	
	/**
	 * Consulta algo especifico através de uma string;
	 * @param string
	 * @return ArrayList<?>
	 */
	public abstract ArrayList<?> consultar(Seletor seletor);

	/**
	 * Consulta algo especifico através de um id;
	 * @param id
	 * @return object
	 */
	public abstract T consultarPorId(int id);

	/**
	 * Método para cadastrar;
	 * @param object
	 * @return object
	 */
	public abstract T cadastrar (T object);
	
	/**
	 * Método para altera/atualizar;
	 * @param object
	 * @return object
	 */
	public abstract boolean alterar(T object);

	/**
	 * Método para excluir;
	 * @param id
	 * @return true/false
	 */
	public abstract boolean excluir(int[] id);	
	
}
