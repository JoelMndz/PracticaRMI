/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import rmi.EchoInt;

/**
 *
 * @author luisj
 */
public class EchoObject implements EchoInt{
    String myURL="localhost";
    
    public EchoObject(){
    }

    @Override
    public String echo(String input)
    {
       Date h = new Date();
       SimpleDateFormat simpleDateFormat =new SimpleDateFormat("HH:mm:ss a");
       String fecha = simpleDateFormat.format(h);
       String ret = myURL + ":" + fecha + "> " +  input;
       try {
             Thread.sleep(3000);  
             ret = ret + " (retrasada 3 segundos)";
       } catch (InterruptedException e) {}

       return ret;
    }
}
