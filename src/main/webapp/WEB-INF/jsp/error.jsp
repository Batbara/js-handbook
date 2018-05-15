<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <c:import url="styling.jsp"/>
    <title>JS Handbook</title>
</head>
<body>
<header>
    <c:import url="topBar.jsp"/>
</header>
<div class="main">
    <nav class="side-nav">
        <c:import url="navMenu.jsp"/>
    </nav>
    <article>
        <div>
            <div class="welcome-header">
                <h1>${errorMessage}</h1>
            </div>

        </div>
    </article>
    <aside>
    </aside>

</div>
<c:import url="footer.jsp"/>
</body>
</html>
