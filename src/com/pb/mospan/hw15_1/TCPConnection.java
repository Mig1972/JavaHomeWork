package com.pb.mospan.hw15_1;

import java.io.*;
import java.net.Socket;

public class TCPConnection {
    private final Socket socket;
    private final Thread rxThread;
    private final TCPConnectionListener eventListener;
    private final BufferedReader in;
    private final BufferedWriter out;

    public TCPConnection (TCPConnectionListener eventListener, String ipAddr, int port) throws Exception
    {
        this (eventListener, new Socket(ipAddr, port));
    }

    public TCPConnection (TCPConnectionListener eventListener, Socket socket) throws Exception
    {   this.eventListener = eventListener;
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        rxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    eventListener.onConnectionReady(TCPConnection.this);
                    while (!rxThread.isInterrupted())
                    {
                        eventListener.onReceivestring(TCPConnection.this, in.readLine());
                    }

                }
                catch (IOException e)
                {
                    eventListener.onExpection(TCPConnection.this, e);}
                finally {
                    eventListener.onDisconnect(TCPConnection.this);
                }
            }
        });
        rxThread.start();

    }

    public synchronized void sendString (String value)
    {    try {
        out.write(value+"\r\n");
        out.flush();
    } catch (IOException e)
    {
        eventListener.onExpection(TCPConnection.this, e);
        disconnect();
    }


    }

    public synchronized void disconnect ()
    {
        rxThread.interrupt();
        try {
            socket.close();
        } catch (IOException e)
        {
            eventListener.onExpection(TCPConnection.this, e);
        }

    }

    @Override
    public String toString()
    {
        return "TCPConnection: "+ socket.getInetAddress() + ": " + socket.getPort();
    }
}

