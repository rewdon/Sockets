
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rewdon
 */
public class SimpleSocketServer {

    ServerSocket serverSock = null;
    Socket clientSock = null;

    public SimpleSocketServer() {
        try {
            serverSock = new ServerSocket(8000);
            while(true){
            clientSock = serverSock.accept();
            ClientHandler c = new ClientHandler(clientSock);
            new Thread(c).start();
            }
            
            /*BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSock.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
            wr.write("Hello!");
             wr.newLine();

             wr.flush();

            String line;
            if ((line = in.readLine()) != null) {
                //do something
                if (line.startsWith("GET")) {
                    out.write("HTTP/1.0 200 OK");
                    out.newLine();
                    out.write("Date: Fri, 13 Jan 1999 10:10:10 GMT");
                    out.newLine();
                    out.write("Content-Type: text/html");
                    out.newLine();
                    out.write("Content-Length: 58");
                    out.newLine();
                    out.newLine();
                    out.write("<html>");
                    out.newLine();
                    out.write("<body>");
                    out.newLine();
                    out.write("<h1>HELLO</h1>");
                    out.newLine();
                    out.write("WORLD");
                    out.newLine();
                    out.write("</body>");
                    out.newLine();
                    out.write("</html>");
                    out.newLine();
                    out.flush();

                }

                System.out.println(line);
            }

            out.close();
            clientSock.close();
                    
                    */
            //serverSock.close();
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {

        new SimpleSocketServer();

    }

}
