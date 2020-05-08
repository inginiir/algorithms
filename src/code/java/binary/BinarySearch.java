package binary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new BinarySearch().run();
        long endTime = System.currentTimeMillis();
        System.out.println("\nAlgorithm time: " + (endTime - startTime) + "ms");
    }

    public void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("binaryInput.txt"));
        int n = scanner.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[] desiredArray = new int[k];
        for (int i = 0; i < k; i++) {
            desiredArray[i] = scanner.nextInt();
        }
        scanner.close();
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = search(inputArray, desiredArray[i]);
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private int search(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mediumIndex = (right + left) >> 2;
            if (key == array[mediumIndex]) {
                return mediumIndex + 1;
            } else if (key < array[mediumIndex]) {
                right = mediumIndex - 1;
            } else {
                left = mediumIndex + 1;
            }
        }
        return -1;
    }

}
