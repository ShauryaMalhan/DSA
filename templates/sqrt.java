public class sqrt {
    public static void main(String[] args) {
        
    }
    public static long sqrt(long x) {
        long i = 0;
        long j = Integer.MAX_VALUE;
        while (i < j) {
            long mid = i + (j - i) / 2;
            if (mid * mid <= x) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i - 1;
    }
}
