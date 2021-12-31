<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/header.jsp" />
    <h3>${title}</h3>
    <c:if test="${requestScope.username.isPresent()}">
        <div class="my-2">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/usuarios/form-usuario">Crear [+]</a>
        </div>
    </c:if>
    <table class="table table-hover table-striped">
        <tr>
            <th>id</th>
            <th>nombre</th>
            <th>email</th>
            <c:if test="${username.present}">
                <th>editar</th>
                <th>eliminar</th>
            </c:if>
        </tr>
        <c:forEach items="${usuarios}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.username}</td>
                <td>${u.email}</td>
                <c:if test="${username.present}">
                    <td><a class="btn btn-success" href="${pageContext.request.contextPath}/usuarios/form-usuario?id=<c:out value="${u.id}" />">editar</a></td>
                    <td><a class="btn btn-danger" onclick="return confirm('Está seguro que desea eliminar?');"
                           href="${pageContext.request.contextPath}/usuarios/eliminar?id=${u.id}">eliminar</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
<jsp:include page="layout/footer.jsp" />