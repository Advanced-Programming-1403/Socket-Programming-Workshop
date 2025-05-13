package GroupChat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static final int PORT = 5001;
    private static final ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Chat server started on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler client = new ClientHandler(socket);
                clientHandlers.add(client);
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcast message to all clients
    public static void broadcast(String message, ClientHandler sender) throws IOException {
        for (ClientHandler client : clientHandlers) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    // Remove client on disconnect
    public static void removeClient(ClientHandler client) {
        clientHandlers.remove(client);
    }

}