package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import JavaBeans.UserBean;

public class TraiterLoginServlet extends jakarta.servlet.http.HttpServlet {
    static final long serialVersionUID = 1L;

    public TraiterLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gestion du GET si nécessaire
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des paramètres du formulaire de login
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // Initialisation de la réponse
        PrintWriter out = response.getWriter();

        // Création d'une connexion (hypothèse que la classe Connexion existe et gère les opérations de base de données)
        Connexion cnx = new Connexion();

        // Gestion des sessions
        HttpSession session = request.getSession(true);
        HttpSession session1 = request.getSession(true);

        // Récupération de l'action en cours (par exemple, modification du mot de passe)
        String action = (String) session1.getAttribute("page");

        if (action == "modification") {
            System.out.println("En cours de modification");

            // Récupération des informations de l'utilisateur depuis la session
            UserBean user = (UserBean) session.getAttribute("utilisateur");

            // Appel à la méthode de modification
            cnx.modifier(login, password, user.getLogin(), user.getPassword());
            System.out.println("Modification réussie");

            // Réponse à l'utilisateur
            out.println("<P>Modification bien réussie</P>");
            session1.invalidate();
            out.println("<a href='index.jsp'>Accueil</a>");

        } else if (cnx.existeDeja(login, password)) {
            // Si l'utilisateur existe déjà dans la base de données
            System.out.println("L'utilisateur existe. Login: " + login + ", Mot de passe: " + password);
            out.println("<P>L'utilisateur existe déjà</P>");

            // Mise à jour de l'utilisateur dans la session
            UserBean user = new UserBean();
            user.setLogin(login);
            user.setPassword(password);
            session.setAttribute("utilisateur", user);

            // Redirection vers la page utilisateur
            response.sendRedirect(request.getContextPath() + "/users.jsp");

        } else {
            // Si l'utilisateur n'existe pas encore, on l'enregistre
            System.out.println("Cet utilisateur n'existe pas");
            out.println("<P>Cet utilisateur n'existe pas</P>");

            // Enregistrement de l'utilisateur
            cnx.enregistrer(login, password);
            System.out.println("L'utilisateur a été bien enregistré !");
            out.println("<P>L'utilisateur a été bien enregistré !</P>");
            out.println("<a href='index.jsp'>Accueil</a>");
        }
    }
}
