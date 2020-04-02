/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application1;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter; 
import java.sql.Date;  


/**
 *
 * @author Hajer
 */
public class Application1 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
     
        //velo v = new velo();
        //v.setUser_id(2);
        //v.setPrix(50);
        //v.setMarque("a");
        //v.setEtat(0);
        //v.setNomimage("t");
        //v.setType(1);
        //v.setAge(8);
       // v.setUser_id(5);
        //veloService.ajouterVelo(v);
   
    // ajout velo
      velooService vs = new velooService();
     //veloo v = new veloo ("aa");
        //v.setNom("a");
       // vs.ajouter(v);
  //
        //veloo v1 = new veloo("u");
        //vs.ajouter2(v1);
        
         System.out.println(vs.getAllveloos());
       // vs.delete(1);
         //vs.modifier(2, "youssef");
        //System.out.println(vs.getAllveloos());
       // vs.recherche("youssef");
       // System.out.println(vs.recherche("hajer"));
     // locationService ls = new locationService();
       //DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MM-yyyy");
        //String date = "16-08-2016";
       //String date1="12-06-2018";
        //String date2="12-06-2018";
    String str="2020-03-31";  
    String s="2021-03-31";  
   Date date=Date.valueOf(str);
   Date date1 =Date.valueOf(s);
   locationService ls = new locationService();
    //  location l1 = new location( 1,3,date,date1,"loc2",0);
      //  ls.ajouter2(l1);
       
      // location l = new location ();
     // ls.modifier(1, 5, 3, date,date, null, 80);
       //ls.Edit(l, 2);
       //System.out.println(ls.getAlllocations());
       //ls.delete(1);
       //System.out.println(ls.getAlllocations());
       reclamationService rs = new reclamationService();
       reclamation r = new reclamation ();
       //rs.ajouter(r);
      //System.out.println(rs.getAllreclam());
      //rs.modifier(1, r);
        //System.out.println(rs.recherche("bhym"));
       assuranceService as = new assuranceService();
       assurance a = new assurance ();
   
       //  as.ajouter(a);
      // as.modifier(2, a);
     //System.out.println(as.getAllassurance());
//        velooService vs = new velooService();
     //  System.out.println( vs.getVeloloués());
     System.out.println(ls.calculPrix(3));
      
       
      
       
      
    }
    
}
