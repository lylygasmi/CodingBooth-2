/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author lylyy
 */
public class Reponse {
    private int id_rep; 
    private String subject,message,idCommande,createdAt;

    public Reponse(int id_rep, String subject, String message, String idCommande, String createdAt) {
        this.id_rep = id_rep;
        this.subject = subject;
        this.message = message;
        this.idCommande = idCommande;
        this.createdAt = createdAt;
    }

    public Reponse(String subject, String message, String idCommande, String createdAt) {
        this.subject = subject;
        this.message = message;
        this.idCommande = idCommande;
        this.createdAt = createdAt;
    }



    public void setId_rep(int id_rep) {
        this.id_rep = id_rep;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

public Reponse(){
}

    public int getId_rep() {
        return id_rep;
    }

    public String getCreatedAt() {
        return createdAt;
    }


   


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

  

    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id_rep=" + id_rep + ", subject=" + subject + ", message=" + message + ", idCommande=" + idCommande + ", createdAt=" + createdAt + '}';
    }

    

 

 

}


