<jsp:include page="layout/header.jsp"/>
    <h3>${title}</h3>
    <ul class="list-group">
        <li class="list-group-item active">Menu de Opciones</li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath}/usuarios">Usuarios</a></li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath}/productos">Mostrar productos HTML</a></li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath}/logout">Log out</a></li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath}/carro/ver">Ver carro</a></li>
    </ul>
<jsp:include page="layout/footer.jsp"/>