package simple;

public class NOD {

    public static long findNOD(long a, long b) {
        if (a == 0) return b;
        else if (b == 0) return a;
        else if (a == b) return a;
        else if (a > b) return findNOD(a%b, b);
        else return findNOD(a, b%a);
    }

}
