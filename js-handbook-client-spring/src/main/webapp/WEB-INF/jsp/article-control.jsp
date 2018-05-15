<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="control-buttons">
    <button type="button" class="btn btn-primary">Add operator</button>
    <button type="button" class="btn btn-primary" id="addMethodBtn">Add method</button>
    <button type="button" class="btn btn-primary">Add JS object</button>
    <button type="button" class="btn btn-edit">Edit</button>
    <button type="button" class="btn btn-danger">Delete article</button>
</div>
<div id="add-article">
    <div id="addJsObject">
        <form method="post" action="${pageContext.request.contextPath}/object/add">
            <input type="hidden" name="command" value="add">
            <label for="article_name">Name</label>
            <input type="text" id="article_name" name="article_name">

            <label for="article_description">Description</label>
            <textarea id="article_description" name="article_description" rows="6" cols="67"/>
            <input type="submit">
        </form>
    </div>
    <div id="addOperator">
        <form method="post" action="${pageContext.request.contextPath}/operator/add">
            <input type="hidden" name="command" value="add_operator">

            <label for="operator_article_symbol">Symbol</label>
            <input type="text" id="operator_article_symbol" name="operator_symbol">

            <label for="operator_article_name">Name</label>
            <input type="text" id="operator_article_name" name="article_name">

            <label for="operator_article_description">Description</label>
            <textarea id="operator_article_description" name="article_description" rows="6" cols="67"/>
            <input type="submit">
        </form>
    </div>
    <div id="addMethod">
        <form:form method="post" modelAttribute="method" action="${pageContext.request.contextPath}/method/add">

            <form:input type="hidden" path="methodObject" value=""/>

            <form:label path="name">Name</form:label>
            <form:input type="text" id="method_article_name"  path="name"/>

            <form:label path="description">Description</form:label>
            <form:textarea id="method_article_description" path="description" rows="6" cols="67"/>
            <input type="submit">
        </form:form>
    </div>

</div>
<div id="edit-article">

</div>
