//1512. Number of Good Pairs
class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        int cnt = 0;   
        Map<Integer,Integer> numMap =  new HashMap<>();  
        
        for(int num: nums){
            
            //each previous appearing of the number meaning a good pair
            int numprevCount = numMap.getOrDefault(num, 0);
            cnt += numprevCount;
            
            //update the appearing of number
            numMap.put(num, ++numprevCount);
        }        
        return cnt;
    }
}
