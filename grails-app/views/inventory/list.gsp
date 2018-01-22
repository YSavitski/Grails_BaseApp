<!doctype html>

<html>
<head>
    <title>Products List</title>
</head>

<body>
    <table border="1">
        <g:each in="${allProducts}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.sku}</td>
                <td>${product.price}</td>
            </tr>
        </g:each>
    </table>
</body>
</html>