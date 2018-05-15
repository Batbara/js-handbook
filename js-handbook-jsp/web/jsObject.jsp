<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:useBean id="jsObject" class="by.bsuir.talakh.js_object.JsObject" scope="request"/>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <c:import url="/WEB-INF/jsp/styling.jsp"/>
    <title>JS Handbook | ${jsObject}</title>
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
        <div itemscope itemtype="http://schema.org/ComputerLanguage">
            <div class="welcome-header">
                <h2 itemprop="name">${jsObject.name}</h2>
            </div>
            <div class="holder">
                <div class="site-info" itemprop="description">
                    <pre>${jsObject.description}</pre>
                </div>
            </div>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">

                    <div class="control-buttons">
                        <button type="button" class="btn btn-primary" id="addMethodBtn">Add method</button>
                        <button type="button" class="btn btn-primary" id="addJsObjectBtn">Add new JS object</button>
                        <button type="button" class="btn btn-edit" id="editArticleBtn">Edit</button>
                        <form method="post" id="deleteForm" action="${pageContext.request.contextPath}/js"
                              class="form-inline">
                            <input type="hidden" name="command" value="delete_js_object">
                            <input type="hidden" name="id" value="${jsObject.id}">
                            <input type="submit" class="btn btn-danger" id="deleteArticle" value="Delete article">
                        </form>
                    </div>
                    <div class="input-wrapper">
                        <div id="add-article">
                            <div id="addJsObject">
                                <form method="post" action="${pageContext.request.contextPath}/js"
                                      class="form-horizontal">
                                    <div class="control-group">
                                        <input type="hidden" name="command" value="add_js_object">
                                        <label for="article_name" class="control-label">Name</label>
                                        <div class="controls">
                                            <input type="text" id="article_name" name="article_name">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label for="js_object_article_description"
                                               class="control-label">Description</label>
                                        <div class="controls">
                            <textarea id="js_object_article_description" name="article_description" rows="6"
                                      cols="67"></textarea>
                                        </div>
                                        <div class="controls">
                                            <input type="submit" value="OK">
                                        </div>
                                    </div>

                                </form>
                            </div>

                            <div id="addMethod">

                                <h3 class="control-label">For object - ${jsObject.name}</h3>
                                <form method="post" action="${pageContext.request.contextPath}/js"
                                      class="form-horizontal">
                                    <div class="control-group">
                                        <input type="hidden" name="command" value="add_method">
                                        <input type="hidden" name="id" value="${jsObject.id}">
                                        <label for="method_article_name" class="control-label">Name</label>
                                        <div class="controls">
                                            <input type="text" id="method_article_name" name="article_name">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label for="method_article_description"
                                               class="control-label">Description</label>
                                        <div class="controls">
                        <textarea id="method_article_description" name="article_description" rows="6"
                                  cols="67"></textarea>
                                        </div>
                                        <div class="controls">
                                            <input type="submit" value="OK">
                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>
                        <div id="edit-article">
                            <form method="post" action="${pageContext.request.contextPath}/js">
                                <div class="control-group">
                                    <input type="hidden" name="command" value="update_js_object">
                                    <input type="hidden" name="id" value="${jsObject.id}">
                                    <label for="edit_article_description" class="control-label">Description</label>
                                    <div class="controls">
                    <textarea id="edit_article_description" name="article_description" rows="6"
                              cols="67">${jsObject.description}</textarea>
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

