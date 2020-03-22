public class Fibonacci {

    public static int fib(int n) {
        int [] mas = new int[n+1];
        mas[0] = 0;
        mas[1] = 1;
        for (int i = 2; i <= n; i++) {
            mas[i] = mas[i-2] + mas[i-1];
        }
        return mas[n];
    }
}
//0 1 1 2 3 5 8 13 21 34 55 89 144