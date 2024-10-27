public class knuth_morris_prat {
    public static void main(String[] args) {
        
    }
    public static void kmp(int[] lps, String s) {
        int length = 0;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
