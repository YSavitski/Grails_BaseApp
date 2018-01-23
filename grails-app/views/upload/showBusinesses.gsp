<!doctype html>

<html>
<head>
    <title>Products List</title>
    <style>
        #map {
            width: 710px;
            height: 400px;
            background-color: grey;
        }
    </style>
</head>

<body>
<table border="1">
    <g:each in="${listBusinesses}" var="business">
        <tr>
            <td>${business.name}</td>
            <td>${business.latitude}</td>
            <td>${business.longitude}</td>
        </tr>
    </g:each>
</table>

<h3>Google Maps Demo</h3>
<div id="map"></div>

<script>
    function initMap() {
        var myLatLng = {lat: 40.7143528, lng: -74.0059731 };

        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 10,
            center: myLatLng
        });

        <g:each in="${listBusinesses}" var="business">
            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(${business.latitude}, ${business.longitude}),
                map: map
            });

            marker.info = new google.maps.InfoWindow({
                content: "${business.name}"
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