/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmi.EchoInt;
/**
 *
 * @author luisj
 */
public class EchoObjectRMI {
    public static void main(String[] args) {
    try {
         EchoInt stub = (EchoInt) UnicastRemoteObject.exportObject(new EchoObject(),0);
         Registry registry = LocateRegistry.createRegistry(1099);
         registry.rebind("echo", stub);
     } catch (RemoteException e) {
         System.err.println("Something wrong happended on the remote end");
         e.printStackTrace();
         System.exit(-1); // can't just return, rmi threads may not exit
     }
     System.out.println("The echo server is ready");

    }
}
