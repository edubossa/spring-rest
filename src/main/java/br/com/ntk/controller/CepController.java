package br.com.ntk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.ntk.model.Response;
import br.com.ntk.service.CepService;
import br.com.ntk.util.RetornoHelper;
import br.com.ntk.util.TipoRetornoEnum;

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
	@RequestMapping(value = "/webservice/cep/{cep}", method = RequestMethod.GET, 
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
	@RequestMapping(value = "/webservice/logradouros/{logradouro}/{estado}", method = RequestMethod.GET, 
			produces = {"application/json", "application/xml"})
	public @ResponseBody Response getCepByLogradouro(
			@PathVariable("logradouro") String logradouro, @PathVariable("estado") String estado) {
			
		Response response = service.getCepByLogradouro(logradouro, estado);
		return response;
	}
	
	/**
	 * Intercepta a request caso ocorra um erro de autenticacao 
	 * 
	 * @return - Response Nao Autorizado.
	 */
	@RequestMapping(value = "/webservice/error/acesso/", method = RequestMethod.GET, 
			produces = {"application/json", "application/xml"})
	public @ResponseBody Response accessDenied() {
			
		Response response = new Response();
		RetornoHelper.populaRetornoUsuario(response, TipoRetornoEnum.ERRO_401);
		System.out.println(TipoRetornoEnum.ERRO_401.getMensagem()); 
		
		/*
		 * Exemplo de codigo Utilizado para Obter o Perfil do usuario
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		//Caso o Usuario tenha logado, consegue obter os dados do mesmo.
		boolean typeAuthentication = auth instanceof AnonymousAuthenticationToken;
		if (!typeAuthentication){			
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		}*/
		
		return response;
	}
	
	/**
	 * Instrucoes do Uso do Manual do WebService
	 * 
	 * @return - Manual WebService
	 */
	@RequestMapping(value = "/manual", method = RequestMethod.GET)
	public ModelAndView  manual() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("manual"); 
		return model;
	}
	
}