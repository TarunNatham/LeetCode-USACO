class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int k = nums.length;
        for(int i = 0; i < k; i++) {
            if(map.containsKey(nums[i]) && map.get(nums[i]) >= 2) {
                k--;
                for(int j = i; j < k; j++) {
                    nums[j] = nums[j+1];
                }
                nums[k] = 0;
                i--;
            } else if(map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }
        return k;
    }
}