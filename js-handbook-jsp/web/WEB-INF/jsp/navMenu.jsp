<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="jsObjectList" type="java.util.List<by.bsuir.talakh.js_object.JsObject>"
             scope="request"/>
<jsp:useBean id="operatorList" type="java.util.List<by.bsuir.talakh.js_operator.Operator>"
             scope="request"/>
<h3>JS Objects</h3>
<div class="js-objects-list nav-tree scroll" id="objectList">

    <ul>
        <c:forEach items="${jsObjectList}" var="jsObject">
            <li>
                <a href="${pageContext.request.contextPath}/js?command=take_js_object&id=${jsObject.id}">${jsObject.name}</a>
                <ul>
                    <c:forEach items="${jsObject.methodList}" var="method">
                        <li>
                            <a href="${pageContext.request.contextPath}/js?command=take_method&id=${method.id}">${method.name}</a>
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </c:forEach>
    </ul>
</div>

<h3>JS Operators</h3>
<div class="operators-list nav-tree scroll" id="operatorList">
    <ul>
        <c:forEach items="${operatorList}" var="operator">
            <li>
                <a href="${pageContext.request.contextPath}/js?command=take_operator&id=${operator.id}">
                    <b>${operator.operatorSymbol}</b> - ${operator.name}
                </a>
            </li>
        </c:forEach>
    </ul>
</div>