<html>
<head>
    <title>Vehicles</title>
    <meta name="layout" content="main" />
</head>
<body>
<div id="content" role="main">
    <ul>
        <li><g:link controller="vehicle" action="manufacturer" params="[name: 'audi']">Audi</g:link></li>
        <li><g:link controller="vehicle" action="manufacturer" params="[name: 'ford']">Ford</g:link></li>
    </ul>
    <ul id="vehicleList">
    <g:each var="name" in="${vehicleList}">
        <li>${name}</li>
    </g:each>
    </ul>
</div>
</body>
</html>