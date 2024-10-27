public class lcm {
    public static void main(String[] args) {
        
    }
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    public static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
