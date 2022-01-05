package com.pb.mospan.hw14_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static class Handler implements Runnable {
        private final Socket socket;
        private int c=0;

        public Handler(Socket socket, int c) {
            this.socket = socket;
            this.c=c;
        }

        @Override
        public void run() {
           try {
        // создаем потоки для связи с клиентом
                BufferedReader  in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String clientMessage;

        // цикл ожидания сообщений от клиента
        System.out.println("Ожидаем сообщений от клиента");
        while ((clientMessage = in.readLine()) != null) {
            if ("exit".equalsIgnoreCase(clientMessage)) {
                break;
            }
            out.println("Ответ от сервера: Текущая дата: " + LocalDateTime.now() + " + Сообщение от клиента" + c + ": " + clientMessage);
            System.out.println("Текущая дата: " + LocalDateTime.now() + " + Сообщение от клиента" + c + ": " + clientMessage);
        }
                System.out.println("Закрываем соединение с клиентом"+c);
                out.close();
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception ex) {
                    // ignore
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен на порту : " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        int c=0;
        // В цикле ждем запроса клиента
        while (true) {
            c++;
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket, c));
        }
    }
}