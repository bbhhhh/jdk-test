package com.bhh.java.lang.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/7/16 14:53
 * @Description: TODO
 */

public class UDPClient {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UDPClient.class);

    static class ClientReceiver implements Runnable{
        DatagramSocket sock ;
        ClientReceiver(DatagramSocket sc){
            this.sock = sc ;
        }

        @Override
        public void run() {
            DatagramPacket dp = new DatagramPacket(new byte[100], 100);
            InetAddress svrAddr ;
            int svrPort = 0;
            String data ;
                try {
                    while(true){
                        sock.receive(dp);
                        svrAddr = dp.getAddress();
                        svrPort = dp.getPort();
                        data = new String(dp.getData(),dp.getOffset(),dp.getLength());
                        logger.info("data from server, ip={},port={},offset={},data={}", svrAddr.getHostAddress(),svrPort, dp.getOffset(),data);

                    }
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }

        }
    }

    public static void main(String[] args) {

        SocketAddress remoteAdd;
        byte[] dataBytes;

        //remoteAdd = new InetSocketAddress("10.243.26.139", 9999);
        remoteAdd = new InetSocketAddress("135.251.218.88", 9999);


        try (Scanner sc = new Scanner(System.in); DatagramSocket sock = new DatagramSocket()) {
            //sock.connect(remoteAdd);
            new Thread(new ClientReceiver(sock)).start();
            while (sc.hasNext()) {
                dataBytes = sc.next().getBytes();
                sock.send(new DatagramPacket(dataBytes, dataBytes.length, remoteAdd));
              //  sock.send(new DatagramPacket(dataBytes, dataBytes.length));
            }
        } catch (SocketException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

//        dataBytes = data.getBytes();
//        ds.send(new DatagramPacket(dataBytes,dataBytes.length,remoteAdd));
    }
}
