package br.com.ntk.util;

/**
 * Possiveis tratamentos a serem apresentados nas tags codRetorno e mensagem.
 * 
 * @author Eduardo Wallace
 * @author NTK Solutions
 * @since 12/08/2014
 */
public enum TipoRetornoEnum {
	
	/** Pesquisa Realizada com Sucesso! **/
	SUCESSO(00, "Pesquisa Realizada com Sucesso!"),
	
	/** Cep Nao Localizado! **/
	ERRO_01(-1, "CEP Nao Localizado!"),
	
	/** Logradouro Nao Localizado! **/
	ERRO_02(-2, "Logradouro Nao Localizado!"),
	
	/** Não Autorizado **/
	ERRO_401(401, "Nao Autorizado!"),
	
	/** Exception capturada em tempo de execucao, no try/cath **/
	ERRO_99(-99, ""),
	;
	
	private int codRetorno;
	private String mensagem;
	
	private TipoRetornoEnum(int codRetorno, String mensagem) {
		this.codRetorno = codRetorno;
		this.mensagem = mensagem;
	}
	
	/** Codigo de retorno do WS**/
	public int getCodRetorno() {
		return codRetorno;
	}
	
	/** Mensagem a ser exibida no WS**/
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}	
	
}