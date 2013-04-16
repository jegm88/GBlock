<%-- 
    Document   : index
    Created on : 11/04/2013, 08:08:31 PM
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
        <link href="Imagenes/gb.png"/>
        <title>Login</title>
    </head>
    <body>
        
        
        <h:form id="formulario">
            
            <header id="hi"><h4>Login GBlock</h4></header>
            <f:facet name="header">
                <h:outputText value="Login GBlock"/>
            </f:facet>
            <table>
                <td>
                    Usuario <h:inputText value="#{loginEBean.usuario.nick}"></h:inputText>
                    <h:commandButton value="Iniciar" action="#{loginEBean.login()}"/>
                </td>
                <td>
                    Password <h:inputSecret value="#{loginEBean.usuario.password}"></h:inputSecret>
                    <h:commandButton value="Cancelar" type="reset"/>
                </td>
                    
                    
            </table>
            <f:facet name="footer">
                <h:outputText value="Proyecto GBlock"/>
            </f:facet>
            
        </h:form>
        
    </body>
</html>
</f:view>
