package servlet.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// import dao.UserDAO;
import entities.User;

public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.getSession().setAttribute("error", "Veuillez remplir tous les champs");
            response.sendRedirect("index.jsp");
            return;
        }

        User u = new User(username, password);
        
        if(u.checkUser(u)) {
        
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            
            response.sendRedirect("bienvenu.jsp");
        }
        else {

            request.getSession().setAttribute("error", "Identifiant ou mot de passe incorrect");
            response.sendRedirect("index.jsp");
        }
    }
}