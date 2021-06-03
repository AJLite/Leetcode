class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        int len = words.length;
        List<List<Integer>> result = new ArrayList<>();
        HashMap<String,Integer> wordMap = new HashMap<>();
        
        //add reversed of words at indicies
        for(int i=0; i<len; i++){
           String reversed = new StringBuilder(words[i]).reverse().toString();
            wordMap.put(reversed,i);
        }
        
        for(int i=0; i<len; i++){
            String curr = words[i];
            int wordLen = curr.length();
            
            //if reversed word is stored in map
            if(wordMap.containsKey(curr)){
                addToResult(result,i,wordMap.get(curr));
            }
            
            //check prefix
            for(int j=0; j<wordLen; j++){
                 //Example: race & car 
                if(isPalindrome(curr,j,wordLen-1)){
                    String prefix = curr.substring(0, j);
                   if(wordMap.containsKey(prefix)){                      
                        addToResult(result,i,wordMap.get(prefix));
                     } 
                }
            }
            
            //check suffix
            for(int j= wordLen-1; j>=0; j--){
                if(isPalindrome(curr,0,j)){
                    String suffix = curr.substring(j+1);
                   if(wordMap.containsKey(suffix)){
                        addToResult(result,wordMap.get(suffix),i);
                     } 
                }
            }
        }
        
        return result;     
    
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    
    public void addToResult(List<List<Integer>> res, int i, int j){
        if(i==j) return;
        res.add(Arrays.asList(i,j));
    }
}


/*
Thought process:
        The easiest pairs are simply reversed versions of each other
            Example: 'abcd' + 'dcba'
        Storing the reverse of input word will help us look up these
        easy pairs quickly. We also need to get the indexes fast to
        store pairs (i, j) in result. Let's handle quick word lookups
        and index lookups with a single HashMap
        
        The key = reversedWord & value = index i
        
        Now we can check for easy pairs like so:
            String curr = word[i]
            if (wordMap.containsKey(curr))
                j is wordMap.get(curr)
                the pair is now (i, j)
        
        The next case is when two different words can be combined
            Example: 'race' + 'car'
        We can see that splitting 'race' to 'rac' and 'e' works.
        'car' was reversed & stored in the wordMap as ('rac', idx)
        So the map does contain 'rac' as a key. If 'e' is a palindrome
        then we can combine 'race' with 'car'.
        
        We can check for these pairs like so:
            String curr = word[i]
            int wordLen = cufr.length();
            //Try all suffixes
            for j = 0 -> wordLen
                //Suffix 'e' is palindrome
                if isPalindrome(curr, j, wordLen - 1)
                    //Check if remaining prefix 'rac' exists in wordMap
                    String prefix = curr.substring(0, j)
                    if wordMap.containsKey(prefix)
                        addToResults(result, i, wordMap.get(prefix))


        The next case is when two different words can be combined
        but in a different order.
            Example: 'nu' + 'run'
        We can see that splitting 'run' to 'r' and 'un' works.
        'nu' was reversed & stored in the wordMap as ('un', idx)
        So the map does contain 'un' as a key. If 'r' is a palindrome
        then we can combine 'nu' with 'run'. The main difference
        this time is we are removing from the start of a word like 'run'
        and not from the end when we look at 'race'
        
        We can check for these pairs simliarly as before like so:
            String curr = word[i]
            int wordLen = cufr.length();
            for (j = wordLen-1  ->  0
                //Prefix 'r' is palindrome
                if isPalindrome(curr, 0, j) 
                    //Check if remaining suffix 'un' exists in wordMap
                    String suffix = curr.substring(j + 1)
                    if wordMap.containsKey(suffix)
                        addToResults(result, wordMap.get(suffix), i)
                
    
    These 3 Cases can be handled in a single loop like so:
        //Find palindrome pairs
        for i = 0 -> len
            String curr = words[i]
            Check Case 1: Have Reverse of curr
                updateResult
                
            Check Case 2: Removing prefix from curr
                updateResult
            
            Check Case 3: Removing suffix from curr
                updateResult
        //end for loop
        
        return result
*/
