class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) {
            return new ArrayList<String>();
        }
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> map2 = new HashMap<String, String>();
        for(int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if(map.containsKey(sub)) {
                if(!map2.containsKey(sub)) {
                    map2.put(sub, sub);
                }
            } else {
                map.put(sub, sub);
            }
        }
        Set<String> keySet = map2.keySet();
        ArrayList<String> arrlist = new ArrayList<String>(keySet);
        return arrlist;
    }
}