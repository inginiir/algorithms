package binary;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountSort {

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new CountSort().run();
        long endTime = System.currentTimeMillis();
        System.out.println("\nAlgorithm time: " + (endTime - startTime) + "ms");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextInt();
        }
        scanner.close();
        sort(inputArray);
    }

    private void sort(int[] array) {
        int[] b = new int[11];
        int n = array.length;
        int[] sortedArray = new int[n];
        for (int value : array) {
            b[value]++;
        }
        for (int i = 1; i <= 10; i++) {
            b[i] = b[i] + b[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            sortedArray[b[array[i]]-1] = array[i];
            b[array[i]]--;
        }
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }
}
