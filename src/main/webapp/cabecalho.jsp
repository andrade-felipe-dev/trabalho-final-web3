<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav>
    <div class="nav-wrapper light-blue darken-3">
        <a href="/" class="brand-logo center">Help Desk</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="/">Inicío</a></li>
            <li><a href="/tickets/listar">Tickets</a></li>

            <c:if test="${cookie.type.getValue() == 'ADMIN'}">
                <li><a href="/reports/listar">Relatórios</a></li>
            </c:if>
            <li><a href="/login">Sair</a></li>
        </ul>
    </div>
</nav>