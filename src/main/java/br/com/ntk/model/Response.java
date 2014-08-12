package br.com.ntk.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.ntk.util.TipoRetornoEnum;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * OBJ - Principal a ser retornado pelo WS.
 * 
 * @author Eduardo Wallace
 * @author NTK Solutions
 * @since 12/08/2014
 */
@XmlRootElement
@JsonInclude(Include.NON_EMPTY)
public class Response implements Serializable {
	private static final long serialVersionUID = -864509586988493166L;
	
	/** @see TipoRetornoEnum#getCodRetorno() **/
	private int codRetorno;
	
	/** @see TipoRetornoEnum#getMensagem() **/
	private String mensagem;
	
	/** Qtde. total dos ceps retornados **/
	private int total;
	
	/** Cep **/
	private Cep cep;
	
	/** Contem a lista com os ceps **/
	private List<Cep> ceps;
	
	/**
	 * CEP
	 * @return CEP
	 */
	public Cep getCep() {
		return cep;
	}
	
	/**
	 * Atribuicao do Cep 
	 * @param cep
	 */
	public void setCep(Cep cep) {
		this.cep = cep;
	}
	
	/**
	 * CEP's
	 * @return lista de ceps
	 */
	public List<Cep> getCeps() {
		return ceps;
	}
	
	/**
	 * Atribuicao lista de ceps
	 * @param ceps - lista ceps
	 */
	public void setCeps(List<Cep> ceps) {
		this.ceps = ceps;
	}
	
	/**
	 * @see TipoRetornoEnum#getCodRetorno()
	 * @return @see TipoRetornoEnum#getCodRetorno()
	 */
	public int getCodRetorno() {
		return codRetorno;
	}
	
	/**
	 * Atribuicao do codigo de retorno
	 * @see TipoRetornoEnum#getCodRetorno()
	 * @param codRetorno - codigo de retorno
	 */
	public void setCodRetorno(int codRetorno) {
		this.codRetorno = codRetorno;
	}
	
	/**
	 * @see TipoRetornoEnum#getMensagem() 
	 * @return  @see TipoRetornoEnum#getMensagem() 
	 */
	public String getMensagem() {
		return mensagem;
	}
	
	/**
	 * Atribuicao da mensagem
	 * @see TipoRetornoEnum#getMensagem()
	 * @param mensagem - 
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	/**
	 * Qtde. total dos ceps retornados
	 * @return - qtde ceps  
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Atribuicao do total dos ceps retornados
	 * 
	 * @param total - valor total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

}