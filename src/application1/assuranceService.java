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

/**
 *
 * @author Hajer
 */
public class assuranceService {
    private Connection con;
  

    
    public assuranceService()
    {
        con = MyBdd.getInstance().getConnexion();//pour s'assurer que la connexion a la base se fait une seule fois

    }
    public void ajouter(assurance a) throws SQLException {
        String req = "INSERT INTO assurance (montant,velo_id) VALUES (?,?)";
         try {
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setInt(1, 520);
        pstm.setInt(2,1);
       
        pstm.executeUpdate();
        System.out.println("assurance added ...");
    } catch (SQLException ex) {
            Logger.getLogger(assuranceService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
      public List<assurance> getAllassurance()throws SQLException  {

        List<assurance> assurances = new ArrayList<>();

            String req = "SELECT * FROM assurance";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
             assurance a = new assurance(rs.getInt(1),
                     rs.getInt("montant"),
                     rs.getInt("velo_id"));
                      assurances.add(a);
        }

        return assurances;
    }
      
  public void delete(int id) throws SQLException {
        PreparedStatement pre= con.prepareStatement("delete from assurance where Id=?"); //executer une requette parametrer.
		pre.setInt(1, id);
		pre.executeUpdate();
                   System.out.println("assurance deleted ...");     
        
    }
   public void modifier(int Id,assurance a) {
     String sql = "UPDATE assurance SET montant=?,velo_id=? WHERE Id='"+Id+"' ";

        PreparedStatement st;
        try {
           
            st = con.prepareStatement(sql);
            st.setInt(1,150);
            st.setInt(2,4);
            
           st.executeUpdate();
        System.out.println("update done!");
        
        } catch (SQLException ex) {
            Logger.getLogger(assuranceService.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
  
}
