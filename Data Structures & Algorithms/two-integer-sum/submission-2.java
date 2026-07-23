class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pairings = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (pairings.containsKey(pair)) {
                return new int[] {pairings.get(pair), i};
            } else {
                pairings.put(nums[i], i);
            }
        }
        return null;
    }
}
