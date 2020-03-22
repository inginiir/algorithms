

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        List<Integer> integers = new ArrayList<>();
        for (String s : a) {
            integers.add(Integer.parseInt(s));
        }
        System.out.println(Fibonacci.fib(integers.get(0)));

    }
}
