class Solution {
    public int numIdenticalPairs(int[] nums) {
        int cnt = 0;   
        Map<Integer,Integer> numMap =  new HashMap<>();        
        for(int num: nums){
            int numprevCount = numMap.getOrDefault(num, 0);
            cnt += numprevCount;
            numMap.put(num, ++numprevCount);
        }        
        return cnt;
    }
}
