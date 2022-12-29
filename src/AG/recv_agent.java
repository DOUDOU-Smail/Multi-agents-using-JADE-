/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AG;

import jade.core.Agent;

/**
 *
 * @author DELL
 */
public class recv_agent extends Agent {
   
    private String agent_nbr;

    @Override
    protected void setup(){
        
        
        // la recupération des paramétre (numéro de l'agent 
        Object[]args=getArguments();
        if(args.length==1) 
            this.agent_nbr=(String) args[0];

        
        
        System.out.println("Salut je suis recever agent !");
        System.out.println("My Name is "+this.getName());
        
        //  la reception et la reponse
        addBehaviour(new recv_behv(agent_nbr));
    }
    
    
    @Override
protected void takeDown() {
System.out.println("avant de mourir .....");
}
 
}
