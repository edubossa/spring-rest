package br.com.ntk.rest;

import java.util.UUID;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestToken {
	
	
	@Test
	public void geraTokenTes(){
		
		String token = UUID.randomUUID().toString();
		System.out.println(token);
		assertNotNull(token); 
	}

}
