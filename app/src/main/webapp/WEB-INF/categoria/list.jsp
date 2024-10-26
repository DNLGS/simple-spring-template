<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    </head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${categorias}" var="categoria">
                <tr>
                    <td>${categoria.id}</td>
                    <td>${categoria.nome}</td>
                    <td>${categoria.descricao}</td>
                    <td>
                        <a href="/categorias/editar/${categoria.id}">Editar</a>
                        <a href="/categorias/excluir/${categoria.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>