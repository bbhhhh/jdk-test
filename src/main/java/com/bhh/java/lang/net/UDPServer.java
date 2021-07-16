package com.bhh.java.lang.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/7/16 15:29
 * @Description: TODO
 */

public class UDPServer {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UDPServer.class);

    public static void main(String[] args){
        DatagramPacket dp = new DatagramPacket(new byte[100],100);
        String data;
        InetAddress clientAddr ;
        int clientPort = 0;
        try (DatagramSocket sc = new DatagramSocket(new InetSocketAddress("10.243.26.139",9999))){
            while(true){
                sc.receive(dp);
                clientAddr = dp.getAddress();
                clientPort = dp.getPort();
                data = new String(dp.getData(),dp.getOffset(),dp.getLength());

                logger.info("data from client, ip={},port={},offset={},data={}",clientAddr.getHostAddress(),clientPort,dp.getOffset(),data);
                data = "s:"+data ;
                sc.send(new DatagramPacket(data.getBytes(),data.getBytes().length,clientAddr,clientPort));
            }
        } catch (SocketException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

    }
}
