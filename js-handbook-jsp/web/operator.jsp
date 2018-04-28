<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:useBean id="operator" class="by.bsuir.talakh.js_operator.Operator" scope="request"/>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <c:import url="/WEB-INF/jsp/styling.jsp"/>
    <title>JS Handbook | ${operator}</title>
</head>
<body>
<div class="main">
    <nav class="side-nav">
        <c:import url="/WEB-INF/jsp/navMenu.jsp"/>
    </nav>
    <article>
        <div>
            <div class="welcome-header">
                <h2>${operator.operatorSymbol} - ${operator.name}</h2>
            </div>
            <div class="holder">
                <div class="site-info">
                    <pre>${operator.description}</pre>
                </div>
            </div>
            <div class="control-buttons">
                <button type="button" class="btn btn-primary" id="addOperatorBtn">Add operator</button>
                <button type="button" class="btn btn-edit" id="editArticleBtn">Edit</button>
                <form method="post" id="deleteForm" action="${pageContext.request.contextPath}/js" class="form-inline">
                    <input type="hidden" name="command" value="delete_operator">
                    <input type="hidden" name="id" value="${operator.id}">
                    <input type="submit" class="btn btn-danger" id="deleteArticle" value="Delete article">
                </form>
            </div>
            <div class="input-wrapper">
                <div id="add-article">
                    <div id="addOperator">
                        <form method="post" action="${pageContext.request.contextPath}/js" class="form-horizontal">
                            <div class="control-group">
                                <input type="hidden" name="command" value="add_operator">
                                <label for="add_symbol" class="control-label">Symbol</label>
                                <div class="controls">
                                    <input type="text" id="add_symbol" name="operator_symbol">
                                </div>
                            </div>
                            <div class="control-group">
                                <label for="article_name" class="control-label">Name</label>
                                <div class="controls">
                                    <input type="text" id="article_name" name="article_name">
                                </div>
                            </div>
                            <div class="control-group">
                                <label for="js_object_article_description" class="control-label">Description</label>
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
                </div>
                <div id="edit-article">
                    <form method="post" action="${pageContext.request.contextPath}/js">
                        <div class="control-group">
                            <input type="hidden" name="command" value="update_operator">
                            <input type="hidden" name="id" value="${operator.id}">
                            <label for="edit_article_description" class="control-label">Description</label>
                            <div class="controls">
                    <textarea id="edit_article_description" name="article_description" rows="6"
                              cols="67">${operator.description}</textarea>
                            </div>
                            <div class="controls">
                                <input type="submit" value="Save">
                            </div>
                        </div>
                    </form>
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

