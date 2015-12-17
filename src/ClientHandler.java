
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rewdon
 */
public class ClientHandler implements Runnable {
    private Socket soc;
    
    public ClientHandler(Socket s){
        soc = s;
        
        
    }
    
    public void HandleClient(){
        
        
        try {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            /*wr.write("Hello!");
             wr.newLine();

             wr.flush();*/

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
            soc.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

            
    }

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    HandleClient();
    
    }
}
