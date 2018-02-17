<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
td {
border: 2px solid black;}
</style>
<title>Ostoslista</title>
</head>
<body>
<h1>Ostoslista on tässä</h1>
<table>
		<tr>
		<td><b>#</b></td>
		<td><b>Nimi</b></td>
		<td><b>Määrä(kpl)</b></td>
		<td><b>Kuvaus</b></td>
		<td><b>Hinta(e/kpl)</b></td>
		
		<tr>
		<c:forEach items="${ostoslista}" var="ostos">
		
		<tr>
				<td><c:out value="${ostos.id}"></c:out></td>
				<td><c:out value="${ostos.nimi}"></c:out></td>
				<td><c:out value="${ostos.maara}"></c:out></td>
				<td><c:out value="${ostos.kuvaus}"></c:out></td>
				<td><c:out value="${ostos.hinta}"></c:out></td>

				<td><a href="poista-ostos?poisto=${ostos.id}">Poista</a>
				<a href="muokkaa-ostos?muokkaus=${ostos.id}">Muokkaa</a></td>
			<tr>
		</c:forEach>
	</table>
	
	<a href="lisaa-ostos">Lisää ostos listaan</a>
</body>
</html>