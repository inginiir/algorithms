package greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class HuffmanCoding {

    class Node {
        final int freq;
        String code;

        void buildCode(String code) {
            this.code = code;

        }

        public Node(int freq) {
            this.freq = freq;
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            super(left.freq + right.freq);
            this.left = left;
            this.right = right;
        }
    }

    class LeafNode extends Node {
        char symbol;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + this.code);
        }

        public LeafNode(char symbol, int freq) {
            super(freq);
            this.symbol = symbol;
        }
    }

    public void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("input.txt"));
        String s = scanner.nextLine();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: s.toCharArray()) {
            freq.put(c, freq.containsKey(c) ? freq.get(c) + 1 : 1);
        }
        Map<Character, Node> codeString = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            LeafNode leafNode = new LeafNode(entry.getKey(), entry.getValue());
            queue.add(leafNode);
            codeString.put(entry.getKey(), leafNode);
        }
        int sum = 0;
        while (queue.size() > 1) {
            Node first = queue.poll();
            Node second = queue.poll();
            Node node = new InternalNode(first, second);
            sum += node.freq;
            queue.add(node);
        }
        if (freq.size() == 1) {
            sum = s.length();
        }
        System.out.println(freq.size() + " " + sum);
        Node root = queue.poll();
        if (freq.size() == 1) {
            root.buildCode("0");
        } else {
            root.buildCode("");
        }
        StringBuilder result = new StringBuilder();
        for (char ch: s.toCharArray()) {
            result.append(codeString.get(ch).code);
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new HuffmanCoding().run();
        long endTime = System.currentTimeMillis();
        System.out.println("Algorithm time: " + (endTime - startTime) + "ms");

    }
}
