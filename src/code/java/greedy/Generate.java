package greedy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class Generate {


    public static void main(String[] args) throws FileNotFoundException {
        new Generate().run();
    }

    private void run() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("input.txt");
        int n = 10000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            pw.print((char)('a' + random.nextInt(26)));
        }
        pw.close();
    }

}
