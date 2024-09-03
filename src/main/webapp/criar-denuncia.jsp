<%--
  Created by IntelliJ IDEA.
  User: brunohasouza
  Date: 02/09/24
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="icabueta" uri="/WEB-INF/icabueta.tld" %>
<html data-bs-theme="dark">
<icabueta:head titulo="Estudante"/>
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
                        <h2 class="card-title mb-0">Denunciar</h2>
                    </div>
                    <div class="card-body">
                        <form>
                            <input type="hidden" value="${sessionScope.eLogado.codigo}" name="codigo">
                            <div class="container-fluid px-0">
                                <div class="row g-3">
                                    <div class="col-12 col-md-6">
                                        <label class="form-label" for="select-estudante">Estudante(s)</label>
                                        <select class="form-select" id="select-estudante" required name="estudantes"></select>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label" for="select-cadeira">Cadeira</label>
                                        <select class="form-select" id="select-cadeira" required name="cadeira">

                                        </select>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label" for="select-turno">Turno</label>
                                        <select class="form-select" id="select-turno" required name="turno">
                                            <option value="manha">Manhã</option>
                                            <option value="tarde">Tarde</option>
                                            <option value="noite">Noite</option>
                                        </select>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label" for="select-professor">Professor</label>
                                        <select class="form-select" id="select-professor" required name="professor">
                                        </select>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label" for="select-metodo">Método</label>
                                        <select class="form-select" id="select-metodo" required name="metodo-fila">
                                        </select>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label" for="select-data">Data</label>
                                        <input class="form-control" id="select-data" type="date" name="data">
                                    </div>
                                    <div class="col-12">
                                        <label class="form-label" for="select-descricao">Descrição</label>
                                        <textarea class="form-control" id="select-descricao" name="descricao"></textarea>
                                    </div>
                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary" style="width: 100%;">Criar</button>
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
