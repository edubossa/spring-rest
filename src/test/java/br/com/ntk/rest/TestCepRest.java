package br.com.ntk.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import br.com.ntk.model.Cep;
import br.com.ntk.model.Response;

public class TestCepRest {
	
	private static final String URL_DEFAULT = "http://localhost:8080/ntkcep-rest/";

	@Test
	public void cepFindTest() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		
		RestTemplate restTemplate = new RestTemplate();
		String url = URL_DEFAULT.concat("cep/07031000");
		
		HttpEntity<Response> entity = new HttpEntity<Response>(headers);
		HttpEntity<Response> entityResponse = restTemplate.exchange(url, HttpMethod.GET, entity, Response.class);
		
		Response response = entityResponse.getBody();
		System.out.println("codRetorno: " + response.getCodRetorno());
		System.out.println("mensagem: " + response.getMensagem());
		
		assertNotEquals("Cep nao Encontrado", response.getCep(), 0);
	}
	
	@Test
	public void cepFindLogradourosTest() {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		
		RestTemplate restTemplate = new RestTemplate();
		String url = URL_DEFAULT.concat("logradouros/fidencio /sp");
		
		HttpEntity<Response> entity = new HttpEntity<Response>(headers);
		HttpEntity<Response> entityResponse = restTemplate.exchange(url, HttpMethod.GET, entity, Response.class);
		Response response = entityResponse.getBody();
		
		assertNotEquals("Cep nao Encontrado", response.getCep(), 0);
		System.out.println("Total: " + response.getTotal()); 
		for(Cep cep : response.getCeps()) {
			System.out.println(cep); 
		}
		
	}
	
}