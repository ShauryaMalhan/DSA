import java.util.*;

// lets say we need to find the value in the array having the maximum frequncy in a subarray of size k.

public class sorthashmapbyvalues {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }

    }
    public static class min_max_value {
        static HashMap<Integer, Integer> mp;
        static TreeMap<Integer, Integer> mp1;
        int n;
        min_max_value(int m) {
            n = m;
            mp = new HashMap<>();
            mp1 = new TreeMap<>();
        }

        public static void add (int element) {
            int l = element;
            if(!mp.containsKey(l)) {
                mp.put(l, mp.getOrDefault(l, 0) + 1);
                int r = mp.get(l);
                mp1.put(r, mp1.getOrDefault(r, 0) + 1);
            } else {
                int r = mp.get(l);
                mp1.put(r, mp1.getOrDefault(r, 0) - 1);
                if(mp1.get(r) == 0) mp1.remove(r);
                mp.put(l, mp.getOrDefault(l, 0) + 1);
                r = mp.get(l);
                mp1.put(r, mp1.getOrDefault(r, 0) + 1);
            }
        }

        public static void del (int element) {
            int l = element;
            int r = mp.get(l);
            mp1.put(r, mp1.getOrDefault(r, 0) - 1);
            if(mp1.get(r) == 0) mp1.remove(r);
            mp.put(l, mp.getOrDefault(l, 0) - 1);
            r = mp.get(l);
            mp1.put(r, mp1.getOrDefault(r, 0) + 1);
        }

        public static int max_key () {
            return mp1.lastKey();
        }

        public static int min_key () {
            return mp1.firstKey();
        }
    }
}
