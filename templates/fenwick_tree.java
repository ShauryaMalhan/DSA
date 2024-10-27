public class fenwick_tree {
    public static void main(String[] args) {
        
    }
    static class BIT {
        int bit[], n;

        public BIT(int s) {
            bit = new int[s + 1];
            n = s;
        }

        void add(int i, int diff) {
            while (i <= n) {
                bit[i] += diff;
                i += (i & (-i));
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= (i & (-i));
            }
            return sum;
        }

        int rangeQuery(int l, int r) {
            return query(r) - query(l - 1);
        }
    }
}
