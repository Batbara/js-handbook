<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<nav class="top-navbar">
    <ul class="main-nav">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <li>
                    <span class="nav-item"> You are logged as ${sessionScope.user.fullName}</span>
                </li>
                <li>
                    <a href="/js?command=logout">Log out</a>
                </li>
            </c:when>
            <c:otherwise>
                <li>
                    <span class="nav-item">Authorize</span>

                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/js?command=auth_vk">
                        <img src="/img/vk.png" alt="vk_logo" width="30" height="30">
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/js?command=auth_google">
                        <img src="/img/google-logo.png" alt="google_logo" width="30" height="30">
                    </a>
                </li>

            </c:otherwise>
        </c:choose>
    </ul>
</nav>