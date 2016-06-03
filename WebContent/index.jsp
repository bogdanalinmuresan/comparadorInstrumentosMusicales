<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/comparador/css/estilo.css" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"  href="<c:url value="http://www.w3schools.com/lib/w3.css" />">
	
    <title>Comparador Instrumentos Musicales</title>
  </head>

  <body>
    <div class="w3-container w3-center w3-padding-16"" >
	  <div class="w3-tag w3-jumbo w3-red">C</div>
	  <div class="w3-tag w3-jumbo">o</div>
	  <div class="w3-tag w3-jumbo w3-yellow">m</div>
	  <div class="w3-tag w3-jumbo">p</div>
	  <div class="w3-tag w3-jumbo w3-red">a</div>
	  <div class="w3-tag w3-jumbo">r</div>
	  <div class="w3-tag w3-jumbo w3-yellow">a</div>
	  <div class="w3-tag w3-jumbo">d</div>
	  <div class="w3-tag w3-jumbo w3-red">o</div>
	  <div class="w3-tag w3-jumbo">r</div>
	</div>
	
	
    <div>
    	<form action="/comparador">
    		
  			<input class="w3-input w3-border w3-round-xxlarge" placeholder="Intruduzca la consulta"  type="text" name="keywords" size="13" value="">
  			
    	</form>
    	<div>
    	
    	<div class="w3-row">
		  <div id="columnaEbay" class="w3-col s4 w3-center">
		  		<div class="w3-tag w3-xlarge w3-orange">Ebay</div>
		  		
		  		<c:forEach items="${articulosEbay}" var="resuEbay">
			  		<div class="w3-col s12 m12 l12 w3-padding w3-center w3-navbar">
		                <a href="${resuEbay.galleryUrl}">
		                    <div class="w3-card-12 w3-hover-shadow" style="width:100%">
		                        <header class="w3-container w3-light-grey">
		                            <h4>Precio:${resuEbay.currentPrice} euros</h4>
		                        </header>
		                        <img src="${resuEbay.urlImag}" alt="blabla" style="width:100%">
		
		                        <div class="w3-container w3-justify">
		                            <p>"${resuEbay.title}"</p>
		                        </div>
		                    </div>
		                </a>
	           	 	</div>
		  		</c:forEach>
		  </div>
		  
		  <div id="columnaAmazon" class="w3-col s4  w3-center">
		  		<div class="w3-tag w3-xlarge w3-orange">Amazon</div>
		  		<c:forEach items="${articulosAmazon}" var="resuAmazon">
			  		<div class="w3-col s12 m12 l12 w3-padding w3-center w3-navbar">
		                <a href="${resuAmazon.galleryUrl}">
		                    <div class="w3-card-12 w3-hover-shadow" style="width:100%">
		                        <header class="w3-container w3-light-grey">
		                            <h4>Precio:${resuAmazon.currentPrice} euros</h4>
		                        </header>
		                        <img src="${resuAmazon.urlImag}" alt="blabla" style="width:100%">
		
		                        <div class="w3-container w3-justify">
		                            <p>"${resuAmazon.title}"</p>
		                        </div>
		                    </div>
		                </a>
	           	 	</div>
		  		</c:forEach>
		  		
		  </div>
		  <div id="columnaFnac" class="w3-col s4 w3-center">
		  		<div class="w3-tag w3-xlarge w3-orange">Fnac</div>
		  		
		  		<c:forEach items="${articulosFnac}" var="resuFnac">
			  		<div class="w3-col s12 m12 l12 w3-padding w3-center w3-navbar">
		                <a href="${resuFnac.galleryUrl}">
		                    <div class="w3-card-12 w3-hover-shadow" style="width:100%">
		                        <header class="w3-container w3-light-grey">
		                            <h4>Precio:${resuFnac.currentPrice} euros</h4>
		                        </header>
		                        <img src="${resuFnac.urlImag}" alt="blabla" style="width:100%">
		
		                        <div class="w3-container w3-justify">
		                            <p>"${resuFnac.title}"</p>
		                        </div>
		                    </div>
		                </a>
	           	 	</div>
		  		</c:forEach>
		  		
		  </div>
		</div>
    		<table>
				<c:forEach items="${articulosEbay}" var="resuEbay">
					<tr>
						
					    	<td><c:out value="${resuEbay.itemId}" /></td>
					    	<td><c:out value="${resuEbay.title}" /></td>
					    	<td><c:out value="${resuEbay.currentPrice}" /></td>
					    	<td><c:out value="${resuEbay.galleryUrl}" /></td> 
				    
				   	</tr>
				</c:forEach>
			</table>
    	</div>
    	
    	<h3>
  <c:forEach var="author" items="${book.authors}">     
    <c:out value="${author}" /><br/>      
  </c:forEach>
  </h3>
    </div>
  </body>
</html>
