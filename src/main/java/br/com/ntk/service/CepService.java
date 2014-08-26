package br.com.ntk.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ntk.dao.ICepDAO;
import br.com.ntk.model.Cep;
import br.com.ntk.model.Response;
import br.com.ntk.util.RetornoHelper;
import br.com.ntk.util.TipoRetornoEnum;

/**
 * Camada de servico do CEP para tratamento dos possiveis retorno de erros e 
 * restricoes de acesso, entre outros.
 * 
 * @author Eduardo Wallace
 * @author NTK Solutions
 * @since 12/08/2014
 */
@Service
public class CepService {
	
	@Autowired
	private ICepDAO dao;
	
	/**
	 * Tratamento do retorno do CEP
	 * 
	 * @param cep
	 * @return Object CEP
	 */
	public Response getCep(String cep) {
		//obterIP();
		Cep c = null;
		Response response = new Response();
		
		try {
			
			c = dao.getCep(cep);
			response.setCep(c);
			
			if(c == null) {
				RetornoHelper.populaRetornoUsuario(response, TipoRetornoEnum.ERRO_01);
				response.setTotal(0);
			} else {				
				RetornoHelper.populaRetornoUsuario(response, TipoRetornoEnum.SUCESSO);
				response.setTotal(1); 
			}
		} catch (Exception e) {
			e.printStackTrace();
			TipoRetornoEnum.ERRO_99.setMensagem(e.getMessage());
			RetornoHelper.populaRetornoUsuario(response, TipoRetornoEnum.ERRO_99); 
		}
		
		return response;
	}
	
	/**
	 * Tratamento do retorno do CEP pelo logradouro
	 * 
	 * @param logradouro
	 * @param estado
	 * @return CEP pelo logradouro
	 */
	public Response getCepByLogradouro(String logradouro, String estado) {
		
		List<Cep> ceps = null;
		Response response = new Response();
		
		try {
			
			ceps = dao.getByLogradouro(logradouro, estado);
			response.setCeps(ceps);		
			response.setTotal(ceps.size());
			
			if (ceps.size() == 0) {
				RetornoHelper.populaRetornoUsuario(response, TipoRetornoEnum.ERRO_02);
			} else {				
				RetornoHelper.populaRetornoUsuario(response, TipoRetornoEnum.SUCESSO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			TipoRetornoEnum.ERRO_99.setMensagem(e.getMessage());
			RetornoHelper.populaRetornoUsuario(response, TipoRetornoEnum.ERRO_99); 
		}
		
		return response;
	}
	
	
	public void obterIP() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			
			System.out.println(address.getHostAddress());
			System.out.println(address.getHostName());
			
			InetAddress iad2 = InetAddress.getByName("www.ntk.com.br");
			System.out.println(iad2.getHostAddress());
			System.out.println(iad2.getHostName()); 
			
			InetAddress[] inetAddresses = InetAddress.getAllByName("www.ntk.com.br");
			System.out.println(inetAddresses.length);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		
	}
	
	
}