

import greedy.Segment;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws Exception {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        Long[][] mas = new Long[n][2];
//        for (int i = 0; i < n; i++) {
//            String[] a = br.readLine().split(" ");
//            for (int j = 0; j < 2; j++) {
//                mas[i][j] = Long.parseLong(a[j]);
//            }
//        }
        Long[][] mas1 = {{1L,2L},{2L,3L},{3L,4L},{4L,5L},{5L,6L}};
        Long[][] mas2 = {{5L,6L},{4L,7L},{3L,8L},{2L,9L},{1L,10L}};
        Long[][] mas3 = {{1L,2L},{3L,4L},{5L,6L},{7L,8L},{9L,10L}};
        Segment segment1 = new Segment(mas1);
        Segment segment2 = new Segment(mas2);
        Segment segment3 = new Segment(mas3);
        segment1.answer();
        System.out.println(segment1.toString());
        segment2.answer();
        System.out.println(segment2.toString());
        segment3.answer();
        System.out.println(segment3.toString());
    }
}
