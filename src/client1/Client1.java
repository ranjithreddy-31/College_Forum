/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Ranjith Reddy
 */
public class Client1 {

    /**s
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        try
        {
        Registry reg=LocateRegistry.getRegistry("192.168.0.5",1075);
        ocf stub=(ocf)reg.lookup("ocf");
        }
        catch(RemoteException | NotBoundException e)
        {
            System.out.println(e);
        }
        
        new START().setVisible(true);
    }
    
}
