class Solution {
    public int countCharacters(String[] words, String chars) {
      
        HashMap<Character,  Integer> uniques = new HashMap<>();
    
        for(char c: chars.toCharArray()){
           uniques.put(c,uniques.getOrDefault(c,0)+1);     
        } 
        
        HashMap<Character, Integer> temp = new HashMap<>();
        int count=0;
        boolean isGood = true;
        for(String s: words){
            temp.putAll(uniques);
            isGood = true;
           for(char c: s.toCharArray()){
               if(temp.containsKey(c) && temp.get(c)>0){
                   temp.put(c,temp.get(c)-1);
               } else {
                   isGood=false;
                   break;
               }
           } 
            if(isGood){
                count+= s.length();
            }
        }
        return count;
    }
}
