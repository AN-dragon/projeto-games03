<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Jogo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <%@include file="../menubar.jsp" %>
    <main class="container">
        <h1>Editar Jogo</h1>

        <form action="/jogos/update" method="POST">
            <input type="hidden" name="id" value="${jogo.id}" />
            <div class="form-group">
                <label for="titulo">Título</label>
                <input type="text" name="titulo" class="form-control" placeholder="Título do Jogo" value="${jogo.titulo}">
            </div>

            <div class="form-group">
                <label for="titulo">Gênero</label>
                <select name="genero" class="form-control">
                    <c:forEach var="g" items="${generos}">
                        <option ${jogo.genero.id == g.id ? "selected" : "" } value="${g.id}">${g.nome}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label>Plataforma(s)</label>
                <c:forEach var="p" items="${plataformas}">
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" ${jogo.plataformas.contains(p) ? "checked" : ""}
                            class="custom-control-input" name="plataformas" value="${p.id}" id="${p.id}">
                        <label class="custom-control-label" for="${p.id}">${p.nome}</label>
                    </div>
                </c:forEach>
            </div>

            <a href="/jogos/list" class="btn btn-secondary">Voltar</a>
            <input class="btn btn-success" type="submit" value="Salvar" />
        </form>
    </main>
</body>
</html>