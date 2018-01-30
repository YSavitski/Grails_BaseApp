<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'client.label', default: 'Client')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<a href="#create-${client}" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                        default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="create-${client}" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${client}">
        <ul class="errors" role="alert">
            <g:eachError bean="${client}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <g:form url="[resource: client, action: 'save']" method="POST">
        <fieldset class="buttons">
            <g:actionSubmit class="save" action="save" value="${message(code: 'default.button.create.label', default: 'Save')}"/>
        </fieldset>
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: client, field: 'name', 'error')}">
                <label for="name">
                    <g:message code="client.name.label" default="Name"/>
                </label>
                <g:textField name="name" value="${client?.name}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: client, field: 'email', 'error')}">
                <label for="email">
                    <g:message code="client.email.label" default="Email"/>
                </label>
                <g:textField name="email" value="${client?.email}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: client, field: 'street', 'error')}">
                <label for="street">
                    <g:message code="client.street.label" default="Street"/>
                </label>
                <g:textField name="street" value="${client?.street}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: client, field: 'zip', 'error')}">
                <label for="zip">
                    <g:message code="client.zip.label" default="Zip"/>
                </label>
                <g:textField name="zip" value="${client?.zip}"/>
            </div>
        </fieldset>
    </g:form>
</div>
</body>
</html>
