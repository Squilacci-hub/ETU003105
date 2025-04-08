package servlet.service;

import java.io.IOException;
import java.io.PrintWriter;


import database.DatabaseConnection;
import entities.Prevision;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PrevisionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    
        try {
            String libelle = request.getParameter("libelle");
            String montantStr = request.getParameter("montant");

            if ( montantStr == null || libelle == null) {
                out.println("<b>Tous les champs sont obligatoires</b>");
                return;
            }
    
            Float montant = Float.parseFloat(montantStr);
            Prevision p = new Prevision(libelle, montant);
            
            boolean result = p.insertPrevision(p);
    
            if (result) {
                response.sendRedirect("bienvenu.jsp");
            } else {
                out.println("<b>Échec de la transaction - vérifiez les données</b>");
                DatabaseConnection.testConnection();
            }
        } catch (NumberFormatException e) {
            out.println("<b>Montant invalide</b>");
        } catch (Exception e) {
            out.println("<b>Erreur système - contactez l'administrateur</b>");
            e.printStackTrace();
        }
    }
    
    
    
}
