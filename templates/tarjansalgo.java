import java.util.ArrayList;

public class tarjansalgo {
    public static int timer;
    public static ArrayList<int[]> bridges;
    public static void main(String[] args) {
        int n = 6;
        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        bridges = new ArrayList<>();
        timer = 1;
    }
    public static void dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low) {
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        for(int i : adj.get(node)) {
            if(i != parent) {
                if(!vis[i]){
                    dfs(i, node, vis, adj, tin, low);
                    low[node] = Math.min(low[node], low[i]);
                    if(low[i] > tin[node]) {
                        bridges.add(new int[]{i, node});
                    }
                } else {
                    low[node] = Math.min(low[node], low[i]);
                }
            }
        }
    }
}
