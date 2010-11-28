<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Slovíčka</title>
</head>
<body>
    <h1>Slovíčka</h1>
    
    <form action="/translate" method="get">
        <input type="text" name="word"/>
        
        <fmt:message var="translateLabel">page.translate.translate</fmt:message>
        <input type="submit" value="${translateLabel}" />    
    </form>
    
    <hr/>
    
    <c:if test="${translation != null}">
	    <h3>Překlad:</h3>
	    
	    <div id="translation">
	    <table>
	    <c:forEach items="${translation.words}" var="word">
	   	    <tr>
	          <td>${word.word}</td>
	        </tr>
	    </c:forEach>
	    </table>
	    </div>
	    
    </c:if>
    
</body>
</html>