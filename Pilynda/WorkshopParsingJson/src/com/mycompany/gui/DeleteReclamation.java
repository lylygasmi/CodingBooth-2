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
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;

/**
 *
 * @author bouss
 */
public class DeleteReclamation extends Form{
    public DeleteReclamation(Reclamation p, Form previous) {
        setTitle("delete Reclamation");
        

        Button btnSubmit = new Button("Delete");
        Button btnret = new Button("return");
        
            btnret.addActionListener(e -> new HomeForm(p).show());
        
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    Dialog.show("Alert", "Are you sure !!", new Command("OK"));
             
                    System.out.println(p.getId());
                    System.out.println("deleted Reclamation");
                    
                    if (ServiceReclamation.getInstance().Delete(p)) {
                        Dialog.show("Success", "Connection Accepted", new Command("OK"));
                    } else {
                        Dialog.show("ERROR", "Connection Failed", new Command("OK"));
                    }
                        
                }
      
        });
        

        addAll(btnSubmit,btnret);
       //this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

   




    
}
