class Solution {
    public int minSubarray(int[] nums, int p) {
         int n = nums.length, res = Integer.MAX_VALUE;
        long cumulativeSums[] = new long[n + 1];  //cumulativeSums array 
        for (int i = 0; i < n; i++) 
            cumulativeSums[i + 1] = cumulativeSums[i] + nums[i];
        if (cumulativeSums[n] < p) return -1; //for example: nums = [1,2,3], p = 7
        
        // compute & check divisibility of total sum       
        long totalMod = cumulativeSums[n] % p; // rmv = mod of total sum of array
        //if sum of all array divisible by b --> return empty subarray
        if (totalMod == 0) return 0;  //for example: nums = [1,2,3], p = 3
               
        //we need to store mods of remaining arrays sum with list of indecies
        //each repeating in these mods means new divisibility in the ramaining subarray sum!! 
        Map<Long, List<Integer>> map = new HashMap<>();
        long currMod;
        long remMod;
         //[1,2,3,7,1] p=3
        for (int i = 0; i < n + 1; i++) {
            currMod = cumulativeSums[i] % p;
            //for example, at index 1
            //current subarray[1,2] --> currmod 0  
            //totMod --> 2  
            //remaining subarray [3,7,1] --> remMod = 2
            //how we can compute it using curr and tot mods?? without extracting the array?
            //long remMod = (currMod -totalMod) <0? (currMod-totalMod +p) % p : (currMod-totalMod)%p; 
            remMod =  (currMod-totalMod +p) % p ;  //the same 
            
            //if remMod is repeated .. then we need to smallen the subarray if it an be smaller
            if (map.containsKey(remMod)) 
                res = Math.min(res, i - map.get(remMod).get(map.get(remMod).size() - 1));
            map.computeIfAbsent(currMod, k -> new ArrayList<>());
            map.get(currMod).add(i);
        }
		// can not remove all the array or no result
        return res == n || res == Integer.MAX_VALUE? -1 : res; 
        
              
    }
}
