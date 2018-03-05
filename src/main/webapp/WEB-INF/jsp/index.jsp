<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet">

    <title>Welcome! | Questionnaire [QSTN]</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div class="container-fluid text-center">
        <div class="row content">
            <div class="col-sm-2 sidenav">

            </div>
            <div class="col-sm-8 text-left">
                <h1>Welcome to Questionnaire!</h1>

            </div>
            <div class="col-sm-2 sidenav">

            </div>
        </div>
    </div>
</main>
<footer class="container-fluid text-centerfooter">
    <p>Footer Text</p>
</footer>
</body>
</html>
