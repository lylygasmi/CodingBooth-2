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
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;


public class ModifierReclamation extends Form {

    Form current;

   public ModifierReclamation(Reclamation p , Form previous) {
        setTitle("edit reclamation");
        setLayout(BoxLayout.y());
        TextField id = new TextField(String.valueOf(p.getId()), "id");
        TextField tfName = new TextField(p.getName(), "name");
        TextField tfEmail= new TextField(p.getEmail(), "email");
        TextField tfMessage = new TextField(p.getMessage(), "message");
        TextField tfSubject = new TextField(p.getSubject(), "subject");
        TextField tfType = new TextField(p.getType(), "type");

        Button btnValider = new Button("edit product");
        Button btnRet = new Button("Return");
        btnRet.addActionListener(e-> new HomeForm(p).show() );

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length() == 0) && (tfEmail.getText().length() == 0) && (tfMessage.getText().length() == 0) && (tfSubject.getText().length() == 0) && (tfType.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        Reclamation p = new Reclamation(Integer.parseInt(id.getText()), tfName.getText(), tfEmail.getText(), tfMessage.getText(), tfSubject.getText(), tfType.getText());
                        System.out.println(p.getId());
                        System.out.println("---------");
                        System.out.println(id.getText());
                        if (ServiceReclamation.getInstance().modifiereclamation(p)) {
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }

                }

            }
            
        });
        

        addAll(id, tfName, tfEmail, tfMessage, tfSubject, tfType, btnValider,btnRet);
        //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> this.previous.showBack());

    }
}
