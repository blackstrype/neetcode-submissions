class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pairings = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int pairing = target - nums[i];
            Integer pairIndex = pairings.get(pairing);
            if (pairIndex != null) {
                return new int[] {pairIndex, i};
            } else {
                pairings.put(nums[i], i);
            }
        }
        return null;
    }
}
