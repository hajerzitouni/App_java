/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application1;



/**
 *
 * @author Hajer
 */
public class velo {

    private Integer id;
    
    private Integer user_id;
    
    private Integer prix;
   
    private String marque;
 
    private Integer etat;

   
    private String nomimage;
   
    private Integer type;
    
    private Integer age;
    
    private String nomvelo;
   
  

    public velo( )
    { 
    }
    
    
    public velo(Integer id, Integer user_id ,Integer prix, String marque, Integer type, String nomimage,Integer age,Integer etat ,String nomvelo) 
    {
        this.id = id;
        this.user_id = user_id;
        this.prix = prix;
        this.marque= marque;
        this.type = type;
        this.nomimage =nomimage;
        this.age = age;
        this.etat= etat;
        this.nomvelo = nomvelo;
        
       
    }
    
public velo(Integer user_id ,Integer prix, String marque,Integer etat,String nom_image,Integer type,Integer age ,String nomvelo) 
       {
        this.user_id = user_id;
        this.prix = prix;
        this.marque= marque;
        this.etat =etat;
        this.nomimage = nom_image;
         this.type = type;
        this.age = age;
        this.nomvelo = nomvelo;
        
    }
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNomvelo() {
        return nomvelo;
    }

    public void setNomvelo(String nomvelo) {
        this.nomvelo = nomvelo;
    }

    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
    }
    
    @Override
    public String toString() {
        return "velo{" + "id=" + id + "," + "etat=" + etat + ", marque=" + marque + ", type=" + type + ", prix=" + prix + ", nom_image=" + nomimage + ", nomvelo=" + nomvelo + ", age=" + age  + '}';
    }

}

    