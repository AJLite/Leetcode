class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); 
		int n =citations.length;
        //in case of  just one paper in the given array
        if(n == 1) return citations[0]==0 ? 0 : 1;
        for(int i = 0; i < n; i++){
            // the sorted arrays means :
			//n-i of papers have at least citations[i] citations 
            // && i of papers have no more than  citations[i] citations 
			
			//read this line in description:
			//if h of n papers have at least h citations
			// h here is the citations[i]  and it has a relation with number of papers, get it?
            if(citations[i] >=n-i) return n -i;
        }
        return 0;
    }
} 
