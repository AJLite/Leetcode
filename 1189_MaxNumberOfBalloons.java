class Solution {
    public int maxNumberOfBalloons(String text) {
      //Hash
        String s = "balon";
        HashMap<Character,Integer> hash = new HashMap<>();
        for(char c: text.toCharArray()){
            if(s.indexOf(c)>=0)
                hash.put(c,hash.getOrDefault(c,0)+1);
        }
         hash.put('l',hash.getOrDefault('l',0)/2);
         hash.put('o',hash.getOrDefault('o',0)/2);
        
        int min = text.length();
        for(char c: s.toCharArray()){
                min = Math.min(hash.getOrDefault(c,0),min);
        }
        return min;
    }
  
  public int maxNumberOfBalloonsArray(String text) {
        
        int[] count = new int[26];
        
        for (char c : text.toCharArray ()) {
            ++count[c - 'a'];
        }
        
        int min = count[1];
        min = Math.min (min, count[0]);
        min = Math.min (min, count[11] / 2);
        min = Math.min (min, count[14] / 2);
        min = Math.min (min, count[13]);
        
        return min;
    }
}
