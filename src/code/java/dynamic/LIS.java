package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LIS {

    private static int arraySize;

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        LIS lis = new LIS();
        lis.run();
        long endTime = System.currentTimeMillis();
        System.out.println("\nAlgorithm time: " + (endTime - startTime) + "ms");
    }

    private void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        arraySize = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[arraySize];
        String[] arr = bufferedReader.readLine().split(" ");
        for (int i = 0; i < arraySize; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        bufferedReader.close();
        findLisIndexes(array);
    }

    private void findLisIndexes(int[] inputArray) {
        int[] tempArray = new int[arraySize];
        int[] indexArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            tempArray[i] = 1;
            indexArray[i] = -1;
            for (int j = 0; j < i; j++) {
                if (inputArray[j] >= inputArray[i] && (tempArray[j] + 1) > tempArray[i]) {
                    tempArray[i] = tempArray[j] + 1;
                    indexArray[i] = j;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < arraySize; i++) {
            answer = Math.max(answer, tempArray[i]);
        }
        System.out.println(answer);
        int[] output = new int[answer];
        int k = 0;
        for (int i = 1; i < arraySize; i++) {
            if (tempArray[i] > tempArray[k]) {
                k = i;
            }
        }
        int j = answer;
        while (k >= 0) {
            output[j - 1] = k + 1;
            j--;
            k = indexArray[k];
        }
        for (int i : output) {
            System.out.print(i + " ");
        }
    }

    private int findLIS(int[] inputArray) {
        int[] tempArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            tempArray[i] = 1;
            for (int j = 0; j < i; j++) {
                if (inputArray[j] < inputArray[i] && (tempArray[j] + 1) > tempArray[i]
                        && inputArray[i] % inputArray[j] == 0) {
                    tempArray[i] = tempArray[j] + 1;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < arraySize; i++) {
            answer = Math.max(answer, tempArray[i]);
        }
        return answer;
    }
}
