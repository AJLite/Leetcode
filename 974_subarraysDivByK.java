class Solution {
    public int subarraysDivByK(int[] nums, int k) {
	
        /*
		1. if number is divisible by k --> number%k =0
		2. if number%k < 0 ---> (number%k) +k   is the actual result
        3. nums [4,5,0,-2,-3,1] --> sum[4,9,9,7,4,5]    (cumulative sum)
        4. (0+-2+-3) = sum[indexOf(-3)]-sum[indexOf(0)-1||0 if the start]  = sum[4]-sum[1] = -5
        
		5. Modulus is also can be cumulative!
               nums[4,5,0,-2,-3,1] --> modOfSums [4,4,4,2,4,0]
				mod of(4,5,0) --> modOfSums[2]-0 = 4
				
             clear? now guess what? 
			 
       6. Subarrays that have a sum divisible by k are discovered by values of modOfSums, how???
			Each repeated number in it tells us about a new divisiblity by k.
			Each new divisiblity will increment the count of subarrays, by what?
			- Increment it by # of times the number repeated!  
		  Prove it yourself!
		  
		  And so, to check repeated numbers .. we use the hashMap!
	  */
	 
        int n = nums.length;
		int [] cumulativeMods = new int[n];   //store cumulative modulus
        int count =0;   //count subarrays
		HashMap <Integer,Integer> repeatedMonitor = new HashMap<>();
		
        repeatedMonitor.put(0,1);  
		//magic hidden zero :P,  next appearing of 0 in cumulative will be the second to the monitor, 
		//if you love to know why, do search xD
		
        cumulativeMods[0]= nums[0]%k<0? (nums[0]%k)+k : nums[0]%k;
        
		//Fill cumulativeMods array
        for(int i=1; i<n; i++){
            cumulativeMods[i] = cumulativeMods[i-1]+nums[i];
            cumulativeMods[i] = cumulativeMods[i]%k <0? (cumulativeMods[i]%k)+k: cumulativeMods[i]%k;
        }               
        
		//count contiguous subarrays by monitoring the repeated items in cumulativeMods
        int toAdd=0;
        for(int i=0; i<n; i++){
            toAdd = repeatedMonitor.getOrDefault(cumulativeMods[i],0); 
            count+= toAdd;
            repeatedMonitor.put(cumulativeMods[i], toAdd+1);
        }
        return count;        
    }
}
