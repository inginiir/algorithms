package binary;

/**
 * Первая строка содержит число 1≤n≤10^5, вторая — массив A[1…n], содержащий натуральные числа, не превосходящие 10^9.
 * Необходимо посчитать число пар индексов n1≤i<j≤n, для которых A[i]>A[j]. (Такая пара элементов называется инверсией
 * массива. Количество инверсий в массиве является в некотором смысле его мерой неупорядоченности: например,
 * в упорядоченном по неубыванию массиве инверсий нет вообще, а в массиве, упорядоченном по убыванию,
 * инверсию образуют каждые два элемента.)
 */

import java.util.Scanner;

public class Inversion {

    private long countOfInversion;
    private int[] temp;
    private int[] array;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Inversion inversion = new Inversion();
        inversion.run();
        long endTime = System.currentTimeMillis();
        System.out.println("\nAlgorithm time: " + (endTime - startTime) + "ms");
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        temp = new int[arraySize];
        mergeSort(0, arraySize);
        System.out.println(countOfInversion);
    }

    private void mergeSort(int left, int right) {
        if (right <= left + 1) return;
        int medium = (left + right) >> 1;
        mergeSort(left, medium);
        mergeSort(medium, right);
        merge(left, medium, right);
    }

    private void merge(int left, int medium, int right) {
        int countArrayA = left;
        int countArrayB = medium;
        for (int i = left; i < right; i++) {
            if (countArrayB == right || (countArrayA < medium && array[countArrayA] <= array[countArrayB])) {
                temp[i] = array[countArrayA];
                countArrayA++;
            } else {
                countOfInversion += medium - countArrayA;
                temp[i] = array[countArrayB];
                countArrayB++;
            }
        }
        System.arraycopy(temp, left, array, left, right - left);
    }

}
