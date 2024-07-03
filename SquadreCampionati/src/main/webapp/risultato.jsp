<%@ page import="bean.Risultato" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestione Risultati</title>
</head>
<body>
    <h1>Gestione Risultati</h1>
    <form action="RisultatoServlet" method="post">
        Gol Segnati: <input type="number" name="gol_segnati" required>
        Squadra: 
        <select name="squadra_id">
            <c:forEach var="squadra" items="${squadre}">
                <option value="${squadra.id}">${squadra.nome}</option>
            </c:forEach>
        </select>
        Partita: 
        <select name="partita_id">
            <c:forEach var="partita" items="${partite}">
                <option value="${partita.id}">${partita.data} - ${partita.luogo}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Aggiungi Risultato">
    </form>
    <h2>Elenco Risultati</h2>
    <ul>
        <c:forEach var="risultato" items="${risultati}">
            <li>Squadra: ${risultato.squadraId} - Partita: ${risultato.partitaId} - Gol: ${risultato.golSegnati}</li>
        </c:forEach>
    </ul>
    <a href="index.jsp">Torna alla Home</a>
</body>
</html>
