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

   

    Integer id ;
    String nomvelo ;

   
    Integer prix ; 

    public velo(Integer id, String nomvelo, Integer prix, Integer age, String marque, String Image, Integer etat) {
        this.id = id;
        this.nomvelo= nomvelo;
        this.prix = prix;
        this.age = age;
        this.marque = marque;
        this.Image = Image;
        this.etat = etat;
    }
    Integer age ;
    String marque ;

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    String Image;

    public velo(String nomvelo, Integer prix, Integer age, String marque, String Image, Integer etat) {
        this.nomvelo= nomvelo;
        this.prix = prix;
        this.age = age;
        this.marque = marque;
        this.Image = Image;
        this.etat = etat;
    }

    public velo(String nomvelo, Integer prix, Integer age, String marque, String Image) {
        this.nomvelo= nomvelo;
        this.prix = prix;
        this.age = age;
        this.marque = marque;
        this.Image = Image;
    }
    
    Integer etat ;
   

   
    

   
    

    

   
    
    
    public velo ()
    {}
   public velo(Integer id, String nomvelo, Integer prix, Integer age, String marque) {
        this.id = id;
        this.nomvelo= nomvelo;
        this.prix = prix;
        this.age = age;
        this.marque = marque;
    }
   public velo(String nomvelo, Integer prix, Integer age, String marque) {
        this.nomvelo = nomvelo;
        this.prix = prix;
        this.age = age;
        this.marque = marque;
    }
    
    public velo(String nomvelo) {
       
        this.nomvelo= nomvelo;
    }
      public velo(String nomvelo, Integer prix) {
        this.nomvelo= nomvelo;
        this.prix = prix;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nomvelo;
    }

    public void setNom(String nomvelo) {
        this.nomvelo = nomvelo;
    }
    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }
     public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
   

  
 @Override
    public String toString() {
        return "veloo{" + "id=" + id + ", nom=" + nomvelo+ ", prix=" + prix + ", age=" + age + ", marque=" + marque + ", Image=" + Image + ", etat=" + etat + '}';
    }

}