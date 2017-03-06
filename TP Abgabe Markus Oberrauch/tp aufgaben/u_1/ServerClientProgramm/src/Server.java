/**
 * Created by Markus on 11.01.17.
 */


import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        while (true){
            System.out.println("Server läuft");
            Socket socket = listener.accept();
            System.out.println("Neue Verbindung vorhanden");
            try{

 //------------------------------------------------------------------------------------------------
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("OUT wurder ersellt");

                out.println(new Date().toString());
                System.out.println("test");

 //------------------------------------------------------------------------------------------------
                CalcMsg m = new CalcMsg();
                int erg;


                BufferedReader authInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));


                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                try {
                    m = (CalcMsg) input.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


                System.out.println("Message erhalten");



                   if (m.getInput().equals("add")) {
                       erg = Integer.parseInt(m.getZahl1()) + Integer.parseInt(m.getZahl2());
                       System.out.println(erg);
                       out.println(erg);

                   }

                   if (m.getInput().equals("sub")) {
                       erg = Integer.parseInt(m.getZahl1()) - Integer.parseInt(m.getZahl2());
                       System.out.println(erg);
                       out.println(erg);
                   }

                   if (m.getInput().equals("mul")) {
                       erg = Integer.parseInt(m.getZahl1()) * Integer.parseInt(m.getZahl2());
                       System.out.println(erg);
                       out.println(erg);
                   }

                   if (m.getInput().equals("div")) {
                       erg = Integer.parseInt(m.getZahl1()) / Integer.parseInt(m.getZahl2());
                       System.out.println(erg);
                       out.println(erg);
                   }






            }finally {
                socket.close();
            }



        }

    }


}
