/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AG;



import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;



import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class recv_behv extends CyclicBehaviour  {

    
    
    // -----------le constructeur du recv_behv class-------------
    String agent_nbr;   // le numéro de l'agent 
        
        public recv_behv(String agent_nbr){
        this.agent_nbr=agent_nbr;
        
        
        }
        
        
        
        
    @Override
    public void action() {
       
        
       // -----------la reception du  message envoyer par le main agent -------------- 
       ACLMessage msg=this.getAgent().receive();
      if(msg!=null){
        
        System.out.println(" le message recu par l'agent-"+agent_nbr+"-est--->"+msg.getContent());
        
    // ---------------l'envoi du reponse au main agent------------------ 
        
       final ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
                msg2.setSender(this.myAgent.getAID());
                msg2.addReceiver(new AID(msg.getSender().getLocalName(), AID.ISLOCALNAME));     
                msg2.setContent("bonjour le main agent je suis l'agent numéro -->"+agent_nbr);
                this.myAgent.send(msg2);
        
             }
        else{
           block();
             }
 }

    
    
}
