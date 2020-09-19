package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class client {

    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024],reply=new byte[1024];
        Arrays.fill(reply, (byte)' ');
        Arrays.fill(buffer, (byte)' ');

        DatagramSocket clientSocket = new DatagramSocket();
        BufferedReader in;
        in = new BufferedReader(new InputStreamReader(System.in));
        InetAddress i=InetAddress.getByName("127.0.0.1");
        System.out.println("---------------------CLIENT---------------------");

        System.out.print("\nEnter the Message:- ");
        String message=in.readLine();
        buffer=message.getBytes();

        DatagramPacket sendPacket=new DatagramPacket(buffer, buffer.length, i, 2200);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket=new DatagramPacket(reply, reply.length);
        clientSocket.receive(receivePacket);
        String receivedMessage=new String(receivePacket.getData());
        System.out.println("\nServer replied:- \n"+receivedMessage);
        Arrays.fill(reply, (byte)' ');

        clientSocket.close();
    }

}

