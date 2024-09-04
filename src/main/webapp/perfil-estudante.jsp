<%--
  Created by IntelliJ IDEA.
  User: brunohasouza
  Date: 03/09/24
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="icabueta" uri="/WEB-INF/icabueta.tld" %>
<html data-bs-theme="dark">
<icabueta:head titulo="Perfil do Estudante"/>
<body>
    <div class="container mb-3">
        <h1 class="display-1 text-center mt-4 mb-4">iCabueta</h1>
        <jsp:directive.include file="components/menu-estudante.jsp"/>
    </div>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h2 class="card-title mb-0">${sessionScope.eLogado.nome}</h2>
                    </div>
                    <div class="card-body">
                        <form method="post" action="estudante/atualizar">
                            <div class="container-fluid px-0">
                                <div class="row g-3">
                                    <div class="col-12 col-md-6">
                                        <label class="form-label" for="input-nome">Nome</label>
                                        <input type="text" name="nome" class="form-control" required id="input-nome" value="${sessionScope.eLogado.nome}">
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label" for="input-email">E-mail</label>
                                        <input type="email" name="email" class="form-control" required id="input-email" value="${sessionScope.eLogado.email}">
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label" for="input-senha">Senha</label>
                                        <input type="password" name="senha" minlength="6" class="form-control" required id="input-senha" value="${sessionScope.eLogado.senha}">
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label" for="input-ano">Ano de Entrada</label>
                                        <input type="number" name="ano-entrada" minlength="6" class="form-control" required id="input-ano" value="${sessionScope.eLogado.anoEntrada}">
                                    </div>
                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary" style="width: 100%;">Atualizar Perfil</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
