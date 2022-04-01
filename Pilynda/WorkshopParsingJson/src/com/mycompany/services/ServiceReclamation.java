package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Reclamation;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lylyy
 */
public class ServiceReclamation {
     public ArrayList<Reclamation> rec;

    public static ServiceReclamation instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceReclamation() {
        req = new ConnectionRequest();
    }

    public static ServiceReclamation getInstance() {
        if (instance == null) {
            instance = new ServiceReclamation();
        }
        return instance;
    }
    //ajout

    public boolean AddReclamation(Reclamation rec ) {
         System.out.println(rec);
        System.out.println("********");
           req = new ConnectionRequest();
    
        String url = Statics.BASE_URL+"/addReclamationJSON?name="+rec.getName().toString()+"&email="+rec.getEmail().toString()+"&subject="+rec.getSubject().toString()+"&message="+rec.getMessage().toString()+"&type="+rec.getType().toString()+"&idCommande="+rec.getIdCommande().toString()+"&etat="+rec.getEtat().toString();

        req.setUrl(url);
       

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               String str = new String(req.getResponseData());
                System.err.println("data == "+str);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Reclamation> parseReclamations(String jsonText) {
        try {
            rec = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> reclamationsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) reclamationsListJson.get("root");
            for (Map<String, Object> obj : list) {
                Reclamation r = new Reclamation();
               
                String name = obj.get("name").toString();
                r.setName(name);
                String subject = obj.get("subject").toString();
                r.setSubject(subject);
                  String email = obj.get("email").toString();
                r.setEmail(email);
                String message = obj.get("message").toString();
                r.setMessage(message);
                   String type = obj.get("type").toString();
                r.setType(type);
                  String idCommande = obj.get("idCommande").toString();
                r.setIdCommande(idCommande);
                  String etat = obj.get("etat").toString();
                r.setEtat(etat);
              
               
          rec.add(r);
             
            }

        } catch (IOException ex) {

        }
        return rec;
    }

    public ArrayList<Reclamation> getAllReclamations() {
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL +"/AllReclamations";
        System.out.println("===>" + url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                rec = parseReclamations(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return rec;
    }
    //detail reclamation 
      public Reclamation Detailrec( int id , Reclamation p) {
        
        String url = Statics.BASE_URL+"/Reclamationdetail?"+id;
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                
                p.setName(obj.get("name").toString());
                p.setSubject(obj.get("subject").toString());
                p.setMessage(obj.get("message").toString());
                p.setEmail(obj.get("email").toString());
                p.setType(obj.get("type").toString());
                p.setEtat(obj.get("etat").toString());
                p.setIdCommande(obj.get("idCommande").toString());
                
            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            
            System.out.println("data === "+str);
            
            
            
        }));
        
              NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

              return p;
        
        
    }
    //modifier
  public boolean modifiereclamation(Reclamation rec) {
        String url = Statics.BASE_URL+"/updateReclamationJSON/{id}?name="+rec.getName().toString()+"&email="+rec.getEmail().toString()+"&subject="+rec.getSubject().toString()+"&message="+rec.getMessage().toString()+"&type="+rec.getType().toString()+"&idCommande="+rec.getIdCommande().toString()+"&etat="+rec.getEtat().toString();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                boolean resultOk = req.getResponseCode() == 200; // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
         boolean resultOk = false;
    return resultOk;
        
    }  





//delete
         public boolean  Delete(Reclamation p){
       String url = "http://127.0.0.1:8000" + "/deleteReclamationJSON/" +p.getId();

        req.setUrl(url);
        req.setPost(false);
        req.setFailSilently(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                 resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
      
      
      }

}


  



