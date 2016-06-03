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
    <title>Comparador Instrumentos Musicales</title>
  </head>

  <body>
    <h1>Comparador</h1>
	
    <table>
      <tr>
        <td colspan="2" style="font-weight:bold;">Available Servlets:</td>        
      </tr>
      <tr>
        <td><a href="comparador">Comparador</a></td>
      </tr>
    </table>
    <div>
    	<form action="/comparador">
    		<input type="submit" value="Buscar por palabras clave">
  			<input type="text" name="keywords" size="13" value="">
    	</form>
    	<div>
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
