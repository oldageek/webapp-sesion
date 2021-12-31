<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/header.jsp" />
<h3>${title}</h3>
<form action="${pageContext.request.contextPath}/usuarios/form-usuario" method="post">
    <div class="row mb-2">
        <label for="username" class="col-form-label col-sm-2">Username</label>
        <div class="col-sm-4">
            <input type="text" name="username" id="username" value="${usuario.username}" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('username')}">
            <div style="color: red;">${errores.get("username")}</small></div>
        </c:if>
    </div>
    <div class="row mb-2">
        <label for="password" class="col-form-label col-sm-2">Password</label>
        <div class="col-sm-4">
            <input type="password" name="password" id="password" value="${usuario.password}" class="form-control">
        </div>
        <c:if test="${errores != null && not empty errores.password}">
            <div style="color: red;">${errores.password}</small></div>
        </c:if>
    </div>
    <div class="row mb-2">
        <label for="email" class="col-form-label col-sm-2">eMail</label>
        <div class="col-sm-4">
            <input type="text" name="email" id="email" value="${usuario.email}" class="form-control">
        </div>
        <c:if test="${errores != null && not empty errores.email}">
            <div style="color: red;">${errores.email}</small></div>
        </c:if>
    </div>
    <div class="row mb-2">
        <div>
            <input class="btn btn-primary" type="submit" value="${usuario.id != null && usuario.id > 0?"Editar":"Crear"}">
        </div>
    </div>
    <input type="hidden" name="id" id="id" value="${usuario.id}" />
</form>
<jsp:include page="layout/footer.jsp" />