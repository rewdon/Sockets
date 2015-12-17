
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
public class SimpleSocketsClient {

    Socket sock = null;
    BufferedReader in = null;

    public SimpleSocketsClient() {

        try {
            sock = new Socket("localhost", 8000);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
            
            wr.write("GET/HTTP/1.0");
            wr.newLine();
            wr.newLine();
            wr.flush();
            
            
            String line;
            while ((line = in.readLine()) != null) {
                //do something
                System.out.println(line);
            }

            in.close();
            sock.close();

        } catch (Exception e) {

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        new SimpleSocketsClient();
    }
}
