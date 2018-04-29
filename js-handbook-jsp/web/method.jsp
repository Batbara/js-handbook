<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:useBean id="method" class="by.bsuir.talakh.js_method.Method" scope="request"/>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <c:import url="/WEB-INF/jsp/styling.jsp"/>
    <title>JS Handbook | ${method}</title>
</head>
<body>
<header>
    <c:import url="/WEB-INF/jsp/topBar.jsp"/>
</header>
<div class="main">

    <nav class="side-nav">
        <c:import url="/WEB-INF/jsp/navMenu.jsp"/>
    </nav>
    <article>
        <div>
            <div class="welcome-header">
                <h2>${method.name}</h2>
            </div>
            <div class="holder">
                <div class="site-info">
                    <pre>${method.description}</pre>
                </div>
            </div>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">

                    <div class="control-buttons">
                        <button type="button" class="btn btn-edit" id="editArticleBtn">Edit</button>
                        <form method="post" id="deleteForm" action="${pageContext.request.contextPath}/js"
                              class="form-inline">
                            <input type="hidden" name="command" value="delete_method">
                            <input type="hidden" name="id" value="${method.id}">
                            <input type="submit" class="btn btn-danger" id="deleteArticle" value="Delete article">
                        </form>
                    </div>
                    <div class="input-wrapper">
                        <div id="edit-article">
                            <form method="post" action="${pageContext.request.contextPath}/js">
                                <div class="control-group">
                                    <input type="hidden" name="command" value="update_method">
                                    <input type="hidden" name="id" value="${method.id}">

                                    <label for="edit_article_description" class="control-label">Description</label>
                                    <div class="controls">
                    <textarea id="edit_article_description" name="article_description" rows="6"
                              cols="67">${method.description}</textarea>
                                    </div>
                                    <div class="controls">
                                        <input type="submit" value="Save">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="holder">
                        To change content you should authorize first!
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </article>
    <aside>
    </aside>

</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>

