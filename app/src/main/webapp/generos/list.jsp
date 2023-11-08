<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gêneros</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <%@include file="../menubar.jsp" %>
    <main class="container">
        <h1>Gêneros</h1>
        <a class="btn btn-primary" href="/generos/insert">Novo Gênero</a>
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>&nbsp;</th>
            </tr>

            <c:forEach var="g" items="${generos}">
                <tr>
                    <td>${g.id}</td>
                    <td>${g.nome}</td>
                    <td>
                        <a class="btn btn-info" href="/generos/update/${g.id}">Editar</a>
                        <a class="btn btn-danger" href="/generos/delete/${g.id}">Remover</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </main>
    
</body>
</html>