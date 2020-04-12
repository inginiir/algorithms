package greedy;

import java.util.*;

/**
 * По данным n отрезкам необходимо найти множество точек минимального размера, для которого каждый из отрезков содержит
 * хотя бы одну из точек.
 *
 * В первой строке дано число 1 <= n <= 100 отрезков. Каждая из последующих n строк содержит по два числа
 * 0≤l≤r≤10^9, задающих начало и конец отрезка.
 * Выведите оптимальное число mm точек и сами mm точек. Если таких множеств точек несколько, выведите любое из них.
 */
public class Segment {

    private Long[][] mas;
    private Set<Long> set;

    public Segment(Long[][] mas) {
        this.mas = mas;
    }

    public Long[] answer() {
        Arrays.sort(mas, Comparator.comparingLong(ints -> ints[1]));
        System.out.println(Arrays.deepToString(mas));
        set = new HashSet<>();
        long begin = mas[0][1];
        set.add(begin);
        for (int i = 1; i < mas.length;i++) {
            if (mas[i][0] <= begin && !set.contains(mas[i-1][0])) {
                set.add(begin);
            } else if (!set.contains(mas[i-1][0])) {
                begin = mas[i][0];
                set.add(begin);
            } else if (i == mas.length-1) {
                begin = mas[i][1];
                set.add(begin);
            }
        }
        return set.toArray(new Long[0]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (long integer: set) {
            res.append(integer).append(" ");
        }
        return set.size() + "\n" +  res.toString();
    }
}
