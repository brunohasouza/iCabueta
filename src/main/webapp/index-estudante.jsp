<%--
  Created by IntelliJ IDEA.
  User: brunohasouza
  Date: 31/08/24
  Time: 00:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="icabueta" uri="/WEB-INF/icabueta.tld" %>
<%@ page import="br.com.bhas.icabueta.model.entities.DenunciaFiltro" %>
<html data-bs-theme="dark">
<icabueta:head titulo="Estudante"/>
<body>
    <div class="container mb-3">
        <h1 class="display-1 text-center mt-4 mb-4">iCabueta</h1>
        <jsp:directive.include file="components/menu-estudante.jsp"/>
    </div>
    <icabueta:carrega-denuncias filtro="${DenunciaFiltro.ESTUDANTE}"/>
    <div class="container">
        <c:choose>
            <c:when test="${denuncias.size() > 0}">
                <table class="table table-bordered table-striped table-hover m-0">
                    <tr>
                        <th>Código</th>
                        <th>Cadeira</th>
                        <th>Método Fila</th>
                        <th>Data</th>
                        <th>Detalhes</th>
                    </tr>
                    <c:forEach var="denuncia" items="${pageScope.denuncias}">
                        <tr class="align-middle">
                            <td>${denuncia.codigo}</td>
                            <td>${denuncia.cadeira.nome}</td>
                            <td>${denuncia.metodoFila.descricaoCurta}</td>
                            <td>${denuncia.data}</td>
                            <td>
                                <a class="btn btn-sm btn-outline-primary" href="detalhes-denuncia.jsp?codigo=${denuncia.codigo}">Detalhes</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <div class="alert alert-secondary">Nenhuma denúncia encontrada</div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
