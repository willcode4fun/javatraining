package com.valtech.talent.program;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ListenSocket80 {

    private static final Logger LOG
            = LoggerFactory.getLogger(ListenSocket80.class);

    private static final int HTTP_PORT = 80;

    private static final String RESPONSE = "HTTP/1.1 200 OK\n" +
            "Content-Length: 13\n" +
            "Content-Type: text/plain; charset=utf-8\n" +
            "\n" +
            "Hello World!";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(HTTP_PORT);
            while (true) {
                Socket socket = server.accept();
                String request = readRequest(socket);
                LOG.info("REQUEST : {}", request);
                socket.getOutputStream().write(RESPONSE.getBytes());
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readRequest(Socket clientSocket) throws IOException {
        byte[] messageByte = new byte[1000];
        boolean end = false;
        String dataString = "";

        DataInputStream in = new DataInputStream(clientSocket.getInputStream());

        while (!end) {
            int bytesRead = in.read(messageByte);
            if (bytesRead > 0) {
                String str = new String(messageByte, 0, bytesRead);
                dataString += str;
                // standard IOUtils won't work as expected :
                // stream is not closed, need to detect end of request with an empty line !
                if (dataString.endsWith("\n\r\n")) {
                    end = true;
                }
            } else {
                end = true;
            }
        }
        return dataString;
    }
}
