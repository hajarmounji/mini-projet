import java.sql.*;
public class Gestion_evenements{

    public void update(int id_event,Timestamp date_event ,Connection connexion) {
        try {
            String query = "UPDATE evenements SET date_event = ? WHERE id_event = ?";

            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setTimestamp(1, date_event);
            statement.setInt(2, 2); 

            int rows= statement.executeUpdate();
            if (rows > 0) {
                System.out.println("mise à jour  ");
            } else {
                System.out.println("Aucun evenement trouvé avec  ce id ");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public void supprimer(int id_event, Connection connexion) {
    try {
        String query = "DELETE FROM evenements WHERE  id_event= ?";
        PreparedStatement statement = connexion.prepareStatement(query);
        statement.setInt(1, id_event); 

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println(" tmsah ");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void ajouter(String nom_event, Timestamp date_event, String description, int  id_user,Connection connexion) {
    try {


        boolean allExist = true;

        String qee = "select * FROM utilisateurs   WHERE  id_user= ? ";
        PreparedStatement stt= connexion.prepareStatement(qee);
        stt.setInt(1, id_user); 
        ResultSet rsll = stt.executeQuery();
        if (!rsll.next()) {
            System.out.println("Utilisateur non trouvé !");
             allExist = false;
        }

        if(allExist){
        String query = "INSERT INTO evenements (nom_event, date_event, description, id_user) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connexion.prepareStatement(query);
        statement.setString(1, nom_event);
        statement.setTimestamp(2,date_event);  
        statement.setString(3, description); 
        statement.setInt(4, id_user);                       

        int rows = statement.executeUpdate();
        if (rows> 0) {
            System.out.println("L'evenement  insere avec succes");
        }}
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void afficher(Connection connexion) {
    try {
        Statement stmt = connexion.createStatement();
           String query = "SELECT * FROM  evenements";
         ResultSet rs = stmt.executeQuery(query);
         
           while (rs.next()) {
           System.out.println("ID: " + rs.getInt("id_event"));
            System.out.println("Nom du event : " + rs.getString("nom_event"));
            System.out.println("la date: " + rs.getString("date_event"));
            System.out.println("desc: " + rs.getString("description"));
            System.out.println("id_user: " + rs.getString("id_user"));
            System.out.println("-------------------");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    try {
        Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "");
        Gestion_evenements gestion = new Gestion_evenements();
        gestion.supprimer(1,connexion);
     // gestion.update(3,Timestamp.valueOf("2024-12-09 12:30:00"),connexion);
      // gestion.ajouter("fete", Timestamp.valueOf("2024-12-07 19:30:00"),  "independence", 4,connexion);
    //gestion.afficher(connexion);

        connexion.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}




}
