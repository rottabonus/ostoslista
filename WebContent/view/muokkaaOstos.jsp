<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Muokkaa ostosta <c:out value="${ostos.nimi}"/></h1>
<form method="post">
		
                        
                        Nimi:<input type="text"  value="<c:out value="${ostos.nimi}"/>" name="nimi" /><br>
                     	Määrä(kpl):<input type="text" value="<c:out value="${ostos.maara}"/>" name="maara"><br>
                        Kuvaus:<input type="text" value="<c:out value="${ostos.kuvaus}"/>" name="kuvaus"><br>
                        Hinta(e/kpl):<input type="text" value="<c:out value="${ostos.hinta}"/>" name="hinta"><br>
                        <input type="submit" value="Muokkaa"><br>
            <a href="ostoslista">Ostoslistaan</a>
				
				
			
</form>
</body>
</html>