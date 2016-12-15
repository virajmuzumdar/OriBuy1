<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>View Product</title>
</head>
<body>
<%@ include file="header.jsp"%>
	<h2>View Products</h2>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Product Name</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Description</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="product" items="${list}">
			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.quantity}</td>
				<td>${product.price}</td>
				<td>${product.description}</td>
				<td><a href="editproduct?id=${product.id}">Edit</a></td>
				<td><a href="deleteproduct?id=${product.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="NewProd">Add New Products</a>

	<%@include file="footer.jsp"%>
</body>
</html>
