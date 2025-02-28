<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center mb-4">Add Product Here</h2>

    <form action="process-form" method="post">
        <div class="form-group">
            <label for="productName">Product Name</label>
            <input type="text"
                   class="form-control"
                   id="productName"
                   name="name"
                   placeholder="Enter Product Name"
                   required>
        </div>
        <div class="form-group">
            <label for="productDescription">Product Description</label>
            <input type="text"
                   class="form-control"
                   id="productDescription"
                   name="description"
                   placeholder="Enter Product Description"
                   required>
        </div>
        <div class="form-group">
            <label for="productPrice">Product Price</label>
            <input type="number"
                   class="form-control"
                   id="productPrice"
                   name="price"
                   placeholder="Product Price"
                   required>
        </div>
        <div class="d-flex justify-content-between">
            <a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
            <button type="submit" class="btn btn-primary">Add</button>
        </div>
    </form>
</div>

</body>
</html>
