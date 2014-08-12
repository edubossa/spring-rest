package br.com.ntk.dao;

import java.util.List;

import br.com.ntk.model.Cep;

/**
 * Metodos de acesso ao BD, para busca dos CEP'S
 * 
 * @author Eduardo Wallace
 * @author NTK Solutions
 * @since 12/08/2014
 */
public interface ICepDAO {
	
	/**
	 * Busca o cep de acordo com o cep passado como parametro
	 * 
	 * @param cep Object CEP
	 * @return  Object CEP
	 * @throws DAOException - em caso de erro
	 */
	public Cep getCep(String cep) throws DAOException;
	
	/**
	 * Busca o CEP pelo logradouro passado como parametro, limitando pelo estado
	 * tambem passado como parametro.
	 * 
	 * @param logradouro - endereco a ser pesquisado
	 * @param estado - parametro obrigatorio
	 * @return Object CEP
	 * @throws DAOException - em caso de erro
	 */
	public List<Cep> getByLogradouro(String logradouro, String estado) throws DAOException;

}
