<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="edit-article">
    <form:form method="post" modelAttribute="operator"
               action="${pageContext.request.contextPath}/operator/update/${operator.id}">
        <div class="control-group">
            <form:input type="hidden" path="id" />
            <form:input type="hidden" path="operatorSymbol" />
            <form:input type="hidden" path="name" />
            <label for="edit_article_description" class="control-label">Description</label>
            <div class="controls">
                <form:textarea path="description" id="edit_article_description" name="article_description" rows="6"
                               cols="67"/>
            </div>
            <div class="controls">
                <input type="submit" value="Save">
            </div>
        </div>
    </form:form>
</div>