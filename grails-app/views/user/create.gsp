<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'client.label', default: 'Client')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<a href="#create-${user}" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                  default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>

<div id="create-${user}" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${user}">
        <ul class="errors" role="alert">
            <g:eachError bean="${user}" var="error">
                <li <g:if test="${user in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <g:form url="[resource: client, action: 'save']" method="POST">
        <fieldset class="buttons">
            <g:actionSubmit class="save" action="save" value="${message(code: 'default.button.create.label', default: 'Save')}"/>
        </fieldset>
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: user, field: 'username', 'error')}">
                <label for="username">
                    <g:message code="client.name.label" default="Name"/>
                </label>
                <g:textField name="username" value="${user?.username}" />
            </div>

            <div class="fieldcontain ${hasErrors(bean: user, field: 'role', 'error')}">
                <label for="role">
                    <g:message code="client.name.label" default="Role"/>
                </label>
                %{--<g:textField name="role" value="${user?.role}"/>--}%
                <g:select name="role" from="${roles}" value="${user?.role}"/>
            </div>
        </fieldset>
    </g:form>
</div>
</body>
</html>
