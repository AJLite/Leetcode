class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        ArrayList<String> common=new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<list1.length; i++){
            map.putIfAbsent(list1[i],i);
        }
        
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                sum=i+map.get(list2[i]);
                min=Math.min(min,sum);
            }
        }
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i]) && min==i+map.get(list2[i])){
                list.add(list2[i]);
            }
        }
        String [] result = new String[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }
}
