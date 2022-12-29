/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AG;

import jade.core.AID;
import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */
public class Main_agent extends Agent {
    
    @Override
    protected void setup(){
        
        try {
            System.out.println("Salut je suis Main agent !");
            System.out.println("My Name is "+this.getAID().getName());
            
            
            
            
            
            // la cration de container qui va contenir les agents cree pas le main 
            Runtime runtime=Runtime.instance();
            ProfileImpl profileImpl=new ProfileImpl(false);
            profileImpl.setParameter(ProfileImpl.MAIN_HOST,"localhost");
            AgentContainer agentContainer=runtime.createAgentContainer(profileImpl);
        
            
            // -------------------la creation des agents -------------------------
            for(int i=1; i<5; i++){
            AgentController agentController=agentContainer.createNewAgent("recv_agent"+String.valueOf(i),"AG.recv_agent", new Object[]{String.valueOf(i)});
             agentController.start();
          
            }
            
            
            // --------------------l'envoi des messages --------------------------------
           ACLMessage message = new ACLMessage(ACLMessage.INFORM);
           
             // les distination des messages  
            for(int i=1; i<5; i++){
           message.addReceiver(new AID("recv_agent"+String.valueOf(i), AID.ISLOCALNAME));
          }
            
            // le  contenu des messages 
            message.setContent("salut je suis le main agent ");
           send(message);

           
           // ----------------------la reception des reponses ------------------------
              addBehaviour(new CyclicBehaviour() 
                {
                     @Override
                     public void action() 
                     {
                        ACLMessage msg= receive();
                        if (msg!=null){
                            System.out.println(  "le message resu par le main c'est : "+ msg.getContent() );
                          
                            
                            
                            
                        } 
                       else{
                            
                       block();
                         }
                     }
                });
              
              
              
              
            }
        



            
        catch (StaleProxyException ex) {
            Logger.getLogger(Main_agent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
   



}
