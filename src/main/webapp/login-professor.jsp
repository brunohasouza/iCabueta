<%--
  Created by IntelliJ IDEA.
  User: brunohasouza
  Date: 31/08/24
  Time: 00:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="icabueta" uri="/WEB-INF/icabueta.tld" %>
<html data-bs-theme="dark">
<icabueta:head titulo="Login de Professores"/>
<body>
<div class="container">
    <h1 class="display-1 text-center mt-4 mb-4">iCabueta</h1>
</div>
<div class="card" style="width: 100%; max-width: 400px;  margin: 0 auto;">
    <div class="card-header py-3">
        <h2 class="card-title h4 mb-0">Login de Professores</h2>
    </div>
    <div class="card-body">
        <c:if test='${sessionScope.msg != null && !sessionScope.msg.equals("")}'>
            <div class="alert alert-danger">${sessionScope.msg}</div>
            <c:remove var="msg" scope="session"/>
        </c:if>
        <form class="mb-0" method="post" action="professores/login">
            <div class="mb-3">
                <label for="login-email" class="form-label">E-mail</label>
                <input type="email" required class="form-control" name="email" id="login-email">
            </div>
            <div class="mb-4">
                <label for="login-password" class="form-label">Senha</label>
                <input type="password" required minlength="6" name="password" class="form-control" id="login-password">
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Entrar</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
