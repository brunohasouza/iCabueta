<%--
  Created by IntelliJ IDEA.
  User: brunohasouza
  Date: 31/08/24
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand" href="index-estudante.jsp">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="nav nav-pills flex-grow-1">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="criar-denuncia.jsp">Denunciar</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Perfil</a>
                </li>
            </ul>
            <div class="d-flex gap-3 align-items-center">
                <p class="h5 mb-0">Olá, ${sessionScope.eLogado.nome}</p>
                <a class="btn btn-outline-secondary btn-sm" href="estudantes/logout" class="link">Sair</a>
            </div>
        </div>
    </div>


    <c:if test="${sessionScope.eLogado eq null}">
        <c:redirect url="/login-estudante.jsp"/>
    </c:if>

    <c:if test="${sessionScope.msg ne null}">
        <div class="modal fade" id="modal-msg" tabindex="-1" aria-labelledby="modal-msg-label" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="modal-msg-label">Alerta</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="alert alert-secondary mb-0">
                            <p class="h4 mb-0">${sessionScope.msg}</p>
                        </div>
                        <c:remove var="msg" scope="session"/>
                    </div>
                </div>
            </div>
        </div>

        <script>
                const messageModal = new bootstrap.Modal(document.querySelector("#modal-msg"));
                messageModal.show();

                setTimeout(() => messageModal.hide(), 5000);
        </script>
    </c:if>
</nav>
