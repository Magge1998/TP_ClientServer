/**
 * Created by Markus on 23.01.17.
 */

import java.io.*;
import java.net.Socket;
import java.util.Date;

import javax.swing.*;


public class Client   {

    public static void main(String[] args) throws IOException {

        String serverAddress = JOptionPane.showInputDialog(
                "Enter IP Adress of machine that is \n" +
                "running the date service on port 9090: (127.0.0.1)");

 //------------------------------------------------------------------------------------------------
        if(serverAddress.equals("")){
            JOptionPane.showMessageDialog(null, "Ungültig");
            System.exit(0);
        }

 //------------------------------------------------------------------------------------------------

        //Socket s = new Socket(serverAddress, 9090);

        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println("Input wurde erstellt");
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);

 //------------------------------------------------------------------------------------------------
/*
        String[] ubergabe = new String[3];

        String option = JOptionPane.showInputDialog(
                "Enter Option \n");

        String zahl1 = JOptionPane.showInputDialog(
                "Enter number1\n");

        String zahl2 = JOptionPane.showInputDialog(
                "Enter number2\n");

        ubergabe[0] = zahl1;
        ubergabe[1] = zahl2;
        ubergabe[2] = option;


        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        System.out.println("OUT wurder ersellt");

        out.println(ubergabe[0] + " " + ubergabe[1] + " " + ubergabe[2]);
        System.out.println("test");

        String erg = input.readLine();
        JOptionPane.showMessageDialog(null, erg);

        */
//------------------------------------------------------------------------------------------------
        CalcMsg M = new CalcMsg();


        String enter = input.readLine();
        M.setMessage(enter);
        Socket st = new Socket(serverAddress, 9090);

        ObjectOutputStream out = new ObjectOutputStream(st.getOutputStream());
        out.writeObject(M);
        out.flush();




        InputStream in = st.getInputStream();
        FileOutputStream fileOut = new FileOutputStream("Client-downloadet.html");

        byte[] buffer = new byte[1024];
        while (st.isConnected()) {
            int bytesRead = in.read(buffer);
            if (bytesRead == -1) break;
            fileOut.write(buffer, 0, bytesRead);
        }

        fileOut.close();




        }

        /////////////////////////////////////////////////////////////////


    }


