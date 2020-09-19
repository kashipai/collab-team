package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class server {
    public static void main(String[] args) throws IOException {
        byte[] buffer=new byte[1024];
        byte[] reply = new byte[1024];

        Arrays.fill(reply, (byte)' ');
        Arrays.fill(buffer, (byte)' ');

        DatagramSocket serverSocket= new DatagramSocket(2200);
        System.out.println("-----------------------SERVER----------------------");
        while(true){
            DatagramPacket receivePacket=new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(receivePacket);

            String clientMessage=new String(receivePacket.getData());
            System.out.println("\nClient Sent: "+clientMessage);

            String serverReply="Received Message: "+clientMessage;
            Arrays.fill(buffer, (byte)' ');
            reply=serverReply.getBytes();
            DatagramPacket serverPacket=new DatagramPacket(reply,reply.length,receivePacket.getAddress(),receivePacket.getPort());
            serverSocket.send(serverPacket);
            Arrays.fill(reply, (byte)' ');
        }

    }

}


