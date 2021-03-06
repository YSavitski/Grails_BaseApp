<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'client.label', default: 'Client')}"/>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css"/>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'maps-style.css')}" type="text/css"/>
    <script src="${resource(dir: 'js', file: 'bootstrap.min.js')}" type="text/javascript"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery-3.3.1.min.js')}"></script>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-client" tabindex="-1">
    <g:message code="default.link.skip.label" default="Skip to content&hellip;"/>
</a>

<div class="nav" role="navigation">
    <ul>
        <li>
            <g:form controller="logout">
                <g:submitButton class="btn btn-danger btn-sm" name="logout" value="Logout"/>
            </g:form>
        </li>
        <li>
            <a class="home" href="${createLink(uri: '/')}">
                <g:message code="default.home.label"/>
            </a>
        </li>
        <sec:ifAnyGranted roles="ROLE_ADMIN">
            <li>
                <g:link class="create" action="create">
                    <g:message code="default.new.label" args="[entityName]"/>
                </g:link>
            </li>
            <li>
                <g:link class="create">
                    <g:message message="Upload clients"/>
                    <form enctype="multipart/form-data" name="uploadForm" id="uploadForm" method="post">
                        <input accept=".csv" class="upload" id="file" name="file" type="file">
                        <input type="submit" class="btn btn-primary" value="Upload">
                    </form>
                </g:link>
            </li>
            <li>
                <g:link class="create" controller="user" action="create">
                    <g:message code="default.add.label" args="['new User']"/>
                </g:link>
            </li>
        </sec:ifAnyGranted>
    </ul>
</div>

<div id="list-client" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="name" title="${message(code: 'client.name.label', default: 'Name')}"/>
            <g:sortableColumn property="email" title="${message(code: 'client.email.label', default: 'Email')}"/>
            <g:sortableColumn property="street" title="${message(code: 'client.street.label', default: 'Street')}"/>
            <g:sortableColumn property="zip" title="${message(code: 'client.zip.label', default: 'Zip')}"/>
        </tr>
        </thead>
        <tbody>
        <g:each in="${clients}" status="i" var="client">
            <tr class="${(i % 2 == 0 ? 'even' : 'odd')}">
                <td>
                    <g:link action="show" id="${client.id}">
                        ${fieldValue(bean: client, field: "name")}
                    </g:link>
                </td>
                <td>
                    ${fieldValue(bean: client, field: "email")}
                </td>
                <td>
                    ${fieldValue(bean: client, field: "street")}
                </td>
                <td>
                    ${fieldValue(bean: client, field: "zip")}
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

<h3>Google Maps Demo</h3>

<div id="map" class="container"></div>

<script>
    $('#uploadForm').submit(function (e) {
        e.preventDefault();
        var file = $('#file').val();
        var jForm = new FormData();
        jForm.append("file", $('#file').get(0).files[0]);
        $.ajax({
            url: "client/upload",
            type: "POST",
            data: jForm,
            mimeType: "multipart/form-data",
            contentType: false,
            processData: false,
            success: function (data) {
                alert(data);
                window.location='client/index'
            }
        })
    })
</script>


<script>
    function initMap() {
        var myLatLng = {lat: 53.462949, lng: -2.288996};

        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 13,
            center: myLatLng
        });

        <g:each in="${clients}" var="client">
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
        </g:each>
    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBuVjBBrBoqib2cWPNg-LFuZadj2Fpe_0g&callback=initMap">
</script>
</body>
</html>