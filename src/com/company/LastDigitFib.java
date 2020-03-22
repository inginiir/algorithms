package com.company;

public class LastDigitFib {
    public static long fib(int n) {
        long [] mas = new long[n+1];
        mas[0] = 0;
        mas[1] = 1;
        for (int i = 2; i <= n; i++) {
            mas[i] = mas[i-2] + mas[i-1];
        }
        return mas[n];
    }
}
