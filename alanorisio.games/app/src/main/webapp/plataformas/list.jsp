<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Plataformas</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <%@include file="../menubar.jsp" %>
    <main class="container">
        <h1>Gêneros</h1>
        <a class="btn btn-primary" href="/plataformas/insert">Nova Plataforma</a>
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>&nbsp;</th>
            </tr>

            <c:forEach var="p" items="${plataformas}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.nome}</td>
                    <td>
                        <a class="btn btn-info" href="/plataformas/update/${p.id}">Editar</a>
                        <a class="btn btn-danger" href="/plataformas/delete/${p.id}">Remover</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </main>
    
</body>
</html>