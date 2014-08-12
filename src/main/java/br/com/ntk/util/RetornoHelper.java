package br.com.ntk.util;

import br.com.ntk.model.Response;

/**
 * Auxilia o tratamento das mensagens e do codigo de retorno
 * 
 * @author Eduardo Wallace
 * @author NTK Solutions
 * @since 12/08/2014
 */
public class RetornoHelper {
	
	/**
	 * Preenche os campos <b>codRetorno</b> e <b>mensagem</b>
	 * 
	 * @param response - Obj a ser retornado pelo WS
	 * @param tipoRetorno - enum com os possiveis tipos de retornos
	 */
	public static void populaRetornoUsuario(Response response ,TipoRetornoEnum tipoRetorno) {
		response.setCodRetorno(tipoRetorno.getCodRetorno());
		response.setMensagem(tipoRetorno.getMensagem());
	}

}