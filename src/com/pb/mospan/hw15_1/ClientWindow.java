package com.pb.mospan.hw15_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindow extends JFrame implements ActionListener, TCPConnectionListener {

    private static final String IP_ADDR="127.0.0.1";
    private static final int PORT = 1234;
    private static final int WIDTH = 400;
    private static final int HEIGTH = 300;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { new ClientWindow();
            }
        });


    }
    private final JTextArea log = new JTextArea();
    private final JTextField fieldNickname = new JTextField("Ирина");
    private JTextField fieldInput = new JTextField();
    private JScrollPane scroll = new JScrollPane(log);


    private TCPConnection connection;


    private ClientWindow (){

        setTitle("Новый чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGTH);
        add (scroll, BorderLayout.CENTER);
        setLocationRelativeTo( null);
        setAlwaysOnTop(true);
        log.setEditable(false);
        log.setLineWrap(true);
        fieldInput.addActionListener(this);
        add (log, BorderLayout.CENTER);
        add (fieldInput, BorderLayout.SOUTH);
        add (fieldNickname, BorderLayout.NORTH);

        setVisible(true);


        try {
            connection = new TCPConnection(this, IP_ADDR, PORT);
        } catch (Exception e) {
            printMsg("Connection exception: " + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = fieldInput.getText();
        if (msg.equals("")) return;
        fieldInput.grabFocus();
        fieldInput.setText(null);
        connection.sendString(fieldNickname.getText() + ": " + msg);

    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        printMsg("Соединение готово...");
    }

    @Override
    public void onReceivestring(TCPConnection tcpConnection, String value) {
        printMsg(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printMsg("Соединение закрылось");

    }

    @Override
    public void onExpection(TCPConnection tcpConnection, Exception e) {
        printMsg("Connection exception: " + e);

    }

    private synchronized void printMsg (String msg){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(msg + "\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });
    }
}

