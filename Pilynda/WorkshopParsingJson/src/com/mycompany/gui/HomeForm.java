/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

/**
 *
 * @author lylyy
 */
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.mycompany.gui.HomeForm;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Reclamation;

public class HomeForm extends Form{
Form current;
    public HomeForm(Reclamation p) {
        current=this; 
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        
        //reclamation
        Button btnAddReclamation = new Button("Add Reclamation");
        Button btnListReclamation = new Button("List Reclamation");
        Button btnDeleteReclamation = new Button("Delete Reclamation");
        
        
        
        //reclamation
         btnAddReclamation.addActionListener(e-> new AddReclamation(current).show());
        btnListReclamation.addActionListener(e-> new ListReclamation(current).show());
        addAll(btnAddReclamation,btnListReclamation,btnDeleteReclamation);
        
        
        
        
    }

   
    
    
}

