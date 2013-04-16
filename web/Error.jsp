<%-- 
    Document   : Error
    Created on : 12/04/2013, 10:51:04 PM
    Author     : FGulfo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Estilo/style.css" rel="stylesheet" type="text/css"/>
        <title>Error</title>
    </head>
    <body>
        
        <h:form id="error">
            
            <h:outputText value="Error: usuario #{loginEBean.usuario.nick} no existe!"/>
            <h:commandButton value="Aceptar" action="#{loginEBean.regresar()}"/>
            
        </h:form>
        
    </body>
</html>
</f:view>
