package BufferedVsUnbuffered;

import java.io.*;

public class FileCopyBenchmark {
    public static void main(String[] args) throws IOException {
        File source = new File("src/main/resources/file.dat"); // test file, e.g., 500 MB+
        File dest1 = new File("src/main/resources/unbuffered.dat");
        File dest2 = new File("src/main/resources/buffered.dat");

        // --- Buffered copy ---
        System.out.println("Buffered copy...");
        long start = System.nanoTime();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest2))) {
            byte[] buffer = new byte[8192];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        }
        long bufferedTime = System.nanoTime() - start;
        System.out.printf("Buffered copy took %.2f seconds%n", bufferedTime / 1e9);

        // --- Unbuffered copy ---
        System.out.println("Unbuffered copy...");
        start = System.nanoTime();
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(dest1)) {
            int byteData;
            while ((byteData = in.read()) != -1) {
                out.write(byteData);
            }
        }

        long unbufferedTime = System.nanoTime() - start;
        System.out.printf("Unbuffered copy took %.2f seconds%n", unbufferedTime / 1e9);

    }
}

