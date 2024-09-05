<%--
  Created by IntelliJ IDEA.
  User: brunohasouza
  Date: 04/09/24
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="icabueta" uri="/WEB-INF/icabueta.tld" %>
<%@ page import="br.com.bhas.icabueta.model.entities.DenunciaFiltro" %>
<html data-bs-theme="dark">
<icabueta:head titulo="Denuncia"/>
<style>
    .table th, .table td {
        padding: .75rem !important;
    }

    .table th {
        width: 10rem !important;
    }
</style>
<body>
    <div class="container">
        <h1 class="display-1 text-center mt-4 mb-4">iCabueta</h1>
        <c:if test="${sessionScope.eLogado != null}">
            <c:if test="${param.codigo eq null}">
                <c:redirect url="index-estudante.jsp"/>
            </c:if>

            <jsp:directive.include file="components/menu-estudante.jsp"/>
        </c:if>
        <c:if test="${sessionScope.pLogado != null}">
            <c:if test="${param.codigo eq null}">
                <c:redirect url="index-professor.jsp"/>
            </c:if>

            <jsp:directive.include file="components/menu-professor.jsp"/>
        </c:if>
    </div>
    <div class="container">
        <icabueta:carrega-denuncias filtro="${DenunciaFiltro.DENUNCIA}" denuncia="${param.codigo}"/>
        <table class="table table-bordered table-striped table-hover m-0">
            <tr>
                <th>Código</th>
                <td>${denuncia.codigo}</td>
            </tr>
            <tr>
                <th>Data</th>
                <td>${denuncia.data}</td>
            </tr>
            <tr>
                <th>Denunciante</th>
                <td>${denuncia.denunciante.nome}</td>
            </tr>
            <tr>
                <th>Denunciados</th>
                <td>
                    <ul class="mb-0" style="padding-left: 1.25rem;">
                        <c:forEach var="denunciado" items="${denuncia.denunciados}">
                            <li>${denunciado.nome}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            <tr>
            <tr>
                <th>Cadeira</th>
                <td>${denuncia.cadeira.nome}</td>
            </tr>
            <tr>
                <th>Professor</th>
                <td>${denuncia.professor.nome}</td>
            </tr>
                <th>Turno</th>
                <td>${denuncia.turno}</td>
            </tr>
            <tr>
                <th>Método de Fila</th>
                <td>${denuncia.metodoFila.descricaoLonga}</td>
            </tr>
            <tr>
                <th>Descrição</th>
                <td>${denuncia.descricao}</td>
            </tr>
        </table>
    </div>
</body>
</html>
