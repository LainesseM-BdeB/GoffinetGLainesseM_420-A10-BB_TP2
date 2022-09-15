<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Homepage</title>
	<link href="${pageContext.request.contextPath}/templates/css/test.css" rel="stylesheet">
</head>
<body>
<h1>Car Rental</h1>
	<%@include file="component/carTable.jsp"%>
</body>
</html>