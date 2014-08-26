package br.com.ntk.rest;

import static org.junit.Assert.*;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.RestTemplate;

import br.com.ntk.model.Cep;
import br.com.ntk.model.Response;

public class TestCepRest {
	
	private static final String URL_DEFAULT = "http://localhost:8080/ntkcep-rest/webservice/";

	@Test
	public void cepFindTest() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON); 
		headers.set("Accept", "application/json");
		
		authorisation(headers, "edubossa", "123456");
		
		RestTemplate restTemplate = new RestTemplate();
		String url = URL_DEFAULT.concat("cep/07031000");
		
		HttpEntity<Response> entity = new HttpEntity<Response>(headers);
		HttpEntity<Response> entityResponse = restTemplate.exchange(url, HttpMethod.GET, entity, Response.class);
		
		Response response = entityResponse.getBody();
		System.out.println("codRetorno: " + response.getCodRetorno());
		System.out.println("mensagem: " + response.getMensagem());
		
		System.out.println(response.getCep());
		assertNotEquals("Cep nao Encontrado", response.getCep(), 0);
	}
	
	@Test
	public void cepFindLogradourosTest() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON); 
		headers.set("Accept", "application/json");
		
		authorisation(headers, "edubossa", "123456");
		
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
	
	/** Basic Auth **/
	private void authorisation(HttpHeaders headers, String username, String password) {
		String auth = username + ":" + password;
		byte[] encodedAuthorisation = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")));
		headers.add("Authorization", "Basic " + new String(encodedAuthorisation));
	}
	
}