/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import static java.time.Instant.now;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Hajer
 */
public class locationService {
    
    private Connection con;
  

    
    public locationService()
    {
        con = MyBdd.getInstance().getConnexion();//pour s'assurer que la connexion a la base se fait une seule fois

    }
    
     public void ajouter(location l) throws SQLException {
        String req = "INSERT INTO `location` (`user_id ,`velo_id`,`date_debut`,`date_fin`,`nomlocation`,`prixloc`) VALUES (?,?,?,?,?,?)";
         try {
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setInt(1, l.getUser_id());
        pstm.setInt(2,l.getVelo_id());
        pstm.setDate(3,l.getDate_debut());
       // pstm.setDate(3,new java.sql.Date(l.getDate_debut()));
        pstm.setDate(4,l.getDate_fin());
        pstm.setString(5,l.getNomlocation());
        pstm.setInt(7,l.getPrixloc());
        
        pstm.executeUpdate();
        System.out.println("location added ...");
    } catch (SQLException ex) {
            Logger.getLogger(locationService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void  ajouter2(location l) throws SQLException {   
         String sql = "insert into location (user_id,velo_id,date_debut,date_fin,nomlocation,prixloc) values ('" + l.getUser_id()+"','"+l.getVelo_id()+"','"+l.getDate_debut()+"','"+l.getDate_fin()+"','"+l.getNomlocation()+"','"+l.getPrixloc()+"')";
        System.out.println(sql);
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
        System.out.println("loc added ...");
         //b = true;
    }
      public void modifier(int Id,int user_id , int velo_id ,Date date_debut , Date date_fin ,String nomlocation,int prixloc) {
     //String sql = "UPDATE   veloo SET `Nom`='"+Nom+ "'  WHERE Id='"+Id+"' ";
     String sql = "UPDATE   location SET `User_id`='"+user_id+ "',`velo_id`='"+velo_id+ "',`date_debut`='"+date_debut+ "',`date_fin`='"+date_fin+ "',`nomlocation`='"+nomlocation+ "' WHERE Id='"+Id+"' ";

        PreparedStatement st;
        try {
           
            st = con.prepareStatement(sql);
       
        st.executeUpdate();
        System.out.println("update done!");
        
        } catch (SQLException ex) {
            Logger.getLogger(locationService.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       public static String valueOf(Object obj) {  
       return (obj == null) ? "null" : obj.toString();  
   }
         public void Edit(location l, int id) throws SQLException {
           SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String req = "UPDATE location SET user_id=?,velo_id=?,date_debut=?,date_fin=?,nomlocation=?,prixloc=? WHERE id='"+id+"' ";
        PreparedStatement st = con.prepareStatement(req);
            st.setInt(1, 6);
            st.setInt(2, 6);
            Date Date1 = Date.valueOf("2020-03-30");
             Date Date2 = Date.valueOf("2020-03-31");
            st.setDate(3, Date1);
            st.setDate(4, Date2);
            //st.setDate(4, new java.sql.Date(15/02/2018));
            st.setString(5, "hajer");
            st.setInt(6, 0);
           
     
        //st.setInt(7, id);
        st.executeUpdate();

    }
         public List<location> getAlllocations()throws SQLException  {

        List<location> locations = new ArrayList<>();

            String req = "SELECT * FROM location";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
             location l = new location(rs.getInt(1),
                                        rs.getInt("user_id"),
                                        rs.getInt("velo_id"),
                                        rs.getDate("date_debut"),
                                        rs.getDate("date_fin"),
                                        rs.getString("nomlocation"),
                                        rs.getInt("prixloc"));
                      locations.add(l);
        }
          return locations;
         
     }
          public void delete(int id) throws SQLException {
        PreparedStatement pre= con.prepareStatement("delete from location where Id=?"); //executer une requette parametrer.
		pre.setInt(1, id);
		pre.executeUpdate();
                   System.out.println("location deleted ...");     
        
    }
           public ArrayList<String> calculdiff(int id )throws SQLException 
          {
               int a=0;
               int b=0;
              ArrayList<String> calcul= new ArrayList<>();
              String req = "SELECT DATEDIFF(date_fin,date_debut) as nb from location  WHERE id='"+id+"' ";
              PreparedStatement ste = con.prepareStatement(req);
               //ste.setInt(1, id);
               ResultSet rs = ste.executeQuery(); 
              while(rs.next()){
              a=rs.getInt("nb");
                System.out.println(a);}
               return calcul ;
             
                      
          }
           
           
        public ArrayList<String> calculPrix(int id )throws SQLException 
          {
               int a=0;
              
              ArrayList<String> prixl= new ArrayList<>();
              String req = "SELECT v.prix *DATEDIFF(date_fin,date_debut) as nb  from location l join veloo v on v.id= l.velo_id WHERE l.id='"+id+"' "; 
              PreparedStatement ste = con.prepareStatement(req);
               //ste.setInt(1, id);
               ResultSet rs = ste.executeQuery(); 
              while(rs.next()){
              a=rs.getInt("nb");
                System.out.println(a);}
                               
               return prixl ;}
          
        }

