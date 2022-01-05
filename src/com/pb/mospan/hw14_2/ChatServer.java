package com.pb.mospan.hw14_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChatServer implements TCPConnectionListener {
    public static void main  (String[] args) throws Exception
    {
        new ChatServer();
    }

    private final ArrayList<TCPConnection> connections = new ArrayList<>();

    private ChatServer () throws Exception{
        System.out.println("Сервер стартовал...");
        try (ServerSocket serverSocket = new ServerSocket(1234)){
            while (true) {
                try {
                    new TCPConnection(this, serverSocket.accept());
                } catch (IOException e) {
                    System.out.println("TCPConnection exception: "+ e);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {
      connections.add(tcpConnection);
      sendToAllConnections("Клиент подключился: " + tcpConnection);
    }

    @Override
    public synchronized void onReceivestring(TCPConnection tcpConnection, String value) {
        sendToAllConnections("Текущая дата: " + LocalDateTime.now() + " Сообщение: " + value);

    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        sendToAllConnections("Клиент отключился: " + tcpConnection);
    }

    @Override
    public synchronized void onExpection(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection: " + e);
    }

    private void sendToAllConnections (String value){
        System.out.println(value);
        final int cnt = connections.size();
        for (int i=0; i<cnt; i++) connections.get(i).sendString(value);
           }
}
