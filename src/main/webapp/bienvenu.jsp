<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <% if (session.getAttribute("user") == null) { 
        response.sendRedirect("index.jsp");
        return;
    } %>
    <h1>Bienvenue, <%= session.getAttribute("user") %>!</h1>
    Bienvenu<br>
    <a href="index.jsp">retour au page principale</a>
</body>
</html>