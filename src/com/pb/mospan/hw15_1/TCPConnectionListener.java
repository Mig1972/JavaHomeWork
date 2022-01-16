package com.pb.mospan.hw15_1;

public interface TCPConnectionListener {
    void onConnectionReady (TCPConnection tcpConnection);
    void onReceivestring (TCPConnection tcpConnection, String value);
    void onDisconnect (TCPConnection tcpConnection);
    void onExpection (TCPConnection tcpConnection, Exception e);
}
