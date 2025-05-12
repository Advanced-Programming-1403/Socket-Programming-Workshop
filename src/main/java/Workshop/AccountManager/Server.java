package Workshop.AccountManager;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    private static final ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        int port = 5001;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> handleClient(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        // TODO
    }
}
