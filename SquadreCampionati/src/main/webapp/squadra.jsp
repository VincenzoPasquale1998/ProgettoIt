<%@ page import="bean.Squadra" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestione Squadre</title>
</head>
<body>
    <h1>Gestione Squadre</h1>
    <form action="SquadraServlet" method="post">
        Nome: <input type="text" name="nome" required>
        Città: <input type="text" name="citta" required>
        <input type="submit" value="Aggiungi Squadra">
    </form>
    <h2>Elenco Squadre</h2>
    <table border="1">
    	<tr><th>Squadra</th><th>Città</th></tr>
        <c:forEach var="squadra" items="${squadre}">
            <tr><td>${squadra.nome}</td><td>${squadra.citta}</td></tr>
        </c:forEach>
    </table>
    <a href="index.jsp">Torna alla Home</a>
</body>
</html>
