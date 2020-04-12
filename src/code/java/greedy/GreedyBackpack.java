package greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyBackpack {

    class Item {
        int cost;
        int weight;

        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return cost + " " + weight;
        }
    }

    private void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("in.txt"));
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(items, (item, item1) -> -Long.compare(item.cost * item1.weight, item1.cost * item.weight));
        double res = 0;
        for (Item item : items) {
            if (item.weight <= w) {
                res += item.cost;
                w -= item.weight;
            } else {
                res += 1.0 * item.cost * w / item.weight;
                break;
            }
        }

        System.out.printf("%.3f\n", res);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new GreedyBackpack().run();
        long endTime = System.currentTimeMillis();
        System.out.println("Algorithm time: " + (endTime - startTime) + "ms");
    }


}
