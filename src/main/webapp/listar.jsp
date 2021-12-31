<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/header.jsp"/>
    <h3>${title}</h3>
    <c:if test="${username.present}">
        <div class="alert alert-info">Hola ${username.get()}, Bienvenido</div>
        <p><a class="btn btn-primary" href="${pageContext.request.contextPath}/productos/form">Crear [+]</a></p>
    </c:if>
    <table class="table table-hover table-striped">
        <tr>
            <th>id</th>
            <th>nombre</th>
            <th>tipo</th>
            <c:if test="${username.present}">
            <th>precio</th>
            <th>agregar</th>
            <th>editar</th>
            <th>eliminar</th>
            </c:if>
        </tr>
        <c:forEach items="${productos}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.nombre}</td>
            <td>${p.categoria.nombre}</td>
            <c:if test="${username.present}">
            <td><c:out value="${p.precio}"/></td>
            <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/carro/agregar?id=${p.id}">Agregar al carro</a></td>
            <td><a class="btn btn-sm btn-success"href="${pageContext.request.contextPath}/productos/form?id=${p.id}">Editar</a></td>
            <td><a class="btn btn-sm btn-danger" onclick="return confirm('esta seguro que desea eliminar?')"
            href="${pageContext.request.contextPath}/productos/eliminar?id=${p.id}">Eliminar</a></td>
            </c:if>
        </tr>
        </c:forEach>
    </table>
    <p>${applicationScope.mensaje}</p>
    <p>${requestScope.mensaje}</p>
<jsp:include page="layout/footer.jsp"/>