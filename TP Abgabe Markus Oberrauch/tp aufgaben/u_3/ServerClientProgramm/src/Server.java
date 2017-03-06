/**
 * Created by Markus on 11.01.17.
 */


import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import java.net.URL;



public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        while (true){
            System.out.println("Server läuft");
            Socket socket = listener.accept();
            System.out.println("Neue Verbindung vorhanden");
            try {

                //------------------------------------------------------------------------------------------------
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("OUT wurder ersellt");

                out.println(new Date().toString());
                System.out.println("test");

                //------------------------------------------------------------------------------------------------
                CalcMsg m = new CalcMsg();
                int erg;


                BufferedReader authInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                try{

                    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());


                    try {
                        CalcMsg a = (CalcMsg) input.readObject();
                        String txt = a.getMessage();
                        System.out.println(txt + "herunterladen");

                        WebDownloader downloader = new WebDownloader();

                        try {
                            downloader.saveTo(new CalcMsg(txt),"Server-exit.html");

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }




                        OutputStream outb = socket.getOutputStream();
                        InputStream fileIn = new FileInputStream("Server-exit.html");

                        byte[] buffer = new byte[1024];
                        while (fileIn.available() > 0) {
                            outb.write(buffer, 0, fileIn.read(buffer));
                        }

                        fileIn.close();




                    } catch (Exception e) {
                        System.out.println("Fehler");
                    }

                } finally {
                    socket.close();
                    System.out.println("gedownloadet");
                }

            }finally{
                    socket.close();
                }

        }

    }


}


