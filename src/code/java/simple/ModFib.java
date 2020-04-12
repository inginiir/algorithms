package simple;

import java.math.BigInteger;

/**
 * Finding the module of the division n % m. n - number of simple.Fibonacci [1..10^18] m - number [2..10^5]
 */
public class ModFib {

    public static long modDiv(long n, int m) {


//        BigInteger a = BigInteger.valueOf(0);
//        BigInteger b = BigInteger.valueOf(1);
//        BigInteger c = BigInteger.ZERO;
        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 2; i <= n; i++) {
            c = (a + b) % 100_000;
            a = b;
            b = c;
        }
        return c % m;
    }
}
