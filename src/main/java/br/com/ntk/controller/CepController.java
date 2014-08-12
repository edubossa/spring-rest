package br.com.ntk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ntk.model.Response;
import br.com.ntk.service.CepService;

/**
 * Controller CEP, o qual disponibiliza os WebServices.
 *  
 * @author Eduardo Wallace
 * @author NTK Solutions
 * @since 12/08/2014
 */
@Controller
public class CepController {
	
	@Autowired
	private CepService service;
	
	/**
	 * Disponibiliza o WebService para busca do CEP, nos formatos Json e XML
	 * <p>
	 * Para comsumir em formato Json ou XML, deve passar no Header as seguindes propriedades:
	 * <p>
	 * <b>Accept</b> com o valor <b>application/json</b>
	 * <p>
	 * ou
	 * <p>
	 * <b>Accept</b> com o valor <b>application/xml</b>
	 * 
	 * @param cep
	 * @return Object CEP
	 */
	@RequestMapping(value = "/cep/{cep}", method = RequestMethod.GET, 
			produces = {"application/json", "application/xml"})
	public @ResponseBody Response getCep(@PathVariable("cep") String cep) {
		
		Response response  = service.getCep(cep.replaceAll("\\D", "")); 
		return response;
	}
	
	/**
	 * Disponibiliza o WebService para busca do CEP pelo Logradouro, nos formatos Json e XML
	 * <p>
	 * Para comsumir em formato Json ou XML, deve passar no Header as seguindes propriedades:
	 * <p>
	 * <b>Accept</b> com o valor <b>application/json</b>
	 * <p>
	 * ou
	 * <p>
	 * <b>Accept</b> com o valor <b>application/xml</b> 
	 * 
	 * @param logradouro
	 * @param estado
	 * @return Object CEP
	 */
	@RequestMapping(value = "/logradouros/{logradouro}/{estado}", method = RequestMethod.GET, 
			produces = {"application/json", "application/xml"})
	public @ResponseBody Response getCepByLogradouro(
			@PathVariable("logradouro") String logradouro, @PathVariable("estado") String estado) {
			
		Response response = service.getCepByLogradouro(logradouro, estado);
		return response;
	}
	
}