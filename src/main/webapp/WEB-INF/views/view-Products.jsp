<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View Products</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center mb-4">Available Products</h2>

    <c:if test="${not empty products}">
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <div class="d-flex justify-content-between">
        <a href="${pageContext.request.contextPath}/add-product" class="btn btn-success">Add Product</a>
        <a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Home</a>
    </div>
</div>

</body>
</html>
