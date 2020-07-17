 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Kamal
 */
public class EchoClient {
    public static void main(String arg[])
    {
        Socket soc = null;
        BufferedReader bin = null;
        BufferedReader cin = null;
        PrintWriter out = null;
        String str = null;
        String adr = "localhost";
        
        try
        {
            soc = new Socket("localhost",1201);
            bin = new BufferedReader(new InputStreamReader(System.in));
            cin = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
            do
            {
                System.out.println("Enter Message: ");
                str = bin.readLine();
                out.println(str);
                out.flush();
                str = cin.readLine();
                System.out.println("Message Recieved: "+str);
            }while(!str.equalsIgnoreCase("bye"));
        }
        catch(Exception e)
        {
    
        }
    }
}
