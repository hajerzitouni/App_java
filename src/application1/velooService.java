/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Hajer
 */
public class velooService {
    private Connection con;
  

    
    public velooService()
    {
        con = MyBdd.getInstance().getConnexion();//pour s'assurer que la connexion a la base se fait une seule fois

    }
    
  
    public void  ajouter(veloo v) throws SQLException {   
        //boolean b = false;
        //try {
        //String req = "INSERT INTO velo (`user_id` ,`prix`,`marque`,`type`,`nomimage`, `age`, `etat`, `nomvelo`) VALUES ('"+v.getUser_id()+"','"+v.getPrix()+"','"+v.getMarque()+"','"+v.getType()
              //  +"','"+v.getNomimage()+"','"+v.getAge()+"','"+v.getEtat()+"','"+v.getNomvelo()+"')";
        String sql = "insert into veloo (nom) values ('" + v.getNom()+"')";
        System.out.println(sql);
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
        System.out.println("user added ...");
         //b = true;
    }
    //catch (SQLException ex) {
      //      Logger.getLogger(veloService.class.getName()).log(Level.SEVERE, null, ex);
        //}//
        //return b;
         

  public void ajouter2(veloo v) throws SQLException {
        String req = "INSERT INTO `veloo` (nom,prix,age,marque ) VALUES ( ?,?,?,?) ";
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setString(1, "mo");
         pstm.setInt(2, 200);
        pstm.executeUpdate();
    }

public List<veloo> getAllveloos()throws SQLException  {

        List<veloo> veloos = new ArrayList<>();

            String req = "SELECT * FROM veloo";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
             veloo v = new veloo (rs.getInt(1),
                                 rs.getString("nom"),
                                 rs.getInt("prix"),
                                 rs.getInt("age"),
                                 rs.getString("marque"));
             
             
                      veloos.add(v);
        }

        return veloos;
    }
 public void delete(int id) throws SQLException {
        PreparedStatement pre= con.prepareStatement("delete from veloo where Id=?"); //executer une requette parametrer.
		pre.setInt(1, id);
		pre.executeUpdate();
                   System.out.println("User deleted ...");     
        
    }
       public void modifier(int Id,String Nom) {
     String sql = "UPDATE   veloo SET `Nom`='"+Nom+ "'  WHERE Id='"+Id+"' ";

        PreparedStatement st;
        try {
           
            st = con.prepareStatement(sql);
       
        st.executeUpdate();
        System.out.println("update done!");
        
        } catch (SQLException ex) {
            Logger.getLogger(velooService.class.getName()).log(Level.SEVERE, null, ex);
        }
       }

       public ObservableList<veloo> recherche(String Nom , Integer prix , Integer age , String marque) {
        
        String requete = "SELECT * FROM  veloo where nom = '"+Nom+"' " ;
        PreparedStatement pst;
        ObservableList<veloo> list= FXCollections.observableArrayList();
            

        try {
            pst = con.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                
            int id=rs.getInt(1);
               String nom=rs.getString("nom");
               
              
               veloo  v =new veloo (id, nom,prix,age,marque);
            list.add(v);
            }
            
        
        } catch (SQLException ex) {
            Logger.getLogger(velooService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
          
    }
       public void accepter(){
       
           String sql = "select * from veloo join location on velo.id = location.velo_id";
           
       
       
       }
       public ArrayList<String> getVeloloués(){
        String query = "select * from veloo v join location l on v.id = l.velo_id";
        
        ArrayList<String> loués = new ArrayList<>();
        
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
       
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                loués.add(rs.getString("nom"));
                loués.add(rs.getString("id"));
            }
            System.out.println("liste des vélos loués ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return loués;
    }
       

    
}