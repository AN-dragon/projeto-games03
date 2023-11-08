<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Plataforma</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <%@include file="../menubar.jsp" %>
    <main class="container">
        <h1>Editar Plataforma</h1>
        <form action="/plataformas/update" method="POST">
            <input type="hidden" name="id" value="${plataforma.id}" />
            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" name="nome" class="form-control" value="${plataforma.nome}" />
            </div>

            <a href="/plataformas/list" class="btn btn-secondary">Voltar</a>
            <input class="btn btn-success" type="submit" value="Salvar" />
        </form>
    </main>
    
</body>
</html>