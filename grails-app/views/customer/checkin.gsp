<!doctype html>
<html>

<head>
    <title>Kiosk</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css"/>
    <script src="${resource(dir: 'js', file: 'bootstrap.min.js')}" type="text/javascript"></script>
</head>

<body>
    <g:form url="[resource:customerInstance, action:'customerLookup']">
        <g:render template="kioskForm"/>
    </g:form>
</body>
</html>