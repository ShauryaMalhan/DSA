public class segment_tree {
    public static void main(String[] args) {
        
    }
    
    static class SegTreePointMax {
        public int l, r;
        SegTreePointMax left, right;
        int max;

        public SegTreePointMax(int l, int r, int[] a) {
            this.l = l;
            this.r = r;
            if (l == r) {
                max = a[l];
            } else {
                int m = (l + r) / 2;
                left = new SegTreePointMax(l, m, a);
                right = new SegTreePointMax(m + 1, r, a);
                max = Math.max(left.max, right.max);
            }
        }

        public void update(int i, int v, SegTreePointMax node) {
            if (node.l == node.r) {
                node.max = v;
            } else {
                int m = (node.l + node.r) / 2;
                if (i <= m) {
                    update(i, v, node.left);
                } else {
                    update(i, v, node.right);
                }
                node.max = Math.max(node.left.max, node.right.max);
            }
        }

        public int rangeMax(int l, int r, SegTreePointMax node) {
            int max = 0;
            if (node.l >= l && node.r <= r) {
                max = node.max;
            } else if (node.l > r || node.r < l) {
                max += 0;
            } else {
                max += Math.max(rangeMax(l, r, node.left), rangeMax(l, r, node.right));
            }
            return max;
        }
    }
    static class SegTreePointMin {
        public int l, r;
        SegTreePointMin left, right;
        int min;
    
        public SegTreePointMin(int l, int r, int[] a) {
            this.l = l;
            this.r = r;
            if (l == r) {
                min = a[l];
            } else {
                int m = (l + r) / 2;
                left = new SegTreePointMin(l, m, a);
                right = new SegTreePointMin(m + 1, r, a);
                min = Math.min(left.min, right.min);
            }
        }
    
        public void update(int i, int v, SegTreePointMin node) {
            if (node.l == node.r) {
                node.min = v;
            } else {
                int m = (node.l + node.r) / 2;
                if (i <= m) {
                    update(i, v, node.left);
                } else {
                    update(i, v, node.right);
                }
                node.min = Math.min(node.left.min, node.right.min);
            }
        }
    
        public int rangeMin(int l, int r, SegTreePointMin node) {
            if (node.l >= l && node.r <= r) {
                return node.min;
            } else if (node.l > r || node.r < l) {
                return Integer.MAX_VALUE;
            }
            return Math.min(rangeMin(l, r, node.left), rangeMin(l, r, node.right));
        }
    }
}
