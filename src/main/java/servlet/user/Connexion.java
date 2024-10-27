package servlet.user;
import java.sql.*;
public class Connexion {
    private Connection connexion;
    private Statement instruction;
    protected ResultSet résultat;
    public Connexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion =
                    DriverManager.getConnection("jdbc:mysql://localhost/base","root",
                            "");
            instruction = connexion.createStatement();
            System.out.println("connexion etablie");
        }
        catch (ClassNotFoundException ex) {
            System.err.println("Problème de pilote");
        }
        catch (SQLException ex) {
            System.err.println("Base de données non trouvée ou requête incorrecte");
        }
    }
    public void lire(String requête) {
        try {
            résultat = instruction.executeQuery(requête);
        }
        catch (SQLException ex) {
            System.err.println("Requête incorrecte "+requête);
        }
    }
    public void miseAJour(String requête) {
        try {
            instruction.executeUpdate(requête);
        }
        catch (SQLException ex) {
            System.err.println("Requête incorrecte "+requête);
        }
    }
    public boolean suivant() {
        try {
            return résultat.next();
        } catch (SQLException ex) {
            return false;
        }
    }
    public void enregistrer(String login,String password) {
        miseAJour("INSERT INTO users (login,password) VALUES ('"+login+"','"+password+"')");
    }
    public void modifier(String newlogin,String newpassword,String
            login,String password) {
        miseAJour("UPDATE users SET login = '"+newlogin+"',password='"+newpassword+"' where login = '"+login+"' and password = '"+password+"'");
    }
    public boolean existeDeja(String login,String password) {
        lire("SELECT * FROM users where login = '"+login+"' and password = '"+password+"'");
        return suivant();
    }
    public void arrêt() {
        try {
            connexion.close();
        }
        catch (SQLException ex) {
            System.err.println("Erreur sur larrêt de la connexion à la base de données");
        }
    }
}