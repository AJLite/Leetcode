class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //do sliding window approach, but no need for a map
        
        int N = nums.length;  
        int start = 0, end = 0;     
        int minLen = Integer.MAX_VALUE;        
        int sum = 0;
        
        while(end < N){       
            sum += nums[end];         
            end++;
            
            while(sum >= target){              
                minLen = Math.min(minLen, (end - start));              
                sum -= nums[start];                
                start++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
