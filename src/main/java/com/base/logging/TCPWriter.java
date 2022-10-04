package com.base.logging;

import javax.net.SocketFactory;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPWriter {
    protected int port = 5170;
    private Socket socket = null;
    private Writer writer = null;
    private int socketConnectTimeoutInMillis = 50000;
    private int maxRetryCount = 2;
    private static TCPWriter instance = null;

    public TCPWriter() {
        try {
            socket = SocketFactory.getDefault().createSocket();
            socket.setKeepAlive(true);
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), port), socketConnectTimeoutInMillis);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        }
        catch (Exception exception) {
            System.out.println("An error occured while TCPWriter is being created: " + exception.toString());
        }
    }

    public TCPWriter getInstance() {
        if (instance == null) {
            instance = new TCPWriter();
        }
        return instance;
    }

    public void sendData(String log) {
        try {
            writer.write(log.toCharArray());
            writer.flush();
        }
        catch (Exception exception) {
            System.out.println("Receive an unexpected event while sending data: " + exception.toString());
        }
    }
}
