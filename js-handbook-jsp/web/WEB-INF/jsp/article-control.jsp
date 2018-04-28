<div class="control-buttons">
    <button type="button" class="btn btn-primary">Add operator</button>
    <button type="button" class="btn btn-primary" id="addMethodBtn">Add method</button>
    <button type="button" class="btn btn-primary">Add JS object</button>
    <button type="button" class="btn btn-edit">Edit</button>
    <button type="button" class="btn btn-danger">Delete article</button>
</div>
<div id="add-article">
    <div id="addJsObject">
        <form method="post" action="${pageContext.request.contextPath}/js">
            <input type="hidden" name="command" value="add">
            <label for="article_name">Name</label>
            <input type="text" id="article_name" name="article_name">

            <label for="article_description">Description</label>
            <textarea id="article_description" name="article_description" rows="6" cols="67"/>
            <input type="submit">
        </form>
    </div>
    <div id="addOperator">
        <form method="post" action="${pageContext.request.contextPath}/js">
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
        <form method="post" action="${pageContext.request.contextPath}/js">
            <input type="hidden" name="command" value="add_method">
            <input type="hidden" name="objectId" value="">

            <label for="method_article_name">Name</label>
            <input type="text" id="method_article_name" name="article_name">

            <label for="method_article_description">Description</label>
            <textarea id="method_article_description" name="article_description" rows="6" cols="67"/>
            <input type="submit">
        </form>
    </div>

</div>
<div id="edit-article">

</div>
