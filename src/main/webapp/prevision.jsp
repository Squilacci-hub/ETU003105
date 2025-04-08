<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Département</title>
</head>
<body>
    <h1>Ajouter vos Previsions</h1>
    <form action="ajoutprevision" method="post">
        <label for="libelle">Libelle :</label>
        <input type="text" id="libelle" name="libelle" required>
        <br><br>
        <label for="montant">Montant :</label>
        <input type="number" id="montant" name="montant" required>
        <input type="submit" value="Valider">
    </form>
    <br>
    <a href="index.jsp">Retour à l'accueil</a>
</body>
</html>