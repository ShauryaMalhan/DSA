public class modInverse {
    public static void main(String[] args) {
        System.out.println(moduloInverse(5, 6));
    }
    public static long moduloInverse(long A, long M)
    {
        long m0 = M;
        long y = 0, x = 1;

        if (M == 1)
            return 0;

        while (A > 1) {
            long q = A / M;

            long t = M;

            M = A % M;
            A = t;
            t = y;

            y = x - q * y;
            x = t;
        }

        if (x < 0)
            x += m0;

        return x;
    }
}
