/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Hajer
 */

public class veloService {
    private Connection con;
   private  static Statement st ;

    
    public veloService()
    {
        con = MyBdd.getInstance().getConnexion();//pour s'assurer que la connexion a la base se fait une seule fois

    }
    
  
    public static  boolean ajouterVelo(velo v) throws SQLException {   
        boolean b = false;
        try {
        String req = "INSERT INTO velo (`user_id` ,`prix`,`marque`,`type`,`nomimage`, `age`, `etat`, `nomvelo`) VALUES ('"+v.getUser_id()+"','"+v.getPrix()+"','"+v.getMarque()+"','"+v.getType()
               +"','"+v.getNomimage()+"','"+v.getAge()+"','"+v.getEtat()+"','"+v.getNomvelo()+"')";
        String sql = "insert into velo (nomvelo) values ('" + v.getUser_id()+"')" ;
       //Statement st = con.createStatement();
       st.executeUpdate(sql);
       System.out.println("user added ...");
         b = true;
    }
    catch (SQLException ex) {
            Logger.getLogger(veloService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
         }
       // try {
            //Statement st = con.createStatement(); //instruction sql; envoyer la requete et l'executer coté base de donné.
            //st.executeUpdate(requete); //méthodes appropriées à l'exécution d'une instruction menant à la modification de la BD (INSERT, UPDATE, DELETE, CREATE, etc.)
        //} catch (SQLException ex) {
          //  Logger.getLogger(veloService.class.getName()).log(Level.SEVERE, null, ex);
       
         

    
    public void ajouter2Velo( velo v) throws SQLException {      
       String req="INSERT INTO velo ( `user_id` ,  `prix`,`marque`,`type`, `nomimage`,`age`, `etat`, `nomvelo`) VALUES (?,?,?,?,?,?,?,?))";
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setInt(1, v.getUser_id());
        pstm.setInt(2, v.getPrix());
        pstm.setString(3, v.getMarque());
        pstm.setInt(4, v.getType());
        pstm.setString(5, v.getNomimage());
        pstm.setInt(6, v.getAge());
        pstm.setInt(7, v.getEtat());
        pstm.setString(8, v.getNomvelo());   
        pstm.executeUpdate();
    }
      public List<velo> getAllvelos()throws SQLException  {

        List<velo> velos = new ArrayList<>();

            String req = "SELECT * FROM velo";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
             velo v = new velo (rs.getInt(1),
                     rs.getInt("user_id"),
                     rs.getInt("prix"),
                     rs.getString("marque"),
                     rs.getInt("type"),
                     rs.getString("nom_image"),
                     rs.getInt("age"),
                     rs.getString("nomvelo"));
            velos.add(v);
        }

        return velos;
    }
    
}
