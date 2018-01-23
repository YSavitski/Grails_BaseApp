<!doctype html>
<html>
<head>
    <title>Upload file</title>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery-3.3.1.min.js')}"></script>

</head>

<body>
    <form enctype="multipart/form-data" id="demoform" method="post" name="demoform">
        <input accept=".csv" class="upload" id="file" name="file" type="file">
        <input type="submit" class="upload" value="Upload">
    </form>
</body>


<script>
    $('#demoform').submit(function (e) {
        e.preventDefault();
        var file = $('#file').val();
        var jForm = new FormData();
        jForm.append("file", $('#file').get(0).files[0]);
        $.ajax({
            url: "uploadFile",
            type: "POST",
            data: jForm,
            mimeType: "multipart/form-data",
            contentType: false,
            processData: false,
            success: function (data) {
                alert(data);
                window.location='showBusinesses'
            }
        })
    })
</script>
</html>