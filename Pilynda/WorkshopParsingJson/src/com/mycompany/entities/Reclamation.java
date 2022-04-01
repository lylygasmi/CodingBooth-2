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
public class Reclamation {
    private int id; 
    private String name,email,subject,message,type,idCommande,etat;

public Reclamation(int id, String name, String email, String subject, String message, String type, String idCommande, String etat) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.type = type;
        this.idCommande = idCommande;
        this.etat = etat;
    }

 public Reclamation(String name, String email, String subject, String message, String type, String idCommande, String etat) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.type = type;
        this.idCommande = idCommande;
        this.etat = etat;
    }

public Reclamation(){
}

    public Reclamation(String valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Reclamation(int parseInt, String text, String text0, String text1, String text2, String text3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject + ", message=" + message + ", type=" + type + ", idCommande=" + idCommande + ", etat=" + etat + '}';
    }

    public void add(Reclamation rec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}





