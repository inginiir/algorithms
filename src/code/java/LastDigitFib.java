/**
 *
 * Finding last digit of Fibonacci number
 */
public class LastDigitFib {

    public static long fib(int n) {
        int a = 0, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % 10;
            a = b;
            b = c;
        }
        return c;
    }
}
