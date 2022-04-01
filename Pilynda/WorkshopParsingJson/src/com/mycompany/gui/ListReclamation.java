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
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.mycompany.gui.HomeForm;
import com.codename1.ui.Form;
import com.mycompany.services.ServiceReclamation;


public class ListReclamation extends Form {
    
        public ListReclamation(Form previous) {
        setTitle("List Reclamation");
          
            
        
        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceReclamation.getInstance().getAllReclamations().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    
}

