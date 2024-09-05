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
<icabueta:head titulo="Professor"/>
<body>
    <div class="container">
        <h1 class="display-1 text-center mt-4 mb-4">iCabueta</h1>
        <jsp:directive.include file="components/menu-professor.jsp"/>
    </div>
    <icabueta:carrega-estudantes/>
    <c:choose>
        <c:when test="${param.denunciante != null || param.denunciado != null}">
            <icabueta:carrega-denuncias filtro="${DenunciaFiltro.FILTRO}" denunciado="${param.denunciado}" denunciante="${param.denunciante}"/>
        </c:when>
        <c:otherwise>
            <icabueta:carrega-denuncias filtro="${DenunciaFiltro.PROFESSOR}"/>
        </c:otherwise>
    </c:choose>
    <div class="container">
        <form method="get" class="row justify-content-end pt-3">
            <div class="col col-auto">
                <select name="denunciante" class="form-select" value="${param.denunciante}">
                    <option ${param.denunciante == null ? "selected" : ""} value="">Denunciante</option>
                    <c:forEach var="estudante" items="${estudantes}">
                        <option ${param.denunciante != null && param.denunciante == estudante.codigo ? "selected" : ""} value="${estudante.codigo}">${estudante.nome}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col col-auto">
                <select name="denunciado" class="form-select" value="${param.denunciado}">
                    <option selected value="">Denunciado</option>
                    <c:forEach var="estudante" items="${estudantes}">
                        <option ${param.denunciado != null && param.denunciado == estudante.codigo ? "selected" : ""} value="${estudante.codigo}">${estudante.nome}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col col-auto">
                <button class="btn btn-primary" type="submit">Filtrar</button>
            </div>
        </form>
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
