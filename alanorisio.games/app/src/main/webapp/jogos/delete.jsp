<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Remover Jogo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <%@include file="../menubar.jsp" %>
    <main class="container">
        <h1>Remover Jogo</h1>
        <p>Deseja remover o jogo "${jogo.titulo}" da base de dados?</p>

        <form action="/jogos/delete" method="POST">
            <input type="hidden" name="id" value="${jogo.id}" />
            <a href="/jogos/list" class="btn btn-secondary">Voltar</a>
            <input class="btn btn-danger" type="submit" value="Excluir" />
        </form>
    </main>
    
</body>
</html>