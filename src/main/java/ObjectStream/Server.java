package ObjectStream;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 5001;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            Person person = (Person) input.readObject();
            System.out.println("Received from client: " + person);

            input.close();
            socket.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

