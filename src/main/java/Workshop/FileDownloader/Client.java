package Workshop.FileDownloader;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String SERVER_HOST = "localhost";
//    private static final int SERVER_PORT = ???; TODO
//    private static final File DOWNLOAD_FOLDER = new File("???"); TODO

    public static void main(String[] args) {
//        if (!DOWNLOAD_FOLDER.exists()) DOWNLOAD_FOLDER.mkdirs();
//
//        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
//             Scanner scanner = new Scanner(System.in)
//             // TODO
//        ) {
//
//            // Step 1: Receive file list
//            int fileCount = dis.readInt();
//            if (fileCount == 0) {
//                System.out.println("No files available on the server.");
//                return;
//            }
//
//            String[] fileNames = new String[fileCount];
//            System.out.println("Available files:");
//            for (int i = 0; i < fileCount; i++) {
//                // TODO
//                System.out.println((i + 1) + ". " + fileNames[i]);
//            }
//
//            // Step 2: Ask user for file choice
//            System.out.print("Enter the number of the file you want to download: ");
//            int choice = scanner.nextInt();
//
//            if (choice < 1 || choice > fileCount) {
//                System.out.println("Invalid choice.");
//                return;
//            }
//
//            String selectedFile = fileNames[choice - 1];
//            // TODO: send selected file name
//
//            // Step 3: Receive file or error
//            boolean fileExists = dis.readBoolean();
//            if (!fileExists) {
//                System.out.println("Server says file not found.");
//                return;
//            }
//
//            long fileSize;
//
//            // TODO
//
//            try (// TODO
//                    ) {
//                // TODO
//                System.out.println("File downloaded successfully to: " + outputFile.getAbsolutePath());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
