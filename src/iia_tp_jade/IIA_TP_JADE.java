/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iia_tp_jade;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
/**
 *
 * @author DELL
 */
public class IIA_TP_JADE {

    /**
     * @param args the command line arguments
     * @throws jade.wrapper.ControllerException
     */
    public static void main(String[] args) throws ControllerException {
        // TODO code application logic here
        
        
        Runtime runtime=Runtime.instance();
        Properties properties=new ExtendedProperties();
        properties.setProperty(Profile.GUI,"true");
        ProfileImpl profileImpl=new ProfileImpl(properties);
        AgentContainer mainContainer=runtime.createMainContainer(profileImpl);
       
        
        
 AgentController agentController=mainContainer.createNewAgent("Main agent","AG.Main_agent", new Object[]{});
agentController.start();


    }
    
}
