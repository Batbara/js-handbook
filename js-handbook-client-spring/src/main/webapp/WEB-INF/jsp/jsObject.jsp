<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:useBean id="jsObject" class="by.bsuir.talakh.entity.JsObject" scope="request"/>

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
        <div>
            <div class="welcome-header">
                <h2>${jsObject.name}</h2>
            </div>
            <div class="holder">
                <div class="site-info">
                    <pre>${jsObject.description}</pre>
                </div>
            </div>
                    <div class="control-buttons">
                        <button type="button" class="btn btn-primary" id="addMethodBtn">Add method</button>
                        <button type="button" class="btn btn-primary" id="addJsObjectBtn">Add new JS object</button>
                        <button type="button" class="btn btn-edit" id="editArticleBtn">Edit</button>
                        <form:form method="post" id="deleteForm"
                                   action="${pageContext.request.contextPath}/object/delete/${jsObject.id}"
                              class="form-inline">
                            <input type="submit" class="btn btn-danger" id="deleteArticle" value="Delete article">
                        </form:form>
                    </div>
                    <div class="input-wrapper">
                        <div id="add-article">
                            <c:import url="addNewJsObject.jsp"/>
                            <c:import url="addMethod.jsp"/>

                        </div>
                        <div id="edit-article">
                            <form:form method="post" modelAttribute="jsObject"
                                       action="${pageContext.request.contextPath}/object/update/${jsObject.id}">
                                <div class="control-group">
                                    <form:input type="hidden" path="id" />
                                    <form:input type="hidden" path="name" />
                                    <label for="edit_article_description" class="control-label">Description</label>
                                    <div class="controls">
                    <form:textarea id="edit_article_description" path="description" rows="6" cols="67"/>
                                    </div>
                                    <div class="controls">
                                        <input type="submit" value="Save">
                                    </div>
                                </div>
                            </form:form>
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

