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
import com.codename1.ui.FontImage;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;


/**
 *
 * @author bouss
 */
public class AddReclamation extends Form{
    public AddReclamation(Form previous) {
        setTitle("Add a new reclamation");
        setLayout(BoxLayout.y());
        
        TextField tfName = new TextField("","enter name");
        TextField tfSubject = new TextField("","enter subject");
        TextField tfEmail = new TextField("","enter email");
        TextField tfMessage = new TextField("","enter message");
        TextField tfType = new TextField("","enter type");
        TextField tfIdCommande = new TextField("","enter idCommande");
        TextField tfEtat = new TextField("","enter etat");
        Button btnValider = new Button("Add reclamation");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length()==0) && (tfSubject.getText().length()==0)&& (tfEmail.getText().length()==0)&& (tfMessage.getText().length()==0) && (tfType.getText().length()==0) && (tfIdCommande.getText().length()==0) && (tfEtat.getText().length()==0)  )
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Reclamation rec = new Reclamation(tfName.getText().toString(),tfSubject.getText().toString(),tfEmail.getText().toString(),tfMessage.getText().toString(),tfType.getText().toString(),tfIdCommande.getText().toString(),tfEtat.getText().toString() );
                        if( ServiceReclamation.getInstance().AddReclamation(rec))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfName,tfSubject,tfEmail,tfMessage,tfType,tfIdCommande,tfEtat,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
}

