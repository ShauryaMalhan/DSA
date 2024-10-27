import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class mex {
    public static void main(String[] args) {
        
    }
    public static int calcMex(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for (int i = 0; i <= list.size(); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return list.size();
    }
}
