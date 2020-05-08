package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        EditDistance editDistance = new EditDistance();
        editDistance.run();
        long endTime = System.currentTimeMillis();
        System.out.println("\nAlgorithm time: " + (endTime - startTime) + "ms");
    }

    private void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String first = bufferedReader.readLine();
        String second = bufferedReader.readLine();
        bufferedReader.close();

        System.out.println(findOptimalEditDistance(first, second));
    }

    private int findOptimalEditDistance(String first, String second) {
        int n = first.length();
        int m = second.length();
        int fLength = n + 1;
        int sLength = m + 1;

        boolean[][] moveFirst = new boolean[fLength][sLength];
        boolean[][] moveSecond = new boolean[fLength][sLength];
        int[][] d = new int[fLength][sLength];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    d[i][j] = 0;
                } else if (i == 0) {
                    moveSecond[i][j] = true;
                    d[i][j] = j;
                } else if (j == 0) {
                    moveFirst[i][j] = true;
                    d[i][j] = i;
                } else {
                    int res1 = d[i][j - 1] + 1;
                    int res2 = d[i - 1][j] + 1;
                    int res3 = d[i - 1][j - 1] + (first.charAt(i - 1) == second.charAt(j - 1) ? 0 : 1);
                    int result;
                    if (res1 <= res2 && res1 <= res3) {
                        moveSecond[i][j] = true;
                        result = res1;
                    } else {
                        if (res2 <= res3) {
                            moveFirst[i][j] = true;
                            result = res2;
                        } else {
                            moveFirst[i][j] = true;
                            moveSecond[i][j] = true;
                            result = res3;
                        }
                    }
                    d[i][j] = result;
                }
            }
        }
        StringBuilder firstLine = new StringBuilder();
        StringBuilder secondLine = new StringBuilder();

        while (n > 0 || m > 0) {
            boolean mf = moveFirst[n][m];
            boolean ms = moveSecond[n][m];
            if (mf) {
                firstLine.append(first.charAt(n - 1));
                n--;
            } else {
                firstLine.append("-");
            }
            if (ms) {
                secondLine.append(second.charAt(m - 1));
                m--;
            } else {
                secondLine.append("-");
            }
        }
        firstLine.reverse();
        secondLine.reverse();
        System.out.println(firstLine.toString());
        System.out.println(secondLine.toString());
        return d[fLength - 1][sLength - 1];
    }
}
