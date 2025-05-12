package Workshop.AccountManager;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5001;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Account Manager ---");
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 3) break;

            try (
                    Socket socket = new Socket(host, port);
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ) {
                if (choice == 1) {
                    System.out.print("Full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();

                    Account account = new Account(username, password, fullName, age);

                    // TODO

                } else if (choice == 2) {
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    // TODO
                }
            } catch (IOException  e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}

