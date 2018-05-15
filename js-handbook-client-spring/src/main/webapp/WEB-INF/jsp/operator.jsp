<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:useBean id="operator" class="by.bsuir.talakh.entity.Operator" scope="request"/>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <c:import url="/WEB-INF/jsp/styling.jsp"/>
    <title>JS Handbook | ${operator}</title>
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
                        <form:form method="post"  id="deleteForm" modelAttribute="operator"
                                   action="${pageContext.request.contextPath}/operator/delete/${operator.id}"
                              class="form-inline">
                            <input type="submit" class="btn btn-danger" id="deleteArticle" value="Delete article">
                        </form:form>
                    </div>
                    <div class="input-wrapper">
                        <div id="add-article">
                            <div id="addOperator">
                                <form:form method="post" modelAttribute="newOperator"
                                           action="${pageContext.request.contextPath}/operator/add"
                                      class="form-horizontal">
                                    <div class="control-group">
                                        <label for="add_symbol" class="control-label">Symbol</label>
                                        <div class="controls">
                                            <form:input  path="operatorSymbol" type="text" id="add_symbol" name="operator_symbol"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label for="article_name" class="control-label">Name</label>
                                        <div class="controls">
                                            <form:input path="name" type="text" id="article_name" name="article_name"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label for="js_object_article_description"
                                               class="control-label">Description</label>
                                        <div class="controls">
                            <form:textarea path="description" id="js_object_article_description" name="article_description" rows="6"
                                      cols="67"/>
                                        </div>
                                        <div class="controls">
                                            <input type="submit" value="OK">
                                        </div>
                                    </div>

                                </form:form>
                            </div>
                        </div>
                        <c:import url="editOperatorForm.jsp"/>
                    </div>

        </div>
    </article>
    <aside>
    </aside>

</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>

