<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <img src="${resource(dir: 'img', file: 'banner.png')}">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-5 col-sm-offset-1">
            <h4>${welcomeMessage}</h4>
        </div>
        <div class="col-sm-6">
            <g:textField name="phone" class="form-control" placeholder="Enter your cell number to check in" value="${customerInstance?.phone}"/>
            <div class="row"><br/></div>
            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="1" onclick="padKey(this.value)"/>
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="2" onclick="padKey(this.value)"/>
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="3" onclick="padKey(this.value)"/>
                </div>
            </div>
            <div class="row"><br/></div>
            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="4" onclick="padKey(this.value)"/>
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="5" onclick="padKey(this.value)"/>
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="6" onclick="padKey(this.value)"/>
                </div>
            </div>
            <div class="row"><br/></div>
            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="7" onclick="padKey(this.value)"/>
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="8" onclick="padKey(this.value)"/>
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="9" onclick="padKey(this.value)"/>
                </div>
            </div>
            <div class="row"><br/></div>
            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-danger btn-lg btn-block" type="button" name="pad" value="Del" onclick="clearPad()"/>
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="0" onclick="padKey(this.value)"/>
                </div>
                <div class="col-sm-4">
                    <g:submitButton class="btn btn-success btn-lg btn-block" name="pad" value="Go"/>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function padKey(num) {
        document.getElementById("phone").value += num;
    }
    function clearPad() {
        document.getElementById("phone").value = "";
    }
</script>