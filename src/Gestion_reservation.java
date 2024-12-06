

import java.sql.*;
public class Gestion_reservation {





    

    public void testdisterr(int id_terrain,Timestamp date_reservation ,Connection connexion) {
        try {


            boolean Exist=true;
       String q = "select * FROM terrains   WHERE  id_terrain= ? ";
       PreparedStatement stat= connexion.prepareStatement(q);
       stat.setInt(1, id_terrain); 
       ResultSet rs = stat.executeQuery();
       if (!rs.next()) {
           System.out.println("terrain non trouvé !");
           Exist = false;
       }
if(Exist){
            String query = "select * FROM reservations   WHERE  id_terrain= ? and date_reservation=?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1,id_terrain); 
            statement.setTimestamp(2, date_reservation); 

            ResultSet r = statement.executeQuery();
            if (r.next()) {
                System.out.println(" terrain  n'est pas disponible ");}
                else
                { System.out.println(" terrain disponible ");}

 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void testdissalles(int id_salle,Timestamp date_reservation ,Connection connexion) {
        try {
            boolean a= true;

            String qu= "SELECT * FROM salles WHERE id_salle = ?";
            PreparedStatement s = connexion.prepareStatement(qu);
            s.setInt(1, id_salle);
            
            ResultSet r = s.executeQuery();
            if (!r.next()) {
                System.out.println("salle non trouvé !");
                a= false;
            }

      if(a){

            String query = "select * FROM reservations   WHERE  id_salle= ? and date_reservation=?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, id_salle); 
            statement.setTimestamp(2, date_reservation); 

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println(" la salle   n' est pas disponible ");}
                else
                { System.out.println(" la salle  disponible ");}
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void update(int id_reservation,Timestamp date_reservation ,Connection connexion) {
        try {
            String query = "UPDATE reservations SET date_reservation = ? WHERE id_reservation = ?";

            PreparedStatement statement = connexion.prepareStatement(query);

            
            statement.setTimestamp(1, date_reservation);
            statement.setInt(2, id_reservation); 

            int rows= statement.executeUpdate();
            if (rows > 0) {
                System.out.println("L'heure updated");
            } else {
                System.out.println("Aucun changement");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public void supprimer(int id_reservation, Connection connexion) {
            try {
                String query = "DELETE FROM  reservations WHERE  id_reservation= ?";
                PreparedStatement statement = connexion.prepareStatement(query);
                statement.setInt(1, id_reservation); 
    
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println(" tmsah ");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        public void ajouter(int id_user, int id_event,int id_salle,int id_terrain, Timestamp date_reservation ,Connection connexion) {
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

/////////////////////////////////////////////////////////////////////////////////////

String qe = "select * FROM evenements   WHERE  id_event= ? ";
            PreparedStatement st= connexion.prepareStatement(qe);
            st.setInt(1, id_event); 
            ResultSet rsl = st.executeQuery();
            if (!rsl.next()) {
                System.out.println("evenement non trouvé !");
                allExist = false;
            }


////////////////////////////////////////////////////////////////////////////


String qu= "SELECT * FROM salles WHERE id_salle = ?";
PreparedStatement s = connexion.prepareStatement(qu);
s.setInt(1, id_salle);

ResultSet r = s.executeQuery();
if (!r.next()) {
    System.out.println("salle non trouvé !");
    allExist = false;
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////
      

       String q = "select * FROM terrains   WHERE  id_terrain= ? ";
            PreparedStatement stat= connexion.prepareStatement(q);
            stat.setInt(1, id_terrain); 
            ResultSet rs = stat.executeQuery();
            if (!rs.next()) {
                System.out.println("terrain non trouvé !");
                allExist = false;
            }



////////////////////////////////////////////////////////////////////////////////////////////////////////
  
if (allExist) {
    
String query = "INSERT INTO reservations ( id_user, id_event, id_salle, id_terrain, date_reservation) VALUES ( ?,   ?,   ?,  ?, ?  )";
          
            PreparedStatement statement = connexion.prepareStatement(query);
 
            statement.setInt(1, id_user);  
            statement.setInt(2,  id_event); 
            statement.setInt(3, id_salle);  
            statement.setInt(4, id_terrain); 
            statement.setTimestamp(5, date_reservation);    
           
 
            int rows = statement.executeUpdate();
             if (rows > 0) {
                 System.out.println(" tzad");
             } 
            
            }  }    catch (SQLException e) {
                e.printStackTrace();
            }
}
        public void afficher(Connection connexion) {
            try {
                Statement stmt = connexion.createStatement();
                String query = "SELECT * FROM reservations ";
              ResultSet rs = stmt.executeQuery(query);
              
                while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_reservation"));
                 System.out.println("id_user : " + rs.getString("id_user"));
                 System.out.println("id_event: " + rs.getString("id_event"));
                 System.out.println("id_salle: " + rs.getString("id_salle"));
                 System.out.println("id_terrain: " + rs.getString("id_terrain"));
                 System.out.println("date_reservation: " + rs.getString("date_reservation"));
                 System.out.println("-------------------");
             }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        public static void main(String[] args) {
            try {
                Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "");
                Gestion_reservation gestion = new Gestion_reservation();
                //gestion.supprimer(3,connexion);
               //gestion.update(2,Timestamp.valueOf("2024-12-07 18:30:00"),connexion);
               //gestion.ajouter(2, 2, 3, 1,Timestamp.valueOf("2024-12-07 19:30:00"),connexion);
               // gestion.afficher(connexion);
               //gestion.testdissalles(2,Timestamp.valueOf("2024-12-08 18:30:00"),connexion);
               gestion.testdisterr(3,Timestamp.valueOf("2024-12-08 18:30:00"),connexion);
               connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    
    
    
    }
    



