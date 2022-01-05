package com.pb.mospan.hw14_2;

public interface TCPConnectionListener {
    void onConnectionReady (TCPConnection tcpConnection);
    void onReceivestring (TCPConnection tcpConnection, String value);
    void onDisconnect (TCPConnection tcpConnection);
    void onExpection (TCPConnection tcpConnection, Exception e);
}
