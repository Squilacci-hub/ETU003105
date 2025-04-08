package servlet.service;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entities.Depense;

public class DepenseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    String montantStr = request.getParameter("montant");
    String previsionIdStr = request.getParameter("depense");
    
    
    if (montantStr == null || montantStr.trim().isEmpty() || 
        previsionIdStr == null || previsionIdStr.trim().isEmpty()) {
        response.sendRedirect("erreur.jsp?message=Champs%20manquants");
        return;
    }

    try {
        float montant = Float.parseFloat(montantStr);
        int previsionId = Integer.parseInt(previsionIdStr);
        
        
        if (montant <= 0 || previsionId <= 0) {
            response.sendRedirect("erreur.jsp?message=Valeurs%20invalides");
            return;
        }
        
        Depense depense = new Depense(montant, previsionId);
        boolean success = depense.insertDepense(depense);
        
        if (success) {
            response.sendRedirect("bienvenu.jsp");
        } else {
            response.sendRedirect("erreur.jsp?message=Erreur%20d'insertion");
        }
        
    } catch (NumberFormatException e) {
        response.sendRedirect("erreur.jsp?message=Format%20numérique%20invalide");
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("erreur.jsp?message=Erreur%20serveur");
    }
}
}
