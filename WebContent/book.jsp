<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
 <table cellspacing="10">
 <tr>
  <td rowspan="2" valign="top" align="center" width="400">
   <img src="${book.image}"/>
  </td>
  <td valign="top" width="400">
  
  <h2><a href="${book.url}">${book.title}</a></h2>
  
  <h3>
  <c:forEach var="author" items="${book.authors}">     
    <c:out value="${author}" /><br/>      
  </c:forEach>
  </h3>
  
   Publisher: ${book.publisher}
  <br/>
   Date: ${book.date}
  <br/>
   Pages: ${book.pages}
  <br/>
   Binding: ${book.binding}
  <br/>
   ISBN: ${book.isbn}

  </td>
 </tr>
 <tr>
  <td align="right" valign="bottom">
        
  <h3>Book price</h3>
  
  <c:forEach var="offer" items="${book.offers}">     
    ${offer.site}<c:if test="${not empty offer.status}"> (${offer.status})</c:if>:
    <a href="${offer.url}"><b style="color: maroon">${offer.price}</b></a>
    <br/>
  </c:forEach>
  
  </td>
 </tr> 
 <tr>
  <td></td>
  <td align="right">
 <form action="/book">
  <input type="submit" value="Search by ISBN">
  <input type="text" name="isbn" size="13" value="${book.isbn}">
 </form>
  </td>
 </tr>
 
 </table>  
 </center>
</body>
</html>