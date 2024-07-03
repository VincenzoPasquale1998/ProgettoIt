<%@ page import="bean.Partita" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestione Partite</title>
</head>
<body>
    <h1>Gestione Partite</h1>
    <form action="PartitaServlet" method="post">
        Data: <input type="date" name="data" required>
        Luogo: <input type="text" name="luogo" required>
        <input type="submit" value="Aggiungi Partita">
    </form>
    <h2>Elenco Partite</h2>
    <ul>
        <c:forEach var="partita" items="${partite}">
            <li>${partita.data} - ${partita.luogo}</li>
        </c:forEach>
    </ul>
    <a href="index.jsp">Torna alla Home</a>
</body>
</html>
