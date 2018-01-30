<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: '${client}.label', default: 'Client')}" />
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css"/>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'maps-style.css')}" type="text/css"/>
    <script src="${resource(dir: 'js', file: 'bootstrap.min.js')}" type="text/javascript"></script>
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-${client}" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
        <sec:ifAnyGranted roles="ROLE_ADMIN">
            <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
        </sec:ifAnyGranted>
    </ul>
</div>
<div id="show-${client}" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:display bean="${client}" />
    <sec:ifAnyGranted roles="ROLE_ADMIN">
        <g:form resource="${client}" method="DELETE">
            <fieldset class="buttons">
                <g:link class="edit" action="edit" resource="${client}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
            </fieldset>
        </g:form>
    </sec:ifAnyGranted>
</div>

<h3>Google Maps Demo</h3>

<div id="map" class="container"></div>

<script>
    function showMap() {
        var myLatLng = {lat: ${client.latitude}, lng: ${client.longitude}};

        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 15,
            center: myLatLng
        });

        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(${client.latitude}, ${client.longitude}),
            map: map
        });

        marker.info = new google.maps.InfoWindow({
            content: "${client.name}"
        });

        google.maps.event.addListener(marker, 'click', function () {
            var marker_map = this.getMap();
            this.info.open(marker_map, this);
        });
    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBuVjBBrBoqib2cWPNg-LFuZadj2Fpe_0g&callback=showMap">
</script>
</body>
</html>
