class Solution {
    HashMap<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        if(nums.length == 0) {
            return false;
        }
        int index = 0;
        int num = nums[0];
        if(canJumpCurrent(num, nums, index)) {
              return true;
        }  
        return false;
    }
    public boolean canJumpCurrent(int num, int[] nums, int index) {
        if(memo.containsKey(index)) {
            return memo.get(index);
        }
        if(num == 0) {
            return false;
        }
        if(num + 1 >= nums.length - index) {
            return true;
        }
        for(int i = 1; i <= num; i++) {
            if(canJumpCurrent(nums[index + i], nums, index + i)) {
                memo.put(index, true);
                return true;
            }
        }
        memo.put(index, false);
        return false;
    }
}