
import java.sql.*;



public class Gestion_salles {
    
        public void supprimer(int id_salle, Connection connexion) {
            try {
                String query = "DELETE FROM salles  WHERE  id_salle= ?";
                PreparedStatement statement = connexion.prepareStatement(query);
                statement.setInt(1, id_salle); 
    
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println(" tmsah ");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        public void ajouter( String nom_salle, int  capacite, Connection connexion) {
            try {
                String query = "INSERT INTO salles ( nom_salle, capacite) VALUES ( ?, ?)";
            PreparedStatement statement = connexion.prepareStatement(query);
 
            statement.setString(1, nom_salle);       
            statement.setInt(2, capacite);       
           
 
            int rows = statement.executeUpdate();
             if (rows > 0) {
                 System.out.println(" tzad");
             }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void afficher(Connection connexion) {
            try {
                Statement stmt = connexion.createStatement();
                String query = "SELECT * FROM  salles";
              ResultSet rs = stmt.executeQuery(query);
              
                while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_salle"));
                 System.out.println("nom_salle: " + rs.getString("nom_salle"));
                 System.out.println("la capacite: " + rs.getString("capacite"));
                 
                 System.out.println("-------------------");
             }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        public static void main(String[] args) {
            try {
                Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "");
                Gestion_salles gestion = new Gestion_salles();
               gestion.supprimer(1,connexion);
              
               //gestion.ajouter("15", 67, connexion);
               //gestion.afficher(connexion);
    
                connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    
    
    
    
    



    

}
