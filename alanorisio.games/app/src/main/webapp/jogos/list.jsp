<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jogos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <%@include file="../menubar.jsp" %>
    <main class="container">
        <h1>Jogos</h1>
        <a class="btn btn-primary" href="/jogos/insert">Novo Jogo</a>

        <table class="table">
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Gênero</th>
                <th>Plataforma(s)</th>
                <th>&nbsp;</th>
            </tr>

            <c:forEach var="j" items="${jogos}">
                <tr>
                    <td>${j.id}</td>
                    <td>${j.titulo}</td>
                    <td>${j.genero.nome}</td>
                    <td>
                        <c:forEach var="p" varStatus="s" items="${j.plataformas}">
                            ${s.getCount() > 1 ? " / " : ""}
                            ${p.nome}
                        </c:forEach>
                    </td>
                    <td>
                        <a class="btn btn-info" href="/jogos/update/${j.id}">Editar</a>
                        <a class="btn btn-danger" href="/jogos/delete/${j.id}">Remover</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </main>    
</body>
</html>