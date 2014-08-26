<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maual CEP WebService</title>

<link rel="stylesheet" href="resources/css/table.css" type="text/css"/>	

</head>
<body>
	

	<div  class="CSS_Table_Example" style="width:750px;height:150px;">
	
		<table>
		
			<tr>
				<td colspan="2" align="center" > <h4>Manual CEP WebService</h4> </td>
			</tr>
		
			<tr>
				<td><h4>Funcionalidade:</h4></td>
				<td>Busca pelo CEP</td>
			</tr>
			
				
			<tr>
				<td> <h4>URL:</h4></td>
				<td>http://localhost:8080/ntkcep-rest/webservice/cep/{paramCEP}</td>
			</tr>
			
			<tr>
				<td> <h4>Content-Type:</h4></td>
				<td>application/json | application/xml</td>
			</tr>
			
			<tr>
				<td> <h4>Authorization:</h4></td>
				<td>Basic ZnJlZDpmcmVk</td>
			</tr>
			
			<tr>
				<td> <h4>URL Completa:</h4></td>
				<td> curl -D- -X GET -H "Authorization: Basic ZnJlZDpmcmVk" -H "Content-Type: application/json" http://localhost:8080/ntkcep-rest/webservice/cep/07031000</td>
			</tr>
			
			
			<!-- 
			
			***********************************************************************
			
			 -->
			
			<tr>
				<td><h4>Funcionalidade:</h4></td>
				<td>Busca pelo Logradouro</td>
			</tr>
			
			<tr>
				<td> <h4>URL:</h4></td>
				<td>http://localhost:8080/ntkcep-rest/logradouros/{paramLogradouro}/{paramUF}</td>
			</tr>
			
			<tr>
				<td> <h4>Content-Type:</h4></td>
				<td>application/json | application/xml</td>
			</tr>
			
			<tr>
				<td> <h4>Authorization:</h4></td>
				<td>Basic ZnJlZDpmcmVk</td>
			</tr>
			
			<tr>
				<td> <h4>Limite da Busca:</h4></td>
				<td>100</td>
			</tr>
			
			<tr>
				<td> <h4>URL Completa:</h4></td>
				<td> curl -D- -X GET -H "Authorization: Basic ZnJlZDpmcmVk" -H "Content-Type: application/json" http://localhost:8080/ntkcep-rest/logradouros/fidencio /sp</td>
			</tr>
			
			<!-- 
			
			RETORNOS
			
			 -->
			 
			 <tr>
				<td colspan="2" ><h4>Tipos de Retornos:</h4></td>
			</tr>
			
			<tr>
				<td> <h4>0</h4></td>
				<td>Pesquisa Realizada com Sucesso!</td>
			</tr>
			
			<tr>
				<td> <h4>-1</h4></td>
				<td>CEP Nao Localizado!</td>
			</tr>
			
			<tr>
				<td> <h4>-2</h4></td>
				<td>Logradouro Nao Localizado!</td>
			</tr>
			
			<tr>
				<td> <h4>-99</h4></td>
				<td>"Exception capturada em tempo de execucao, a nivel do desenvolvedor"</td>
			</tr>
			
			<tr>
				<td> <h4>401</h4></td>
				<td>Nao Autorizado!</td>
			</tr>
			
			
		</table>
		
	</div>
	
</body>
</html>