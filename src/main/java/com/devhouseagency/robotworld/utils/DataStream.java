package com.devhouseagency.robotworld.utils;

import java.io.*;
import java.net.Socket;

public class DataStream {
    private final Socket socket;

    public DataStream(Socket socket) {
        this.socket = socket;
    }

    /**
     * Sends a string data over the network.
     * @param data data to be sent over the network.
     * */
    public void send(String data) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the data from over the network and returns a string format
     * of the data received over the network.
     * */
    public String get() {
        String data = "";
        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            data = reader.readLine();
        } catch (IOException e) {
            closeQuietly();
        } return data;
    }

    /**
     * Closes the socket if there is a bug in our program.
     * */
    private void closeQuietly() {
        try {
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
