/**
 * Created by Markus on 11.01.17.
 */


import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Date;


public class Server {

    public static void main(String args[]) throws Exception {

        DatagramSocket serverSocket = new DatagramSocket(4242);
        try {

            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            String sentence = "";
            System.out.println("Server gestartet");
            while (!sentence.equals("exit")) {
                Arrays.fill(receiveData, (byte) 0);

                serverSocket.receive(receivePacket);

                sentence = new String(receivePacket.getData());

                System.out.println(receivePacket.getAddress()+": RECEIVED: " + sentence );

                String answer = sentence;

                sendData = answer.getBytes();
                String IP = "255.255.255.255";
                InetAddress broadcast = InetAddress.getByName(IP);

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, broadcast, 4545);

                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {

            System.out.println("Fehler Server");
            e.printStackTrace();

        }
    }
}