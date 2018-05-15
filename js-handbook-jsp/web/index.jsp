<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">

    <%@ include file="WEB-INF/jsp/styling.jsp" %>
    <title>JS Handbook</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/jsp/topBar.jsp"/>
    <c:set var="test1" value="PAGE_SCOPE" scope="page"/>
    <c:set var="test2" value="SESSION_SCOPE" scope="session"/>
    <c:set var="test3" value="REQUEST_SCOPE" scope="request"/>
    <c:set var="test4" value="APPLICATION_SCOPE" scope="application"/>
</header>
<div class="main">
    <nav class="side-nav">
        <c:import url="/WEB-INF/jsp/navMenu.jsp"/>
    </nav>
    <article>
        <div>
            <div class="welcome-header">
                <h1>Welcome to JS Handbook project!</h1>
            </div>
            <div class="holder">
                <div class="site-info" id="content">
                    Here you can gain crucial information about Java Script. And  make yourself useful: edit, add, delete articles!
                </div>

            </div>
        </div>
    </article>
    <aside>
    </aside>

</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
