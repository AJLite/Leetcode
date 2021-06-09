class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       Set<Integer> a = new HashSet<>();
        for (int v : nums1) {
            a.add(v);
        }
        Set<Integer> b = new HashSet<>();
        for (int v : nums2) {
            if (a.contains(v)) {
                b.add(v);
            }
        }
        
        int i = 0;
        int[] res = new int[b.size()];
        
        for (Integer v : b) {
            res[i++] = v;
        }
        return res;

    }
}
