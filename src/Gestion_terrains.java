
import java.sql.*;


public class Gestion_terrains {
    
    
    
        public void supprimer(int id_terrain, Connection connexion) {
            try {
                String query = "DELETE FROM  terrains WHERE  id_terrain= ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, id_terrain); 

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(" tmsah ");
            }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        public void ajouter( String nom_terrain, String  type, Connection connexion) {
            try {
                String query = "INSERT INTO terrains ( nom_terrain, type) VALUES ( ?, ?)";
            PreparedStatement statement = connexion.prepareStatement(query);
 
            statement.setString(1, nom_terrain);       
            statement.setString(2, type);       
           
 
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
                String query = "SELECT * FROM  terrains";
              ResultSet rs = stmt.executeQuery(query);
              
                while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_terrain"));
                 System.out.println("nom_salle: " + rs.getString("nom_terrain"));
                 System.out.println("la capacite: " + rs.getString("type"));
                 System.out.println("-------------------");
             }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        public static void main(String[] args) {
            try {
                Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "");
                Gestion_terrains gestion = new Gestion_terrains();
               gestion.supprimer(1,connexion);
              
               //gestion.ajouter("adrar", "foot", connexion);
              // gestion.afficher(connexion);
    
                connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    
    
    
    
    



    
/* /////////////////////////////////////////     delete terrains   ////////////////////////////////////////////////////////////


            String query = "DELETE FROM  terrains WHERE  id_terrain= ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, 2); 

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(" tmsah ");
            }





*/










            
        //////////////////////////////  select    terrain   ///////////////////:::::::    
          /*   Statement stmt = connexion.createStatement();
            String query = "SELECT * FROM  terrains";
          ResultSet rs = stmt.executeQuery(query);
          
            while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id_terrain"));
             System.out.println("nom_salle: " + rs.getString("nom_terrain"));
             System.out.println("la capacite: " + rs.getString("type"));
             System.out.println("-------------------");
         }

         */ 









            ////////////////  insrt terrain ////////////////////////////////////////////////////////////
             
     /*    String query = "INSERT INTO terrains ( nom_terrain, type) VALUES ( ?, ?)";
            PreparedStatement statement = connexion.prepareStatement(query);
 
            statement.setString(1, "ppppppp");       
            statement.setString(2, "ppppppp");       
           
 
            int rows = statement.executeUpdate();
             if (rows > 0) {
                 System.out.println(" tzad");
             } 




 */



}
