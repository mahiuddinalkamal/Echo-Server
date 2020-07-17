/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *@author Kamal
 
 */
public class EchoServer {
    public static final int PORT = 1201;
    ServerSocket serverSock;
    Socket clientSock;
    BufferedReader clientInput;
    PrintWriter  out;
    String str;

    public EchoServer() {    
        try
        {
            serverSock = new ServerSocket(PORT);
            System.out.println("Server Started.\n");
            while(true)
            {
                clientSock = serverSock.accept();
                System.out.println("Client Connected with Socket: \n"+clientSock);
                clientInput = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
                out = new PrintWriter(new OutputStreamWriter(clientSock.getOutputStream()));
                
                do
                {
                    str = clientInput.readLine();
                    System.out.println("Recieved: "+str);
                    out.println(str);
                    out.flush();
                }while(!equals("bye"));
            }
        }
        catch(Exception e)
        {
            System.out.println("Unexpected Error occured.\n");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        EchoServer server = new EchoServer();
    }
}
