package br.com.ntk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.ntk.model.Cep;

/**
 * Implementacao dos metodos de acesso ao BD, para busca dos CEP'S
 * 
 * @author Eduardo Wallace
 * @author NTK Solutions
 * @since 12/08/2014
 */
@Repository
public class JpaCepDAOImpl implements ICepDAO {

	@PersistenceContext
	EntityManager manager;

	/**
	 *  @see ICepDAO#getCep(String)
	 */
	public Cep getCep(String cep) {
		
		TypedQuery<Cep> query = manager.createNamedQuery("cepFind", Cep.class);
		query.setParameter("cep", cep);
		
		Cep c = null;
		try {
			
			c = query.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
		
		return c;
	}

	/** 
	 * @see ICepDAO#getByLogradouro(String, String)
	 **/
	public List<Cep> getByLogradouro(String logradouro, String estado) throws DAOException {
		
		TypedQuery<Cep> query = manager.createNamedQuery("cepFindLogradouro", Cep.class);
		query.setParameter("logradouro", "%" + logradouro + "%");
		query.setParameter("estado", estado);
		query.setMaxResults(100);
		List<Cep> ceps = query.getResultList(); 
		System.out.println("Total da Busca: " + ceps.size());
		
		return ceps;
	}
	
}