<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Page d'Accueil</title>
</head>
<body>
    <h1>Bienvenue</h1>
    
    <% if (session.getAttribute("error") != null) { %>
        <div style="color:red;">
            <%= session.getAttribute("error") %>
        </div>
        <% session.removeAttribute("error"); %>
    <% } %>
    
    <% if (session.getAttribute("user") != null) { %>
        
        <% response.sendRedirect("bienvenu.jsp"); %>
    <% } else { %>
    
        <a href="depense.jsp">depense</a><br>
        <a href="prevision.jsp">prevision</a><br>
        <a href="login.jsp">Se connecter</a>
    <% } %>
</body>
</html>