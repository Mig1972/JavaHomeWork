package com.pb.mospan.hw15_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientInterface extends JFrame {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 1234;
    private Socket clientSocket;
    private Scanner inMessage;
    private PrintWriter outMessage;
    private JTextField jTextField;
    private JTextArea jTextArea;



    public ClientInterface() {
        try {
            clientSocket = new Socket(SERVER_IP, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBounds(300, 200, 400, 300);
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jTextArea);
        add(jsp, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSendMessage = new JButton("Отправить");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);
        jTextField = new JTextField("Введите сообщение: ");
        bottomPanel.add(jTextField, BorderLayout.CENTER);

        jbSendMessage.addActionListener(e -> {

            if (!jTextField.getText().trim().isEmpty()) {
                sendMsg();
                jTextField.grabFocus();
            }
        });

        jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextField.setText("");
            }
        });


        new Thread(() -> {
            try {
                while (true) {
                    if (inMessage.hasNext()) {
                        String inMes = inMessage.nextLine();
                        jTextArea.append(inMes);
                        jTextArea.append("\n");

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    outMessage.flush();
                    outMessage.close();
                    inMessage.close();
                    clientSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        setVisible(true);
    }

    public void sendMsg() {
        String messageStr = jTextField.getText();
        outMessage.println(messageStr);
        outMessage.flush();
        jTextField.setText("");
    }

    private synchronized void printMsg (String msg){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jTextArea.append(msg + "\n");
                jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
            }
        });
    }
}
