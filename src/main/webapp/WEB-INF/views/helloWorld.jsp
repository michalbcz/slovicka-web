<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1>Spring MVC Hello World Annotation Example</h1>

<h2>${message}</h2>

<p>Localized: <fmt:message key="message.text"/></p>
<p>Locale: ${pageContext.response.locale}</p>

<a href="?locale=cs">CS</a> | <a href="?locale=en">EN</a>

</body>
</html>