import java.sql.*;

public class Gestion_Utilisateurs {

    public void supprimer(int id_User, Connection connexion) {
        try {
             String query = "DELETE FROM utilisateurs WHERE id_user = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, id_User);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Utilisateur supprimé ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouter(String nom, String prenom, String email, String type,Connection connexion) {
        try {
            String query = "INSERT INTO utilisateurs (nom, prenom, email, type) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connexion.prepareStatement(query);

            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, email);
            statement.setString(4, type);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Utilisateur ajouté ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void afficher(Connection connexion) {
        try {
            String query = "SELECT * FROM utilisateurs";
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_user"));
                System.out.println("Nom: " + rs.getString("nom"));
                System.out.println("Prénom: " + rs.getString("prenom"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("-------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "");
            Gestion_Utilisateurs gestion = new Gestion_Utilisateurs();
           // gestion.supprimer(3,connexion);
          
           //gestion.ajouter("imane", "ennaji", "imane@example.com", "ETUDIANT",connexion);
            gestion.afficher(connexion);

            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    



}
