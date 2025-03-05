package Array;

import java.util.Scanner;

public class Buffer {

    public void buffer() {
        int[] array = new int[4];
        Scanner scanner = new Scanner(System.in);

        int writeIndex = 0;
        int readIndex = 0;

        long lastReadTime = System.currentTimeMillis();
        long readDelay = 1000;

        while (true) {

            System.out.print("Element eingeben (aktueller Schreibindex: " + writeIndex + "): ");
            int num = scanner.nextInt();


            array[writeIndex] = num;
            writeIndex = (writeIndex + 1) % array.length;


            if (writeIndex == readIndex) {
                readIndex = (readIndex + 1) % array.length;
            }

            long currentTime = System.currentTimeMillis();
            if (currentTime - lastReadTime >= readDelay) {
                System.out.println("\nAktueller Array-Inhalt:");

                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();

                lastReadTime = currentTime;
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
