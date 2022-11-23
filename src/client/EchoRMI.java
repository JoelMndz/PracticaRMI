/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.EchoInt;

/**
 *
 * @author luisj
 */
public class EchoRMI {
    public static void main(String[] args) {
        //Para usar esto hay que definir un fichero de pol�tica de seguridad.
        //System.setSecurityManager(new RMISecurityManager());

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter stdOut = new PrintWriter(System.out);

        String input,fin,output;
        try{
            
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            EchoInt eo = (EchoInt) registry.lookup("echo");

            //Bucle que lee de teclado, invoca el eco y escribe respuesta en la pantalla:
            input="";
            fin="fin";
            output = "";
            while(!input.equals(fin)) {
                stdOut.println("Escriba cadena para invocar su eco...");
                stdOut.flush();
                input = stdIn.readLine(); //Lee cadena introducida por teclado
                //EJERCICIO: Invocar para la cadena leida el m�todo echo del objeto RMI
                output = eo.echo(input);
                stdOut.println(output); //Escribe la respuesta del eco en la pantalla
                stdOut.flush();
            }  	

        }catch(Exception e){
              System.out.println("Error en el cliente de echo RMI : " + e.getMessage());
        }
    }
}
