class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        HashMap<Integer,Integer> counts = new HashMap<>();
        counts.put(sorted[0],0);
        int repeated =1;
        for(int i=1; i<sorted.length;i++){
            if(sorted[i]==sorted[i-1] ){
                 repeated++;
            } else {
                if(repeated>1){
                    counts.put(sorted[i],counts.get(sorted[i-1])+repeated); 
                    repeated =1;
                } else counts.put(sorted[i],counts.get(sorted[i-1])+1);                
            }                 
        }
        for(int i=0; i<nums.length; i++){
            nums[i]= counts.get(nums[i]);
        }
        return nums;
    }
}
