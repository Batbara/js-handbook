<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="addJsObject">
    <form:form method="post" modelAttribute="newJsObject"
               action="${pageContext.request.contextPath}/object/add"
               class="form-horizontal">
        <div class="control-group">
            <label for="article_name" class="control-label">Name</label>
            <div class="controls">
                <form:input type="text" id="article_name" path="name"/>
            </div>
        </div>
        <div class="control-group">
            <label for="js_object_article_description"
                   class="control-label">Description</label>
            <div class="controls">
                <form:textarea id="js_object_article_description" path="description" rows="6"
                               cols="67"/>
            </div>
            <div class="controls">
                <input type="submit" value="OK">
            </div>
        </div>

    </form:form>
</div>