<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.Prevision,java.util.List" %>
<%
    // String id = request.getParameter("id");
    String montant = request.getParameter("montant");
    String prevision_id = request.getParameter("depense");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Depense</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        form { max-width: 400px; margin: 0 auto; }
        label { display: block; margin-top: 10px; }
        input, select { width: 100%; padding: 8px; margin: 5px 0 15px; }
        input[type="submit"] { background: #4CAF50; color: white; border: none; padding: 10px; cursor: pointer; }
    </style>
</head>
<body>
    <h1>Faites vos depenses</h1>
    <form action="ajoutdepense" method="post">

        <label for="nom">Montant:</label>
        <input type="number" id="montant" name="montant">
        
        <label for="depense">Depense libelle:</label>
        <select id="depense" name="depense">
            <option value="">-- Sélectionnez --</option>

            <%
                Prevision p = new Prevision();
                List<Prevision> prev = p.getAllPrevisions();
                for (Prevision prevision : prev) {
                    
            %>
            <option value="<%= prevision.getIdPrevision() %>">
                <%= prevision.getLibelle() %>
            </option>
            <% } %>
        </select>
        
        <input type="submit" value="valider">
    </form>
    <a href="index.jsp">Retour à la liste</a>
</body>
</html>