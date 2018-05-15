<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="addMethod">

    <h3 class="control-label">For object - ${jsObject.name}</h3>
    <form:form method="post" action="${pageContext.request.contextPath}/method/add"
               class="form-horizontal" modelAttribute="newMethod">
        <div class="control-group">
            <form:input type="hidden" path="methodObject" value="${jsObject.id}"/>
            <form:label path="name">Name</form:label>
            <div class="controls">
                <form:input type="text" id="method_article_name" path="name"/>
            </div>
        </div>
        <div class="control-group">
            <form:label path="description"
                        class="control-label">Description</form:label>
            <div class="controls">
                <form:textarea id="method_article_description" path="description" rows="6"
                               cols="67"/>
            </div>
            <div class="controls">
                <input type="submit" value="OK">
            </div>
        </div>
    </form:form>
</div>